package megameklab.com;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import megamek.common.Aero;
import megamek.common.Entity;
import megamek.common.EntityWeightClass;
import megamek.common.LandAirMech;
import megamek.common.MechFileParser;
import megamek.common.MechSummary;
import megamek.common.MechSummaryCache;
import megamek.common.QuadMech;
import megamek.common.Tank;
import megamek.common.TripodMech;
import megamek.common.loaders.EntityLoadingException;

public class ArmorSorter {
	
    public static void main(String[] args) {
    	while (!MechSummaryCache.getInstance().isInitialized()) {
    		try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	Map<String,Map<String,Map<Integer,List<MechSummary>>>> map = new HashMap<>();
		try {
	    	for (MechSummary ms : MechSummaryCache.getInstance().getAllMechs()) {
	            Entity entity = new MechFileParser(
					        ms.getSourceFile(), ms.getEntryName())
					        .getEntity();
	            String recordSheet = getRecordSheet(ms.getUnitType(), entity);
	    		map.putIfAbsent(recordSheet, new HashMap<>());
	    		for (int loc = 0; loc < entity.locations(); loc++) {
	    			if (entity.getArmor(loc) == 0) {
	    				continue;
	    			}
	        		map.get(recordSheet).putIfAbsent(entity.getLocationName(loc), new TreeMap<>());
	        		map.get(recordSheet).get(entity.getLocationName(loc)).putIfAbsent(entity.getArmor(loc), new ArrayList<>());
	        		map.get(recordSheet).get(entity.getLocationName(loc)).get(entity.getArmor(loc)).add(ms);
	    		}
	    	}
		} catch (EntityLoadingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (String recordSheet : map.keySet()) {
			File dir = new File("data/armor reports");
			File f = new File(dir, recordSheet + ".txt");
            try {
				BufferedWriter w = new BufferedWriter(new FileWriter(f));
				for (String loc : map.get(recordSheet).keySet()) {
					w.write(loc);
					w.newLine();
					for (int armor : map.get(recordSheet).get(loc).keySet()) {
						w.write(String.valueOf(armor));
						w.newLine();
						for (MechSummary ms : map.get(recordSheet).get(loc).get(armor)) {
							w.write("\t");
							w.write(ms.getName());
							w.write(" (");
							w.write(ms.getSourceFile().getPath());
							w.write(")");
							w.newLine();
						}
					}
				}
				w.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
    }
    
    private static String getRecordSheet(String unitType, Entity en) {
        switch (unitType) {
        case "Mek":
        	if (en instanceof QuadMech) {
        		if (en.getWeight() > 100) {
        			return "Superheavy Quad Mech";
        		} else {
        			return "Quad Mech";
        		}
        	} else if (en instanceof TripodMech) {
        		if (en.getWeight() > 100) {
        			return "Superheavy Tripod Mech";
        		} else {
        			return "Tripod Mech";
        		}
        	} else if (en instanceof LandAirMech) {
        		return "Land Air Mech";
        	} else if (en.getWeight() > 100) {
        		return "Superheavy Mech";
        	} else {
        		return "Biped Mech";
        	}
        case "Tank":
        	switch (EntityWeightClass.getWeightClass(en.getWeight(), en)) {
        	case EntityWeightClass.WEIGHT_LARGE_SUPPORT:
        		return "Large Ground Support Vehicle";
        	case EntityWeightClass.WEIGHT_SUPER_HEAVY:
        		return "Superheavy Ground Vehicle";
        	default:
        		if (((Tank)en).hasNoDualTurret()) {
        			return "Ground Vehicle";
        		} else {
        			return "Advanced Ground Vehicle";
        		}
        	}
        case "VTOL":
        	if (((Tank)en).hasNoTurret()) {
        		return "VTOL";
        	} else {
        		return "Advanced VTOL";
        	}
        case "Naval":
        	if (en.getWeight() > 300) {
        		return "Large Naval Vehicle";
        	} else {
        		return "Naval Vehicle";
        	}
        case "Aero":
        	return "Aerospace Fighter";
        case "Small Craft":
        	if (((Aero)en).isSpheroid()) {
        		return "Spheroid Small Craft";
        	} else {
        		return "Aerodyne Small Craft";
        	}
        case "Dropship":
        	if (((Aero)en).isSpheroid()) {
        		return "Spheroid DropShip";
        	} else {
        		return "Aerodyne DropShip";
        	}
        case "Conventional Fighter":
        case "ProtoMek":
        case "Jumpship":
        case "Warship":
        case "Space Station":
        	return unitType;
        }
        return null;
    }
}
