package megameklab.com.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Utility for generating SVG files for armor and structure pips.
 * Each pip is given a unique id of the formation LOC.GROUP.INDEX
 * LOC is the entity location abbreviation (such as CT or LS).
 * GROUP is an index that allows distinguishing of multiple pip patterns within the same
 * section, such as one layout with lower density which is less busy or easier to read, and
 * another higher-density layout that allows more pips to appear on the record sheet. For
 * structure the index should be "IS".
 * INDEX is the integer position within the list of pips with the same location and group index.
 * 
 * LOC.GROUP is usually passed to construction methods as a single string.
 * 
 * @author Neoancient
 *
 */

public class ArmorPipImage {
	
	private double defaultRadius = 2.41;
	private double defaultSpacing = 6;
	private Map<String,List<Pip>> pips;
	
	public ArmorPipImage() {
		pips = new HashMap<>();		
	}
	
	public ArmorPipImage(double radius, double spacing) {
		this();
		defaultRadius = radius;
		defaultSpacing = spacing;
	}
	
	/**
	 * Adds a single pip to the image.
	 * 
	 * @param location	the entity location abbreviation
	 * @param group		the group index within the location for this pip
	 * @param x			the X coordinate of the top left corner of the pip's bounding rectangle
	 * @param y			the Y coordinate of the top left corner of the pip's bounding rectangle
	 * @param radius	the radius of the pip
	 * @return			the generated pip
	 */
	public Pip addPip(String location, int group, double x, double y, double radius) {
		return addPip(location + "." + group, x, y, radius);
	}
	
	/**
	 * add a pip using the default radius
	 */
	public Pip addPip(String location, int group, double x, double y) {
		return addPip(location + "." + group, x, y, defaultRadius);
	}
	
	/**
	 * add a pip with the location and group index passed as a single String
	 */
	public Pip addPip(String section, double x, double y, double radius) {
		pips.putIfAbsent(section, new ArrayList<>());
		Pip pip = new Pip(x, y, radius);
		pips.get(section).add(pip);
		return pip;
	}
	
	/**
	 * add a pip with the location and group index passed as a single String using the default radius
	 */
	public Pip addPip(String section, double x, double y) {
		return addPip(section, x, y, defaultRadius);
	}
	
	/**
	 * add a horizontal row of pips
	 * 
	 * @param count		the number of pips to add
	 * @param section	the section key, denoting the location and group index
	 * @param posX		the X coordinate of the leftmost pip
	 * @param posY		the Y coordinate of the pips
	 * @param space		the horizontal spacing between pips
	 * @param radius	the radius of each pip
	 */
	public void addRow(int count, String section, double posX, double posY, double space, double radius) {
		for (int i = 0; i < count; i++) {
			addPip(section, posX, posY, radius);
			posX += space;
		}
	}
	
	/**
	 * add a horizontal row of pips using the default spacing and radius
	 */
	public void addRow(int count, String section, double posX, double posY) {
		addRow(count, section, posX, posY, defaultSpacing, defaultRadius);
	}
	
	/**
	 * add a vertical column of pips
	 * 
	 * @param count		the number of pips to add
	 * @param section	the section key, denoting the location and group index
	 * @param posX		the X coordinate of the pips
	 * @param posY		the Y coordinate of the topmost pip
	 * @param space		the vertical spacing between pips
	 * @param radius	the radius of each pip
	 */
	public void addColumn(int count, String section, double posX, double posY, double space, double radius) {
		for (int i = 0; i < count; i++) {
			addPip(section, posX, posY, radius);
			posY += space;
		}
	}
	
	/**
	 * add vertical column of pips using the default spacing and radius
	 */
	public void addColumn(int count, String section, double posX, double posY) {
		addColumn(count, section, posX, posY, defaultSpacing, defaultRadius);
	}
	
	/**
	 * add pips in multiple rows and columns
	 * 
	 * @param nCols		the width of the section in number of pips
	 * @param nRows		the height of the section in number of pips
	 * @param section	the section key
	 * @param posX		the X coordinate of the top left pip
	 * @param posY		the Y coordinate of the top left pip
	 * @param space		the horizontal and vertical spacing between pips
	 * @param radius	the radius of the pips
	 */
	public void addRectangularGrid(int nCols, int nRows, String section, double posX, double posY, double space, double radius) {
		double x = posX;
		double y = posY;
		for (int r = 0; r < nRows; r++) {
			for (int c = 0; c < nCols; c++) {
				addPip(section, x, y, radius);
				x += space;
			}
			x = posX;
			y += space;
		}
	}
	
	/**
	 * add multiple rows and columns of pips using the default spacing and radius
	 */
	public void addRectangularGrid(int nCols, int nRows, String section, double posX, double posY) {
		addRectangularGrid(nCols, nRows, section, posX, posY, defaultSpacing, defaultRadius);
	}
	
	/**
	 * add multiple rows of pips with every other row offset by half and the rows closer together
	 * 
	 * @param nCols		the number of pips in the first column and every other subsequent column; remaining columns have one fewer
	 * @param nRows		the number of rows of pips
	 * @param section	the section key
	 * @param posX		the X coordinate of the top left pip
	 * @param posY		the Y coordinate of the top left pip
	 * @param space		the horizontal and vertical spacing between pips
	 * @param radius	the radius of the pips
	 */
	public void addHexGrid(int nCols, int nRows, String section, double posX, double posY, double space, double radius) {
		double x = posX;
		double y = posY;
		double rowSpacing = space * Math.sqrt(0.75);
		for (int c = 0; c < nCols; c++) {
			for (int r = 0; r < nRows; r++) {
				addPip(section, x, y, radius);
				x += space;
			}
			x = posX;
			if (c % 2 == 0) {
				x += space * 0.5;
			}
			y += rowSpacing;
		}
	}
	
