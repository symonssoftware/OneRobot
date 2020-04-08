package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.DrivebaseSubsystem;
import frc.robot.subsystems.VisionProcessor;

/**
 *
 */
public class MoveCameraStrafeRightCommand extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    private final DrivebaseSubsystem m_drivebaseSubsystem;
    private final VisionProcessor m_VisionProcessor;

    public MoveCameraStrafeRightCommand(DrivebaseSubsystem drivebaseSubsystem, VisionProcessor visionProcessor) {
        m_drivebaseSubsystem = drivebaseSubsystem;
        m_VisionProcessor = visionProcessor;

        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(m_drivebaseSubsystem);
    }

    // Called once when this command runs
    @Override
    public void initialize() {
    }
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_drivebaseSubsystem.strafeRight();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        // double horizOffset = m_VisionProcessor.getHorizOffsetFromCenter();
        // if (horizOffset < Constants.VISION_TARGET_TOLERANCE_IN_INCHES) {
        //     return true;
        // }

        return false;
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_drivebaseSubsystem.stop();
    }
}