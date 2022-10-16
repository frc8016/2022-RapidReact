// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.net.Inet4Address;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandGroupBase;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveBase;
import frc.robot.subsystems.Index;
import frc.robot.subsystems.Shooter;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutonomousCommand extends SequentialCommandGroup {
  private DriveBase m_driveBase;
  private Shooter m_shooter;
  private Index m_index; 
  /** Creates a new AutonomousCommand. */
  public AutonomousCommand(DriveBase driveBase, Shooter shooter, Index index) {
    this.m_driveBase = driveBase;
    this.m_shooter = shooter;
    this.m_index = index;
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      
      new ParallelRaceGroup(new HighPortShoot(m_shooter, 4), new RunIndex(m_index)), 
      new AutonomousRetreat(m_driveBase)
      );
  }
}
