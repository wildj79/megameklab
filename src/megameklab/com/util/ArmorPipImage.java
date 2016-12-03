package megameklab.com.util;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArmorPipImage {
	
	private final static double C = 0.55191502449;
	
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
	
	public Pip addPip(String location, int group, double x, double y, double radius) {
		return addPip(location + "." + group, x, y, radius);
	}
	
	public Pip addPip(String location, int group, double x, double y) {
		return addPip(location + "." + group, x, y, defaultRadius);
	}
	
	public Pip addPip(String section, double x, double y, double radius) {
		pips.putIfAbsent(section, new ArrayList<>());
		Pip pip = new Pip(x, y, radius);
		pips.get(section).add(pip);
		return pip;
	}
	
	public Pip addPip(String section, double x, double y) {
		return addPip(section, x, y, defaultRadius);
	}
	
	public void addRow(int count, String section, double posX, double posY, double space, double radius) {
		for (int i = 0; i < count; i++) {
			addPip(section, posX, posY, radius);
			posX += space;
		}
	}
	
	public void addRow(int count, String section, double posX, double posY) {
		addRow(count, section, posX, posY, defaultSpacing, defaultRadius);
	}
	
	public void addColumn(int count, String section, double posX, double posY, double space, double radius) {
		for (int i = 0; i < count; i++) {
			addPip(section, posX, posY, radius);
			posY += space;
		}
	}
	
	public void addColumn(int count, String section, double posX, double posY) {
		addColumn(count, section, posX, posY, defaultSpacing, defaultRadius);
	}
	
	public void addSquareGrid(int nCols, int nRows, String section, double posX, double posY, double space, double radius) {
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
	
	public void addSquareGrid(int nCols, int nRows, String section, double posX, double posY) {
		addSquareGrid(nCols, nRows, section, posX, posY, defaultSpacing, defaultRadius);
	}
	
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
	
	public void addHexGrid(int nCols, int nRows, String section, double posX, double posY) {
		addHexGrid(nCols, nRows, section, posX, posY, defaultSpacing, defaultRadius);
	}
	
	public void writeSVG(PrintWriter pw) {
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
	}

	public static class Pip {
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
}
