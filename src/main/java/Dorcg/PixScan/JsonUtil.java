package Dorcg.PixScan;

import java.awt.Color;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class JsonUtil {
	private static String POINT = "points";
	private static String POINT_X = "x";
	private static String POINT_Y = "y";
	
	private  static String COLOR = "colors";
	private  static String COLOR_RGB = "RGB";
	
	public static void writeJsonFile(ScanInfo scanInfo) {
		JSONObject scanInfoJson = new JSONObject();
		// build pointer array
		JSONArray pointers = new JSONArray();
		for (Point p : scanInfo.getRange()) {
			JSONObject pJson = encodePoint(p);
			pointers.add(pJson);
		}
		scanInfoJson.put(POINT, pointers);
		
		// build color array
		JSONArray colors = new JSONArray();
		for (Color c : scanInfo.getColor()) {
			JSONObject cJson = encodeColor(c);
			colors.add(cJson);
		}
		scanInfoJson.put(COLOR, colors);
		
		// write into file
		try {
			PrintWriter writer = new PrintWriter(scanInfo.getName());
			System.out.println(scanInfoJson.toString());
			writer.print(scanInfoJson.toString());
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static ScanInfo readJsonFile(String fileName) {
		try {
			// read from file 
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String jsonString = br.readLine();
			
			ScanInfo scanInfo = new ScanInfo();
			scanInfo.setName(fileName);
			
			// parse json
			JSONObject scanInfoJson = (JSONObject) JSONValue.parse(jsonString);
			
			// parse range
			JSONArray pointJsons = (JSONArray) scanInfoJson.get(POINT);
			ArrayList<Point> pointers = new ArrayList<Point>();
			for (int i = 0; i < pointJsons.size(); i++) {
				JSONObject pointJson = (JSONObject) pointJsons.get(i);
				Point pointer = new Point();
				pointer.x = ((Long) pointJson.get(POINT_X)).intValue();
				pointer.y = ((Long) pointJson.get(POINT_Y)).intValue();
				pointers.add(pointer);
			}
			scanInfo.setRange(pointers);
			
			// parse colors
			JSONArray colorJsons = (JSONArray) scanInfoJson.get(COLOR);
			ArrayList<Color> colors = new ArrayList<Color>();
			for (int i = 0; i < colorJsons.size(); i++) {
				JSONObject colorJson = (JSONObject) colorJsons.get(i);
				int rgb = ((Long) colorJson.get(COLOR_RGB)).intValue();
				Color color = new Color(rgb);
				colors.add(color);
			}
			scanInfo.setColor(colors);
			
			return scanInfo;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
		
	}
	
	// util method
	private static JSONObject encodeColor(Color color) {
		JSONObject jsonColor = new JSONObject();
		jsonColor.put(COLOR_RGB, color.getRGB());
		return jsonColor;
	}
	private static Color decodeColor(JSONObject jsonColor) {
		int rgb = (Integer) jsonColor.get(COLOR_RGB);
		return new Color(rgb);
	}
	
	private static JSONObject encodePoint(Point pointer) {
		JSONObject jsonColor = new JSONObject();
		jsonColor.put(POINT_X, pointer.x);
		jsonColor.put(POINT_Y, pointer.y);
		return jsonColor;
	}
	private static Point decodePoint(JSONObject jsonObject) {
		int x = (Integer) jsonObject.get(POINT_X);
		int y = (Integer) jsonObject.get(POINT_Y);
		Point pointer = new Point();
		pointer.x = x;
		pointer.y = y;
		return pointer;
	}
}
