package Dorcg.main.lync;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import Dorcg.PixScan.JsonUtil;
import Dorcg.PixScan.RangeScanUtil;
import Dorcg.PixScan.ScanInfo;

public class SampleIcon {
	
	public static int ICON_X_MIN = 686;
	public static int ICON_X_MAX = 713;
	public static int ICON_Y_MIN = 1050;
	public static int ICON_Y_MAX = 1069;
	
	public static String ICON_FILE_NAME = "icon_normal";
	public static ArrayList<Point> ICON_RANGE = RangeScanUtil.calRectRange(ICON_X_MIN, ICON_X_MAX, 5, ICON_Y_MIN, ICON_Y_MAX, 5);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Color> color  = RangeScanUtil.scanRange(ICON_RANGE);
		ScanInfo scanInfo = new ScanInfo(ICON_RANGE, color);
		scanInfo.setName(ICON_FILE_NAME);
		JsonUtil.writeJsonFile(scanInfo);
	}

}
