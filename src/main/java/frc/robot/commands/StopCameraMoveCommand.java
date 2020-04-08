package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.subsystems.DrivebaseSubsystem;

/**
 *
 */
public class StopCameraMoveCommand extends InstantCommand {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    private final DrivebaseSubsystem m_drivebaseSubsystem;

    public StopCameraMoveCommand(DrivebaseSubsystem drivebaseSubsystem) {
        m_drivebaseSubsystem = drivebaseSubsystem;

        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(m_drivebaseSubsystem);
    }

    // Called once when this command runs
    @Override
    public void initialize() {
        m_drivebaseSubsystem.stop();
    }

}