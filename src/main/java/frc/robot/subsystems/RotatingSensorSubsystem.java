package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

/**
 * RotatingSensorSubsystem
 */
public class RotatingSensorSubsystem extends SubsystemBase {

    Ultrasonic m_ultrasonicSensor = new Ultrasonic(Constants.DIO_4, Constants.DIO_3);

    DigitalInput m_flagSensor = new DigitalInput(Constants.DIO_2);

    DigitalOutput m_motorStep = new DigitalOutput(Constants.DIO_5);
    DigitalOutput m_motorEnable = new DigitalOutput(Constants.DIO_6);
    DigitalOutput m_motorMS2 = new DigitalOutput(Constants.DIO_7);
    DigitalOutput m_motorMS1 = new DigitalOutput(Constants.DIO_8);
    DigitalOutput m_motorDirection = new DigitalOutput(Constants.DIO_9);

    public RotatingSensorSubsystem() {
        m_ultrasonicSensor.setAutomaticMode(true);
        // m_motorEnable.set(false); // Allows motor control
        // m_motorStep.set(true);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run

        System.out.println("Ultrasonic Sensor: " + m_ultrasonicSensor.getRangeInches());
        System.out.println("Flag Sensor: " + m_flagSensor.get());
     }
  
}