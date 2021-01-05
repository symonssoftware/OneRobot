package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

/**
 * ProximitySubsystem
 */
public class ProximitySubsystem extends SubsystemBase {

    Ultrasonic m_frontSensor = new Ultrasonic(Constants.DIO_0, Constants.DIO_1);


    public ProximitySubsystem() {
        m_frontSensor.setAutomaticMode(true);
    }

    @Override
    public void periodic() {
      // This method will be called once per scheduler run
  
        System.out.println("Sensor: " + m_frontSensor.getRangeInches());

        if (m_frontSensor.getRangeInches() < 20.0) {
            RobotContainer.getDrivebaseSubsystem().moveBackward();
        }

    }
}