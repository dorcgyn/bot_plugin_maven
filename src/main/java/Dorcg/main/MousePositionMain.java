package Dorcg.main;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Dorcg.plugin.MouseFunc;
import Dorcg.plugin.PixelFunc;

public class MousePositionMain {
	public static void main( String[] args )
    {
		while (true) {
			try {
				BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
			    String input = bufferRead.readLine();
	
				// stop condition
				if (input.trim().equalsIgnoreCase("q")) {
					break;
				}
				
				// get mouse position and Color
				Point point = MouseFunc.getMousePointer();
				System.out.println(point);
				PixelFunc pixel = new PixelFunc();
				
				Color color = pixel.getColor(point);
				PixelFunc.translateColor(color);
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}
		return;
    }
}
