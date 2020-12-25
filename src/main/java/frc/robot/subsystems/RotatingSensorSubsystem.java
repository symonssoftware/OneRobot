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

    public RotatingSensorSubsystem() {
       
        m_serialDataHandler = new SerialDataHandler(115200, SerialPort.Port.kMXP, 8, SerialPort.Parity.kNone,
				 SerialPort.StopBits.kOne);

        m_sensorEnable.set(false); // enables sensor box
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run

        m_serialDataHandler.readPort();

        int range = m_serialDataHandler.getSensorRangeData();

        if (range != -1)
        {
            System.out.println("Range: " + range);
            SmartDashboard.putNumber("Range: ", range);
        }

        int bearing = m_serialDataHandler.getSensorBearingData();

        if (bearing != -1)
        {
            System.out.println("Bearing: " + bearing);
            SmartDashboard.putNumber("Bearing: ", bearing);
        }
    } 
}