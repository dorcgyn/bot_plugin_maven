package Dorcg.plugin;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class MouseFunc {
	private final static int SLEEP_MS = 100; 
	private Robot bot;
	
	public MouseFunc() throws AWTException {
		bot = new Robot();
	}
	
	public static Point getMousePointer() {
		Point pointer = MouseInfo.getPointerInfo().getLocation(); 
		return pointer;
	}
	
	public void moveMouse(int x, int y) throws InterruptedException {
		Thread.sleep(SLEEP_MS);
		bot.mouseMove(x,y);
	}
	
	public void leftPress() throws InterruptedException {
		Thread.sleep(SLEEP_MS);
		bot.mousePress(InputEvent.BUTTON1_MASK);		
	}
	public void leftRelease() {
		bot.mouseRelease(InputEvent.BUTTON1_MASK);		
	}
	public void leftClick() throws InterruptedException {
		leftPress(); 
		leftRelease();
	}
	public void doubleClick() throws InterruptedException {
		leftClick();
		try {
			Thread.sleep(SLEEP_MS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		leftClick();
	}
	
	
	public void rightPress() {
		bot.mousePress(InputEvent.BUTTON3_MASK);		
	}
	public void rightRelease() {
		bot.mouseRelease(InputEvent.BUTTON3_MASK);		
	}
	public void rightClick() {
		rightPress();
		rightRelease();
	}

}
