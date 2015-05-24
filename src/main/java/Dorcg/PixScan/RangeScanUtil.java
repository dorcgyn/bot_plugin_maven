package Dorcg.PixScan;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import Dorcg.plugin.PixelFunc;

public class RangeScanUtil {
	// Use array of pointer 
	private static ArrayList<Color> scanRange(ArrayList<Point> range) {
		PixelFunc pixel;
		try {
			pixel = new PixelFunc();
		} catch (AWTException e) {
			e.printStackTrace();
			return null;
		}
		ArrayList<Color> colors = new ArrayList<Color>();
		for (Point point : range) {
			colors.add(pixel.getColor(point.x, point.y));
		}
		return colors;
	}
	
	public static ArrayList<Point> calRectRange(int max_x, int min_x, int step_x,
			int max_y, int min_y, int step_y) {
		ArrayList<Point> range = new ArrayList<Point>();
		for (int x = min_x; x < max_x; x+=step_x) {
			for (int y = min_y; y < max_y; y+=step_y) {
				Point point = new Point();
				point.x = x;
				point.y = y;
			}
		}
		return range;
	}
	
	public static void findDiff(ArrayList<Color> color1, 
			ArrayList<Color> color2, ArrayList<Point> range) {
		for (int i = 0; i < range.size(); i++ ) {
			Color pix1 = color1.get(i);
			Color pix2 = color2.get(i);
			if (pix1.equals(pix2)) {
				System.out.println("Color diff in x=" + range.get(i).x + " y=" + range.get(i).y);
				System.out.println("pix 1 -> ");
				PixelFunc.translateColor(pix1);
				System.out.println("pix 2 -> ");
				PixelFunc.translateColor(pix2);
			}
		}
	}
}
