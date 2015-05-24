package Dorcg.main;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Point;

import Dorcg.plugin.MouseFunc;
import Dorcg.plugin.PixelFunc;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try {
			Thread.sleep(2000);
			
			PixelFunc pixel = new PixelFunc();
	    	Color color = pixel.getColor();
	    	PixelFunc.translateColor(color);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
