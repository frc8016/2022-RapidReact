// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Shooter;

public class HighPortShoot extends CommandBase {
  private Shooter m_shooter;


  /** Creates a new PrimativeRunShooter. */
  public HighPortShoot(Shooter shooter) {
    m_shooter = shooter;
    addRequirements(shooter);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_shooter.init();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_shooter.setFlywheelSpeed(Constants.FLYWHEEL_HIGH_PORT_SCALAR);
    m_shooter.cycleFeed(Constants.SHOOTER_FEED_SPEED);
    SmartDashboard.putNumber("Left Shooter RPM", m_shooter.getLEVelocity());
    SmartDashboard.putNumber("Right Shooter RPM", m_shooter.getREVelocity());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_shooter.setFlywheelSpeed(0);
    m_shooter.setFeedMotor(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_shooter.getFeedFinished();
  }
}