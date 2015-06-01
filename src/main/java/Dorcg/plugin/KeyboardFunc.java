package Dorcg.plugin;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
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
	
	public void alt_tab() {
		keyPress(KeyEvent.VK_ALT);
		keyClick(KeyEvent.VK_TAB);
		keyRelease(KeyEvent.VK_ALT);
	}
	
	public void typeString(String characters) {
	    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	    StringSelection stringSelection = new StringSelection( characters );
	    clipboard.setContents(stringSelection, null);

	    keyPress(KeyEvent.VK_CONTROL);
	    keyClick(KeyEvent.VK_V);
	    keyRelease(KeyEvent.VK_CONTROL);
	}
}
