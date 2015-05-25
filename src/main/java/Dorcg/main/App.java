package Dorcg.main;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import Dorcg.PixScan.JsonUtil;
import Dorcg.PixScan.RangeScanUtil;
import Dorcg.PixScan.ScanInfo;
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
    		ArrayList<Point> range = RangeScanUtil.calRectRange(0, 20, 5, 0, 20, 5);
    		ArrayList<Color> color  = RangeScanUtil.scanRange(range);
    		ScanInfo scanInfo = new ScanInfo(range, color);
    		scanInfo.setName("testJson");
    		JsonUtil.writeJsonFile(scanInfo);
    		
    		ScanInfo scanInfo2 = JsonUtil.readJsonFile("testJson");
    		scanInfo2.setName("testJson1");
    		JsonUtil.writeJsonFile(scanInfo2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
