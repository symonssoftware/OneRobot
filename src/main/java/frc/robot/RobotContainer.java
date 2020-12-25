/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.PerpetualCommand;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  // Robot Subsystems
  private final static DrivebaseSubsystem m_drivebaseSubsystem = new DrivebaseSubsystem();
  private final static NavigationSubsystem m_navigationSubsystem = new NavigationSubsystem();
  private final static VisionProcessor m_visionProcessor = new VisionProcessor();
  private final static ProximitySubsystem m_proximitySubsystem = new ProximitySubsystem();
  private final static RotatingSensorSubsystem m_rotatingSensorSubsystem = new RotatingSensorSubsystem();

  // Robot Commands
  private final static MoveCameraBackwardCommand m_moveCameraBackwardCommand = new MoveCameraBackwardCommand(
      m_drivebaseSubsystem, m_visionProcessor);
  private final static MoveCameraForwardCommand m_moveCameraForwardCommand = new MoveCameraForwardCommand(
      m_drivebaseSubsystem, m_visionProcessor);
  private final static MoveCameraStrafeRightCommand m_moveCameraStrafeRightCommand = new MoveCameraStrafeRightCommand(
      m_drivebaseSubsystem, m_visionProcessor);
  private final static MoveCameraStrafeLeftCommand m_moveCameraStrafeLeftCommand = new MoveCameraStrafeLeftCommand(
      m_drivebaseSubsystem, m_visionProcessor);
  private final static StopCameraMoveCommand m_stopCameraMoveCommand = new StopCameraMoveCommand(m_drivebaseSubsystem);
 
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    //configureShuffleboardBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  
  }

// Use this method to define shuffleboard buttons or widgets
private void configureShuffleboardBindings() {

  // Command Buttons
  SmartDashboard.putData("MoveCameraBackwardCommand", getMoveCameraBackwardCommand());
  SmartDashboard.putData("MoveCameraForwardCommand", getMoveCameraForwardCommand());
  SmartDashboard.putData("MoveCameraStrafeLeftCommand", getMoveCameraStrafeLeftCommand());
  SmartDashboard.putData("MoveCameraStrafeRightCommand", getMoveCameraStrafeRightCommand());
  SmartDashboard.putData("StopCameraMoveCommand", getStopMoveCameraCommand());
}



  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }

  
  public static MoveCameraBackwardCommand getMoveCameraBackwardCommand() {
    return m_moveCameraBackwardCommand;
  }

  public static MoveCameraForwardCommand getMoveCameraForwardCommand() {
    return m_moveCameraForwardCommand;
  }

  public static MoveCameraStrafeRightCommand getMoveCameraStrafeRightCommand() {
    return m_moveCameraStrafeRightCommand;
  }

  public static MoveCameraStrafeLeftCommand getMoveCameraStrafeLeftCommand() {
    return m_moveCameraStrafeLeftCommand;
  }

  public static StopCameraMoveCommand getStopMoveCameraCommand() {
    return m_stopCameraMoveCommand;
  }


  // Subsystem Getters

  public static DrivebaseSubsystem getDrivebaseSubsystem() {
    return m_drivebaseSubsystem;
  }

  public static NavigationSubsystem getNavigationSubsystem() {
    return m_navigationSubsystem;
  }

  public static VisionProcessor getVisionProcessor() {
    return m_visionProcessor;
  }

  public static ProximitySubsystem getProximitySubsystem() {
    return m_proximitySubsystem;
  }
  
  public static RotatingSensorSubsystem getRotatingSensorSubsystem() {
    return m_rotatingSensorSubsystem;
  }
}