	/**
	 * add multiple rows of pips with every other row offset by half and the rows closer together using the default spacing and radius
	 */
	public void addHexGrid(int nCols, int nRows, String section, double posX, double posY) {
		addHexGrid(nCols, nRows, section, posX, posY, defaultSpacing, defaultRadius);
	}
	
	/**
	 * Export the image to an svg file
	 * 
	 * @param file
	 */
	public void writeSVG(File f) {
        try {
			PrintWriter pw = new PrintWriter(f);
			pw.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
			pw.println("<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.0//EN\" \"http://www.w3.org/TR/2001/REC-SVG-20010904/DTD/svg10.dtd\">");
			pw.print("<svg version=\"1.0\" xmlns=\"http://www.w3.org/2000/svg\"");
			pw.print("\txmlns:xlink=\"http://www.w3.org/1999/xlink\" x=\"0px\" y=\"0px\"");
			pw.println("\twidth=\"612px\" height=\"792px\" viewBox=\"0 0 612 792\" enable-background=\"new 0 0 612 792\" xml:space=\"preserve\">");
			for (String id : pips.keySet()) {
				for (int i = 0; i < pips.get(id).size(); i++) {
					pips.get(id).get(i).writeSVG(pw, "\t", id + "." + i);
				}
			}
			pw.println("</svg>");
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	/**
	 * Contains coordinates and radius of a pip and exports it as a SVG path.
	 * 
	 * @author Neoancient
	 */
	public static class Pip {
		//Value used to construct a cubic Bezier curve closely approximating a circle. 
		private final static double C = 0.55191502449;
		
		double posX;
		double posY;
		double radius;
		
		public Pip(double posX, double posY, double radius) {
			this.posX = posX;
			this.posY = posY;
			this.radius = radius;
		}
		
		public void writeSVG(PrintWriter pw, String indent, String section) {
			double c = C * radius;
			pw.print(indent);
			pw.print("<path id=\"");
			pw.print(section);
			pw.print("\" fill=\"none\" stroke=\"#000000\" stroke-width=\"0.5\" d=\"M");
			//Move to start of circle, at (1, 0).
			pw.print(posX + radius + radius);
			pw.print(",");
			pw.print(posY + radius);
			
			//First arc, moving anti-clockwise
			pw.print(" c0,");
			pw.print(-c);
			pw.print(", ");
			pw.print(c - radius);
			pw.print(",");
			pw.print(-radius);
			pw.print(", ");
			pw.print(-radius);
			pw.print(",");
			pw.print(-radius);
			
			//Second arc
			pw.print(" c");
			pw.print(-c);
			pw.print(",0, ");
			pw.print(-radius);
			pw.print(",");
			pw.print(radius - c);
			pw.print(", ");
			pw.print(-radius);
			pw.print(",");
			pw.print(radius);
			
			//Third arc
			pw.print(" c0,");
			pw.print(c);
			pw.print(", ");
			pw.print(radius - c);
			pw.print(",");
			pw.print(radius);
			pw.print(", ");
			pw.print(radius);
			pw.print(",");
			pw.print(radius);
			
			//Final arc
			pw.print(" c");
			pw.print(c);
			pw.print(",0, ");
			pw.print(radius);
			pw.print(",");
			pw.print(c - radius);
			pw.print(", ");
			pw.print(radius);
			pw.print(",");
			pw.print(-radius);
			
			pw.println("\"/>");
		}
	}

	/**
	 * Regenerate the armor image files 
	 */
	public static void main(String[] args) {
		generateVTOLPips();
	}
	
	private static void generateVTOLPips() {
		ArmorPipImage armor = new ArmorPipImage(2.41, 6);
		
		armor.addRow(5, "FR.0", 472.5, 77);
		armor.addRectangularGrid(7, 3, "FR.0", 466.5, 83);
		armor.addRectangularGrid(5, 2, "FR.0", 472.5, 101);
		
		armor.addPip("LS.0", 455.5, 102);
		armor.addPip("LS.0", 455.5, 108);
		armor.addPip("LS.0", 461.5, 108);
		armor.addRectangularGrid(3, 5, "LS.0", 454.5, 114);
		armor.addRectangularGrid(2, 4, "LS.0", 460.5, 160.5);
		armor.addColumn(4, "LS.0", 466.5, 184.5);

		armor.addPip("RS.0", 513, 102);
		armor.addPip("RS.0", 507, 108);
		armor.addPip("RS.0", 513, 108);
		armor.addRectangularGrid(3, 5, "RS.0", 502, 114);
		armor.addRectangularGrid(2, 4, "RS.0", 502, 160.5);
		armor.addColumn(4, "RS.0", 502, 184.5);

		armor.addColumn(10, "RR.0", 485.5, 252);
		armor.addRectangularGrid(2, 10, "RR.0", 482.5, 252);

		armor.addPip("RO.0", 405, 149);
        armor.addPip("RO.0", 562, 149);
        
        armor.addColumn(3, "FR.IS", 478, 120, 9, 1.86);
        armor.addColumn(3, "FR.IS", 485, 120, 9, 1.86);
        armor.addColumn(3, "FR.IS", 492, 120, 9, 1.86);        
        armor.addColumn(6, "LS.IS", 478, 164, 7, 1.86);
        armor.addColumn(6, "RS.IS", 491, 164, 7, 1.86);
		armor.addColumn(3, "RR.IS", 485.5, 220, 9, 1.86);
        armor.addRectangularGrid(2, 3, "RR.IS", 481, 220, 9, 1.86);
        armor.addRow(7, "RO.IS", 424.5, 149, 20, 1.86);
        
        File f = new File("data/images/recordsheets/Armor VTOL.svg");
        armor.writeSVG(f);
	}
}
