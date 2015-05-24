package Dorcg.plugin;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Point;
import java.awt.Robot;

public class PixelFunc {
	private Robot bot;
	
	public PixelFunc() throws AWTException {
		bot = new Robot();
	}
	
	public Color getColor(int x, int y) {
		Color color = bot.getPixelColor(x, y);
		return color;
	}
	public Color getColor(Point pointer) {
		return getColor(pointer.x, pointer.y);
	}
	public Color getColor() {
		return getColor(MouseFunc.getMousePointer());
	}
	
	public static void translateColor(Color color) {
		System.out.println("/** Color is:");
		System.out.println("Red: " + color.getRed());
		System.out.println("Green: " + color.getGreen());
		System.out.println("Blue: " + color.getBlue());
		System.out.println("**/");
	}
}
