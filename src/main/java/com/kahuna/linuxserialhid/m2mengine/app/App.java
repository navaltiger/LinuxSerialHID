package com.kahuna.linuxserialhid.m2mengine.app;

import java.awt.Robot;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

public class App {
	static Logger log = Logger.getLogger(App.class);

	public static void main(String[] args) throws InterruptedException,
			IOException {

		InputStream in;
		SmartRobot robot;

		if (args.length < 1) {
			System.out.println("Usage : linuxserialhid <devFile>");
		}

		try {
			robot = new SmartRobot();
			System.out.println("Connecting... " + args[0]);
			SerialIO portHandle = new SerialIO();

			if (portHandle.connect(args[0])) {
				in = portHandle.getStream();

				byte b[] = new byte[2];

				int c = 0;

				try {
					while ((c = in.read(b, 0, 2)) != -1) {

						String str = new String(b);
//replacing white space.. one can avoid it..
						str = str.replaceAll("[\\n\\t ]", "");

						System.out.print("" + str);

						robot.typeBoard(str);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

			} else {
				System.out.println("Communication problem.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}