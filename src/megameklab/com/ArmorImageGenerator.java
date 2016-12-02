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
		ArmorPipImage armor = new ArmorPipImage(2.5);

		double[] topColumn = { 472.5, 77 };
        double[] middleColumn = { 466.5, 83 };
        double[] bottomColumn = { 472.5, 101 };
        double[] pipShift = { 6, 6 };

        int totalArmor = 36;
        
        int pips = Math.min(5, totalArmor);
        totalArmor -= pips;
        int pipNum = 0;
        for (int pos = 1; pos <= pips; pos++) {
        	armor.addPip("FR:" + pipNum, topColumn[0], topColumn[1]);
            topColumn[0] += pipShift[0];
            pipNum++;
        }

        pips = Math.min(21, totalArmor);
        totalArmor -= pips;
        for (int pos = 0; pos < pips; pos++) {
        	armor.addPip("FR:" + pipNum, middleColumn[0] + pipShift[0] * (pos % 7),
        			middleColumn[1] + pipShift[1] * (pos / 7));
        	pipNum++;
        }
        
        for (int pos = 0; pos < totalArmor; pos++) {
        	armor.addPip("FR:" + pipNum, bottomColumn[0] + pipShift[0] * (pos % 5),
        			bottomColumn[1] + pipShift[1] * (pos / 5));
        	pipNum++;
        }

        topColumn = new double[] { 454.5, 114 };
        double rsOffset = 59.5;

        totalArmor = 30;
        pipNum = 0;
        
        if (totalArmor > 0) {
        	armor.addPip("LS:" + pipNum, topColumn[0], topColumn[1] - pipShift[1] * 2);
        	armor.addPip("RS:" + pipNum, topColumn[0] + rsOffset, topColumn[1] - pipShift[1] * 2);
            totalArmor--;
            pipNum++;
        }
        if (totalArmor > 0) {
        	armor.addPip("LS:" + pipNum, topColumn[0], topColumn[1] - pipShift[1]);
        	armor.addPip("RS:" + pipNum, topColumn[0] + rsOffset, topColumn[1] - pipShift[1]);
            totalArmor--;
            pipNum++;
        }
        if (totalArmor > 0) {
        	armor.addPip("LS:" + pipNum, topColumn[0] + pipShift[0], topColumn[1] - pipShift[1]);
        	armor.addPip("RS:" + pipNum, topColumn[0] + rsOffset - pipShift[0], topColumn[1] - pipShift[1]);
            totalArmor--;
            pipNum++;
        }
        
        pips = Math.min(15, totalArmor);
        totalArmor -= pips;
        for (int pos = 0; pos < pips; pos++) {
        	armor.addPip("LS:" + pipNum, topColumn[0] + pipShift[0] * (pos % 3),
        			topColumn[1] + pipShift[1] * (pos / 3));
        	armor.addPip("RS:" + pipNum, topColumn[0] + rsOffset - pipShift[0] * (pos % 3),
        			topColumn[1] + pipShift[1] * (pos / 3));
        	pipNum++;
        }
        
        topColumn[0] += pipShift[0] + 1;
        topColumn[1] += pipShift[1] * 7.75;
        
        pips = Math.min(8, totalArmor);
        totalArmor -= pips;
        for (int pos = 0; pos < pips; pos++) {
        	armor.addPip("LS:" + pipNum, topColumn[0] + pipShift[0] * (pos % 2),
        			topColumn[1] + pipShift[1] * (pos / 2));
        	armor.addPip("LS:" + pipNum, topColumn[0] + rsOffset - 2 - pipShift[0] * (2 + pos % 2),
        			topColumn[1] + pipShift[1] * (pos / 2));
        	pipNum++;
        }
        topColumn[0] += pipShift[0];
        topColumn[1] += pipShift[1] * 4;
        pips = Math.min(4, totalArmor);
        totalArmor -= pips;
        for (int pos = 0; pos < pips; pos++) {
        	armor.addPip("LS:" + pipNum, topColumn[0], topColumn[1]);
        	armor.addPip("RS:" + pipNum, topColumn[0] + rsOffset - pipShift[0] * 4 - 2, topColumn[1]);
        	topColumn[1] += pipShift[1];
        	pipNum++;
        }
        
        armor.addPip("RO:0", 405, 149.5);
        armor.addPip("RO:1", 562, 149.5);
        
        totalArmor = 24;
        pipNum = 0;
        topColumn = new double[] { 482.5, 251 };
        pips = Math.min(20, totalArmor);
        totalArmor -= pips;
        for (int pos = 0; pos < pips; pos++) {
        	armor.addPip("RR:" + pipNum, topColumn[0] + pipShift[0] * (pos % 2),
        			topColumn[1] + pipShift[1] * (pos / 2));
        	pipNum++;        	
        }
        
        
        File f = new File("data/images/recordsheets/armor test/vtol.svg");
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
