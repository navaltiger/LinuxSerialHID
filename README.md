# LinuxSerialHID
Have created this project to address one requirement, where we need to read data from serial port and push to GUI.

To run on Ubuntu:
1. Install rxtx package on ubuntu
 sudo apt-get install librxtx-java

2. Open terminal and go to directory where this file is copied.

3. Run following command
sudo java -jar linuxserialhid.jar /dev/ttyUSB0

(assuming ttyUSB0 is comm. port for reader/device)

4. Open any text file using visual tool (this utility will not work with command line console. Data will be sent to Graphical apps/X apps)

5. Place cursor in text file.

(Alternatively open Spreadsheet utlity in ubuntu and place cursor on any cell)

6. Present card on reader
You should see text being placed where cursor is positioned.

Any contribution is welcomed!
