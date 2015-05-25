package Dorcg.PixScan;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import Dorcg.plugin.PixelFunc;

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
	
	// first simple one, only return boolean
	public boolean isSame(ScanInfo another) {
		if (range.size() != another.getRange().size()) {
			System.out.println("Diff in range size");
			return false;
		}
		for (int i = 0; i < range.size(); i++ ) {
			Color pix1 = color.get(i);
			Color pix2 = another.getColor().get(i);
			if (!pix1.equals(pix2)) {
				return false;
			}
		}
		return true;
	}
}
