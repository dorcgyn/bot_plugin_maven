package Dorcg.main.lync;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Dorcg.PixScan.JsonUtil;
import Dorcg.PixScan.RangeScanUtil;
import Dorcg.PixScan.ScanInfo;
import Dorcg.plugin.KeyboardFunc;
import Dorcg.plugin.MouseFunc;

public class Main {

	public static void main(String[] args) {
		// Load normal state of Icon
		ScanInfo icon_normal = JsonUtil.readJsonFile(SampleIcon.ICON_FILE_NAME);
		
		while (true) {
			try {
				Thread.sleep(3000);
				ArrayList<Color> color  = RangeScanUtil.scanRange(SampleIcon.ICON_RANGE);
				ScanInfo icon_current = new ScanInfo( SampleIcon.ICON_RANGE, color);
				
				if (!icon_normal.isSame(icon_current)) {
					System.out.println("Icon color is not same");
					response();
				} else {
					System.out.println("Icon color is same");
				}	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
		}
	}

	
	private static void response() throws AWTException, InterruptedException {
		MouseFunc mouse = new MouseFunc();
		mouse.moveMouse((SampleIcon.ICON_X_MIN + SampleIcon.ICON_X_MAX)/2, (SampleIcon.ICON_Y_MIN + SampleIcon.ICON_Y_MAX)/2);
		mouse.leftClick();
		
		mouse.moveMouse(776,978);
		mouse.leftClick();
		
		KeyboardFunc key = new KeyboardFunc();
		key.typeString("Hi, I am available now :)");
		key.keyClick(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		key.alt_F4();
		
	}
}
