package frc.robot.utilities;

import edu.wpi.first.wpilibj.SerialPort;

public class SerialDataHandler {
    public static final int SEARCHING_FOR_HEADER = 0;
    public static final int SEARCHING_FOR_RANGE_DATA = 1;
    public static final int SEARCHING_FOR_BEARING_DATA = 2;

    private int m_state = SEARCHING_FOR_HEADER;
    private int m_rangeData = 0;
    private int m_bearingData = 0;

    SerialPort m_port;

    public SerialDataHandler(int baudRate, SerialPort.Port serialPort, int numBits, SerialPort.Parity serialParity, SerialPort.StopBits stopBits) {
        m_port = new SerialPort(baudRate, serialPort, numBits, serialParity, stopBits);
        m_port.setTimeout(0.03);
        m_port.reset();
    }

    public int getSensorRangeData() {
        return m_rangeData;
    }

    public int getSensorBearingData() {
        return m_bearingData;
    }

    private int convertData(byte a, byte b) {

        int sensorData = 0;

        sensorData = (int) (Byte.toUnsignedInt(a));
        sensorData = sensorData | (int) (Byte.toUnsignedInt(b) << 8);

        return sensorData;
    }

    public void readPort() {
        m_rangeData = -1;
        m_bearingData = -1;

        m_port.setReadBufferSize(2);
        byte[] byteArray = m_port.read(2);

        if (byteArray.length == 2) {

            byte upperbyte = byteArray[0]; 
            byte lowerbyte = byteArray[1];

         System.out.println(String.format("byteA: %02X ", upperbyte));
         System.out.println(String.format("byteB: %02X ", lowerbyte));

            switch (m_state) {
            case SEARCHING_FOR_HEADER:

                if ((int) (Byte.toUnsignedInt(upperbyte)) == 0xff) {
                    if ((int) (Byte.toUnsignedInt(lowerbyte)) == 0x01) {
                        m_state = SEARCHING_FOR_RANGE_DATA;
                    } else if ((int) (Byte.toUnsignedInt(lowerbyte)) == 0x02) {
                        m_state = SEARCHING_FOR_BEARING_DATA;
                    } else {
                        // System.out.printlnln("Invalid ID");
                    }
                }
                break;
            case SEARCHING_FOR_RANGE_DATA:
                m_rangeData = convertData(upperbyte, lowerbyte);
                m_state = SEARCHING_FOR_HEADER;
                // System.out.printlnln(String.format("byteA: %02X ", lowerbyte));
                // System.out.printlnln(String.format("byteB: %02X ", upperbyte));

                break;
            case SEARCHING_FOR_BEARING_DATA:
                m_bearingData = convertData(upperbyte, lowerbyte);
                m_state = SEARCHING_FOR_HEADER;
                break;
            default:
                // Do nothing
                break;
            }
        } else {
            // System.out.printlnln("Nothing on port");
        }
    }
}