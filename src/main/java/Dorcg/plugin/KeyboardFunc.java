package Dorcg.plugin;

import java.awt.AWTException;
import java.awt.Robot;

public class KeyboardFunc {
	private Robot bot;
	
	public KeyboardFunc() throws AWTException {
		bot = new Robot();
	}
	
	// e.g. keyCode = KeyEvent.VK_3
	public void keyPress(int keyCode) {
		bot.keyPress(keyCode);
	}
	public void keyRelease(int keyCode) {
		bot.keyRelease(keyCode);
	}
	public void keyClick(int keyCode) {
		keyPress(keyCode);
		keyRelease(keyCode);
	}
}
