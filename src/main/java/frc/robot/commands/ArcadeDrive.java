// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.DriveBase;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example driveBase. */
public class ArcadeDrive extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private DriveBase m_drivebase;
  private Joystick m_driverStick;

  /**
   * Creates a new ExampleCommand.
   *
   * @param driveBase The driveBase used by this command.
   */
  public ArcadeDrive(DriveBase driveBase, Joystick driverStick) {
    m_drivebase = driveBase;
    m_driverStick = driverStick;
    // Use addRequirements() here to declare driveBase dependencies.
    addRequirements(driveBase);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivebase.arcadeDrive(m_driverStick.getRawAxis(Constants.DRIVERSTICK_Y_AXIS_PORT), 
    m_driverStick.getRawAxis(Constants.DRIVERSTICK_X_AXIS_PORT));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
