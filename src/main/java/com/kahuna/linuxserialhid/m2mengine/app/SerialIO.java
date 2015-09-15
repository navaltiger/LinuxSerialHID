package com.kahuna.linuxserialhid.m2mengine.app;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

import java.awt.Robot;
import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SerialIO {
	InputStream in;

	public SerialIO() {
	}

	boolean connect(String portName) throws Exception {
		CommPortIdentifier portIdentifier = CommPortIdentifier
				.getPortIdentifier(portName);
		if (portIdentifier.isCurrentlyOwned()) {
			System.out.println("Error: Port is currently in use");
		} else {
			CommPort commPort = portIdentifier.open(this.getClass().getName(),
					2000);

			if (commPort instanceof SerialPort) {
				SerialPort serialPort = (SerialPort) commPort;
				serialPort.setSerialPortParams(115200, SerialPort.DATABITS_8,
						SerialPort.STOPBITS_1, SerialPort.FLOWCONTROL_NONE);

				in = serialPort.getInputStream();
				return true;
			}
		}
		return false;
	}

	public InputStream getStream() {
		return in;
	}

}
