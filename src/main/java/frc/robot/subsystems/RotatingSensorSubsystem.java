package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.utilities.SerialDataHandler;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * RotatingSensorSubsystem
 */
public class RotatingSensorSubsystem extends SubsystemBase {

    DigitalOutput m_sensorEnable = new DigitalOutput(Constants.DIO_2);
    SerialDataHandler m_serialDataHandler;
    int m_range = -1;
    int m_bearing = -1;

    public RotatingSensorSubsystem() {
       
        m_serialDataHandler = new SerialDataHandler(115200, SerialPort.Port.kMXP, 8, SerialPort.Parity.kNone,
                 SerialPort.StopBits.kOne);
        Thread thread = new Thread(m_serialDataHandler);
        thread.start();

        m_sensorEnable.set(false); // enables sensor box
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run

        // System.out.println("Range: " + m_range);
        SmartDashboard.putNumber("Range: ", m_range);

        // System.out.println("Bearing: " + m_bearing);
        SmartDashboard.putNumber("Bearing: ", m_bearing);
    } 

    public void setRange(int range) {
        m_range = range;
    }

    public void setBearing(int bearing) {
        m_bearing = bearing;
    }
}