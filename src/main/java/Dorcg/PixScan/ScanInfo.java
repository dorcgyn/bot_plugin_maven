package Dorcg.PixScan;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class ScanInfo {
	private String name;
	private ArrayList<Point> range;
	private ArrayList<Color> color;
	
	public ScanInfo(ArrayList<Point> range, ArrayList<Color> color) {
		this.range = range;
		this.color = color;
	}
	public ScanInfo() {
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Point> getRange() {
		return range;
	}
	public void setRange(ArrayList<Point> range) {
		this.range = range;
	}
	public ArrayList<Color> getColor() {
		return color;
	}
	public void setColor(ArrayList<Color> color) {
		this.color = color;
	} 
	
}
