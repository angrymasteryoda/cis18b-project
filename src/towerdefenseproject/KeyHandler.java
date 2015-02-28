package towerdefenseproject;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	
	private Screen screen;
	private Screen.KeyTyped keyTyped;
	
	public KeyHandler (Screen screen){
		this.screen = screen;
		this.keyTyped = this.screen.new KeyTyped();
	}
	
	public void keyPressed(KeyEvent k) {
		int keyCode = k.getKeyCode();
		System.out.println("Your pressing keyboard key: "+keyCode);
		// Assign keys to their classes
		if (keyCode==27) {
			this.keyTyped.keyESC();		// Esc
		}
		if (keyCode==122) {
			this.keyTyped.keyF11();		// F11 (Fullscreen)
		}
		if (keyCode==127) {
			this.keyTyped.keyDEL();		// Delete
		}
		if (keyCode==8) {
			this.keyTyped.keyBACK();	// Backspace
		}
		if (keyCode==10) {
			this.keyTyped.keyENTER();	// Enter
		}
		if (keyCode==16) {
			this.keyTyped.keySHIFT();	// Shift
		}
		if (keyCode==32) {
			this.keyTyped.keySPACE();	// Spacebar
		}
		if (keyCode==68) {
			this.keyTyped.keyD();		// D
		}
		if (keyCode==77) {
			this.keyTyped.keyM();		// M
		}
		if (keyCode==80) {
			this.keyTyped.keyP();		// P
		}
		if (keyCode==48) {
			this.keyTyped.key0();		// 0
		}
		if (keyCode==49) {
			this.keyTyped.key1();		// 1
		}
		if (keyCode==50) {
			this.keyTyped.key2();		// 2
		}
		if (keyCode==51) {
			this.keyTyped.key3();		// 3
		}
		if (keyCode==52) {
			this.keyTyped.key4();		// 4
		}
		if (keyCode==53) {
			this.keyTyped.key5();		// 5
		}
		if (keyCode==54) {
			this.keyTyped.key6();		// 6
		}
		if (keyCode==55) {
			this.keyTyped.key7();		// 7
		}
		if (keyCode==56) {
			this.keyTyped.key8();		// 8
		}
		if (keyCode==57) {
			this.keyTyped.key9();		// 9
		}
		if (keyCode==96) {
			this.keyTyped.keyPAD0();	// Number pad 0
		}
		if (keyCode==97) {
			this.keyTyped.keyPAD1();	// Number pad 1
		}
		if (keyCode==98) {
			this.keyTyped.keyPAD2();	// Number pad 2
		}
		if (keyCode==99) {
			this.keyTyped.keyPAD3();	// Number pad 3
		}
		if (keyCode==100) {
			this.keyTyped.keyPAD4();	// Number pad 4
		}
		if (keyCode==101) {
			this.keyTyped.keyPAD5();	// Number pad 5
		}
		if (keyCode==102) {
			this.keyTyped.keyPAD6();	// Number pad 6
		}
		if (keyCode==103) {
			this.keyTyped.keyPAD7();	// Number pad 7
		}
		if (keyCode==104) {
			this.keyTyped.keyPAD8();	// Number pad 8
		}
		if (keyCode==105) {
			this.keyTyped.keyPAD9();	// Number pad 9
		}
	}
	
	public void keyReleased(KeyEvent k) {
		// Unused
	}
	
	public void keyTyped (KeyEvent k) {
		// Unused
	}
}
