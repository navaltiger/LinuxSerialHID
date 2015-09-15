package com.kahuna.linuxserialhid.m2mengine.app;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;

public class SmartRobot extends Robot {

	public SmartRobot() throws AWTException {
		super();
	}

	public void pasteClipboard() {
		keyPress(KeyEvent.VK_CONTROL);
		keyPress(KeyEvent.VK_V);
		delay(50);
		keyRelease(KeyEvent.VK_V);
		keyRelease(KeyEvent.VK_CONTROL);
	}

	public void typeBoard(String text) {
		writeToClipboard(text);
		pasteClipboard();
	}

	private void writeToClipboard(String s) {
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		Transferable transferable = new StringSelection(s);
		clipboard.setContents(transferable, null);
	}

	public void keyType(int keyCode) {
		keyPress(keyCode);
		delay(50);
		keyRelease(keyCode);
	}

	public void keyType(int keyCode, int keyCodeModifier) {
		keyPress(keyCodeModifier);
		keyPress(keyCode);
		delay(50);
		keyRelease(keyCode);
		keyRelease(keyCodeModifier);
	}

	public void type(String text) {
		String textUpper = text;// .toUpperCase();

		for (int i = 0; i < text.length(); ++i) {
			typeChar(textUpper.charAt(i));
		}
	}

	private void typeChar(char c) {
		boolean shift = true;
		int keyCode;

		switch (c) {
		case '~':
			keyCode = (int) '`';
			break;
		case '!':
			keyCode = (int) '1';
			break;
		case '@':
			keyCode = (int) '2';
			break;
		case '#':
			keyCode = (int) '3';
			break;
		case '$':
			keyCode = (int) '4';
			break;
		case '%':
			keyCode = (int) '5';
			break;
		case '^':
			keyCode = (int) '6';
			break;
		case '&':
			keyCode = (int) '7';
			break;
		case '*':
			keyCode = (int) '8';
			break;
		case '(':
			keyCode = (int) '9';
			break;
		case ')':
			keyCode = (int) '0';
			break;
		case ':':
			keyCode = (int) ';';
			break;
		case '_':
			keyCode = (int) '-';
			break;
		case '+':
			keyCode = (int) '=';
			break;
		case '|':
			keyCode = (int) '\\';
			break;
		// case '"':

		// keyCode = (int)'\'';

		// break;

		case '?':
			keyCode = (int) '/';
			break;
		case '{':
			keyCode = (int) '[';
			break;
		case '}':
			keyCode = (int) ']';
			break;
		case '<':
			keyCode = (int) ',';
			break;
		case '>':
			keyCode = (int) '.';
			break;
		default:
			keyCode = (int) c;
			shift = false;
		}
		// if (shift)
		// keyType(keyCode, KeyEvent.VK_SHIFT);
		// else
		keyType(keyCode);
	}

	private int charToKeyCode(char c) {
		switch (c) {
		case ':':
			return ';';
		}
		return (int) c;
	}
}
