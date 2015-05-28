package Dorcg.plugin;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

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
	
	// common util
	public void alt_F4() {
		keyPress(KeyEvent.VK_ALT);
		keyClick(KeyEvent.VK_F4);
		keyRelease(KeyEvent.VK_ALT);
	}
}
