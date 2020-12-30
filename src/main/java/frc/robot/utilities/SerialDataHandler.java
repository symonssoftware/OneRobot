package frc.robot.utilities;

import edu.wpi.first.wpilibj.SerialPort;
import frc.robot.RobotContainer;

public class SerialDataHandler implements Runnable {

    SerialPort m_port;

    public SerialDataHandler(int baudRate, SerialPort.Port serialPort, int numBits, SerialPort.Parity serialParity, SerialPort.StopBits stopBits) {
        m_port = new SerialPort(baudRate, serialPort, numBits, serialParity, stopBits);
        m_port.setTimeout(0.03);
        m_port.reset();
    }

    private int convertData(byte a, byte b) {

        int sensorData = 0;

        sensorData = (int) (Byte.toUnsignedInt(a));
        sensorData = sensorData | (int) (Byte.toUnsignedInt(b) << 8);

        return sensorData;
    }

    @Override
    public void run() {

        while (true) {
            m_port.setReadBufferSize(6);
            byte[] byteArray = m_port.read(6);

            if (byteArray.length == 6) {

                byte upperHeaderByte = byteArray[0];
                byte lowerHeaderByte = byteArray[1];

                if (((int) (Byte.toUnsignedInt(upperHeaderByte)) == 0xff)
                        && ((int) (Byte.toUnsignedInt(lowerHeaderByte)) == 0xfe)) {
                    // Header is valid so get the data
                    RobotContainer.getRotatingSensorSubsystem().setRange(convertData(byteArray[2], byteArray[3]));
                    RobotContainer.getRotatingSensorSubsystem().setBearing(convertData(byteArray[4], byteArray[5]));
                }
            } else {
                // System.out.printlnln("Nothing on port");
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}