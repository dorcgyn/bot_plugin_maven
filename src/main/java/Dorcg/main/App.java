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
    	Thread.sleep(2000);
    	
    	PixelFunc pixel = new PixelFunc();
    	Color color = pixel.getColor();
    	PixelFunc.translateColor(color);
    }
}
