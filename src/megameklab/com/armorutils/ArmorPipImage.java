package megameklab.com.armorutils;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ArmorPipImage {
	
	private final static double C = 0.55191502449;
	
	private List<Pip> pips;
	double radius;
	
	public ArmorPipImage(double radius) {
		this.radius = radius;
		pips = new ArrayList<>();
	}
	
	public Pip addPip(String id, double x, double y) {
		Pip pip = new Pip(id, x, y);
		pips.add(pip);
		return pip;
	}
	
	public void writeSVG(PrintWriter pw) {
		pw.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		pw.println("<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.0//EN\" \"http://www.w3.org/TR/2001/REC-SVG-20010904/DTD/svg10.dtd\">");
		pw.print("<svg version=\"1.0\" xmlns=\"http://www.w3.org/2000/svg\"");
		pw.print("\txmlns:xlink=\"http://www.w3.org/1999/xlink\" x=\"0px\" y=\"0px\"");
		pw.println("\twidth=\"612px\" height=\"792px\" viewBox=\"0 0 612 792\" enable-background=\"new 0 0 612 792\" xml:space=\"preserve\">");
		pips.forEach(p -> p.writeSVG(pw, "\t"));
		pw.println("</svg>");
	}

	public class Pip {
		String id;
		double posX;
		double posY;
		
		public Pip(String id, double posX, double posY) {
			this.id = id;
			this.posX = posX;
			this.posY = posY;
		}
		
		public void writeSVG(PrintWriter pw, String indent) {
			double c = C * radius;
			pw.print(indent);
			pw.print("<path id=\"");
			pw.print(id);
			pw.print("\" fill=\"none\" stroke=\"#434344\" stroke-width=\"0.581\" d=\"M");
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
