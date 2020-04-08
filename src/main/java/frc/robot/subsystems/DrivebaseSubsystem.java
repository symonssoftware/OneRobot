package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DrivebaseSubsystem extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */

  private WPI_TalonSRX m_rightFront = new WPI_TalonSRX(Constants.RIGHT_FRONT_MOTOR_CAN_ID);
  private WPI_TalonSRX m_rightRear = new WPI_TalonSRX(Constants.RIGHT_REAR_MOTOR_CAN_ID);
  private WPI_TalonSRX m_leftFront = new WPI_TalonSRX(Constants.LEFT_FRONT_MOTOR_CAN_ID);
  private WPI_TalonSRX m_leftRear = new WPI_TalonSRX(Constants.LEFT_REAR_MOTOR_CAN_ID);

  private static final int kJoystickChannel = 0;

  private MecanumDrive m_robotDrive;
  private Joystick m_stick;

  public DrivebaseSubsystem() {

    m_leftFront.configOpenloopRamp(0.5);
    m_leftRear.configOpenloopRamp(0.5);
    m_rightFront.configOpenloopRamp(0.5);
    m_rightRear.configOpenloopRamp(0.5);

    m_leftFront.setInverted(true);
    m_rightRear.setInverted(true);

    m_robotDrive = new MecanumDrive(m_leftFront, m_leftRear, m_rightFront, m_rightRear);
    m_robotDrive.setDeadband(0.3);

    m_stick = new Joystick(kJoystickChannel);

    register();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    // double x = m_stick.getX();
    // double y = m_stick.getY();
    // double z = m_stick.getZ();

    // System.out.println("X: " + x + " Y: " + y + " Z: " + z);

    m_robotDrive.driveCartesian(m_stick.getY(), m_stick.getX(), m_stick.getZ());
  }

  public void stop() {
      System.out.println("stop");
      m_leftFront.set(0);
      m_leftRear.set(0);
      m_rightFront.set(0);
      m_rightRear.set(0);
  }

  public void moveForward() {
    System.out.println("moveForward");

    m_leftFront.set(-Constants.VISION_MOTOR_SPEED);
    m_leftRear.set(Constants.VISION_MOTOR_SPEED);
    m_rightFront.set(-Constants.VISION_MOTOR_SPEED);
    m_rightRear.set(Constants.VISION_MOTOR_SPEED);
  }

  public void moveBackward() {
    System.out.println("moveBackward");

    m_leftFront.set(Constants.VISION_MOTOR_SPEED);
    m_leftRear.set(-Constants.VISION_MOTOR_SPEED);
    m_rightFront.set(Constants.VISION_MOTOR_SPEED);
    m_rightRear.set(-Constants.VISION_MOTOR_SPEED);
  }

  public void strafeRight() {
    System.out.println("strafeRight");

    m_leftFront.set(-Constants.VISION_MOTOR_SPEED);
    m_leftRear.set(-Constants.VISION_MOTOR_SPEED);
    m_rightFront.set(Constants.VISION_MOTOR_SPEED);
    m_rightRear.set(Constants.VISION_MOTOR_SPEED);
  }

  public void strafeLeft() {
    System.out.println("strafeLeft");

    m_leftFront.set(Constants.VISION_MOTOR_SPEED);
    m_leftRear.set(Constants.VISION_MOTOR_SPEED);
    m_rightFront.set(-Constants.VISION_MOTOR_SPEED);
    m_rightRear.set(-Constants.VISION_MOTOR_SPEED);
  }
}
