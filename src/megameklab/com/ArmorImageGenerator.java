package megameklab.com;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import megameklab.com.armorutils.ArmorPipImage;

public class ArmorImageGenerator {

	public static void main(String[] args) {
		generateVTOLPips();
	}
	
	private static void generateVTOLPips() {
		ArmorPipImage armor = new ArmorPipImage(2.41, 6);
		
		armor.addRow(5, "FR.0", 472.5, 77);
		armor.addSquareGrid(7, 3, "FR.0", 466.5, 83);
		armor.addSquareGrid(5, 2, "FR.0", 472.5, 101);
		
		armor.addPip("LS.0", 454.5, 102);
		armor.addPip("LS.0", 454.5, 108);
		armor.addPip("LS.0", 460.5, 108);
		armor.addSquareGrid(3, 5, "LS.0", 454.5, 114);
		armor.addSquareGrid(2, 4, "LS.0", 461.5, 160.5);
		armor.addColumn(4, "LS.0", 467.5, 184.5);

		armor.addPip("RS.0", 514, 102);
		armor.addPip("RS.0", 508, 108);
		armor.addPip("RS.0", 514, 108);
		armor.addSquareGrid(3, 5, "RS.0", 502, 114);
		armor.addSquareGrid(2, 4, "RS.0", 501, 160.5);
		armor.addColumn(4, "RS.0", 501, 184.5);

		armor.addColumn(10, "RR.0", 485.5, 252);
		armor.addSquareGrid(2, 10, "RR.0", 482.5, 252);

		armor.addPip("RO.0", 405, 149);
        armor.addPip("RO.0", 562, 149);
        
        armor.addColumn(3, "FR.IS", 478, 120, 9, 1.86);
        armor.addColumn(3, "FR.IS", 485, 120, 9, 1.86);
        armor.addColumn(3, "FR.IS", 492, 120, 9, 1.86);        
        armor.addColumn(6, "LS.IS", 478, 164, 7, 1.86);
        armor.addColumn(6, "RS.IS", 491, 164, 7, 1.86);
		armor.addColumn(3, "RR.IS", 485.5, 220, 9, 1.86);
        armor.addSquareGrid(2, 3, "RR.IS", 481, 220, 9, 1.86);
        armor.addRow(7, "RO.IS", 424.5, 149, 20, 1.86);
        
        File f = new File("data/images/recordsheets/Armor VTOL.svg");
        try {
			PrintWriter pw = new PrintWriter(f);
			armor.writeSVG(pw);
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
