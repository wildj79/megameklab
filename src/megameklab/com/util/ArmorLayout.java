/*
 * MegaMekLab - Copyright (C) 2016 - The MegaMek Team
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 */

package megameklab.com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author Neoancient
 *
 */
public class ArmorLayout {

	private static final String LAYOUT_DIR = "data/armorlayouts";
	
	private Map<String,Map<Integer,List<String>>> armorPipIds;
	private Map<String,Map<Integer,List<String>>> structurePipIds;
	private Map<String,Integer> maxArmor;
	private Map<String,Integer> maxStructure;
	
	public ArmorLayout(String recordSheet) {
		armorPipIds = new HashMap<>();
		structurePipIds = new HashMap<>();
		loadLayoutFile(recordSheet);
		maxArmor = new HashMap<>();
		for (String loc : armorPipIds.keySet()) {
			maxArmor.put(loc, armorPipIds.get(loc).keySet()
					.stream().mapToInt(Integer::intValue).max().orElse(0));
		}
		maxStructure = new HashMap<>();
		for (String loc : structurePipIds.keySet()) {
			maxStructure.put(loc, structurePipIds.get(loc).keySet()
					.stream().mapToInt(Integer::intValue).max().orElse(0));
		}
	}
	
	public List<String> getArmorPipIds(String loc, int armorValue) {
		if (armorPipIds.containsKey(loc)) {
			return armorPipIds.get(loc).get(armorValue);
		}
		return null;
	}
	
	public List<String> getStructurePipIds(String loc, int structureValue) {
		if (structurePipIds.containsKey(loc)) {
			return structurePipIds.get(loc).get(structureValue);
		}
		return null;
	}
	
	public Integer maxArmor(String loc) {
		return maxArmor.get(loc);
	}
	
	public Integer maxStructure(String loc) {
		return maxStructure.get(loc);
	}
	
	private void loadLayoutFile(String recordSheet) {
		File file = new File(LAYOUT_DIR, recordSheet + ".xml");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			System.err.println("Unable to read armor layout file " + file.toString()); //$NON-NLS-1$
			return;
		}

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		Document xmlDoc = null;

		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			xmlDoc = db.parse(fis);
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}

		Element element = xmlDoc.getDocumentElement();
		NodeList nl = element.getChildNodes();

		element.normalize();

		for (int i = 0; i < nl.getLength(); i++) {
			Node wn = nl.item(i);
			if (wn.getNodeName().equalsIgnoreCase("location")) {
				if (wn.getAttributes().getNamedItem("abbr") == null) {
					System.err.println("Missing abbr attribute in location node in " + file.toString());
				} else {
					String[] locations = wn.getAttributes().getNamedItem("abbr").getTextContent().split(",");
					for (String loc : locations) {
						armorPipIds.put(loc, new TreeMap<>());
						structurePipIds.put(loc, new TreeMap<>());
					}
					NodeList nl2 = wn.getChildNodes();
					for (int j = 0; j < nl2.getLength(); j++) {
						Node wn2 = nl2.item(j);
						if (wn2.getNodeName().equals("armor")) {
							if (wn2.getAttributes().getNamedItem("points") == null) {
								System.err.println("Missing points attribute in armor node in " + file.toString());
							} else {
								Integer points = Integer.valueOf(wn2.getAttributes().getNamedItem("points").getTextContent());
								final String prefix;
								if (wn2.getAttributes().getNamedItem("section") == null) {
									prefix = "0";
								} else {
									prefix = wn2.getAttributes().getNamedItem("section").getTextContent();
								}
								for (String loc : locations) {
									armorPipIds.get(loc).put(points, Stream.of(wn2.getTextContent().split(","))
											.<String>map(id -> loc + "." + prefix + "." + id)
											.collect(Collectors.toList()));
								}
							}
						} else if (wn2.getNodeName().equals("is")) {
							if (wn2.getAttributes().getNamedItem("points") == null) {
								System.err.println("Missing points attribute in is node in " + file.toString());
							} else {
								Integer points = Integer.valueOf(wn2.getAttributes().getNamedItem("points").getTextContent());
								final String prefix;
								if (wn2.getAttributes().getNamedItem("section") == null) {
									prefix = "IS";
								} else {
									prefix = wn2.getAttributes().getNamedItem("section").getTextContent();
								}
								for (String loc : locations) {
									structurePipIds.get(loc).put(points, Stream.of(wn2.getTextContent().split(","))
											.<String>map(id -> loc + "." + prefix + "." + id)
											.collect(Collectors.toList()));
								}
							}
						}
					}
				}
			}
		}
	}
}
