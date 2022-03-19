// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.AscendClimb;
import frc.robot.commands.AutonomousApproach;
import frc.robot.commands.DescendClimb;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.ExtendIntake;
import frc.robot.commands.High_Port_Shooter;
import frc.robot.commands.OffIntake;
import frc.robot.commands.PrimativeRunShooter;
import frc.robot.commands.RetractIntake;
import frc.robot.commands.ReverseIntake;
import frc.robot.commands.RunIndex;
import frc.robot.commands.RunIntake;
import frc.robot.commands.StopIntakeRollers;
import frc.robot.subsystems.Climb;
import frc.robot.subsystems.DriveBase;
import frc.robot.subsystems.Index;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private Joystick driverStick = new Joystick(Constants.DRIVERSTICK_PORT);
  // The robot's subsystems and commands are defined here...
  private final DriveBase driveBase = new DriveBase();
  private final Intake intake = new Intake();
  private final Index index = new Index();
  private final Shooter shooter = new Shooter();
  private final Climb climb = new Climb();

  private final ArcadeDrive arcadeDrive = new ArcadeDrive(driveBase, driverStick);
  private final RunIntake runIntake = new RunIntake(intake);
  private final RunIndex runIndex = new RunIndex(index);
  private final PrimativeRunShooter primativeRunShooter = new PrimativeRunShooter(shooter);
  private final ExtendIntake extendIntake = new ExtendIntake(intake);
  private final RetractIntake retractIntake = new RetractIntake(intake);
  private final OffIntake offIntake = new OffIntake(intake);
  private final AscendClimb ascendClimb = new AscendClimb(climb);
  private final DescendClimb descendClimb = new DescendClimb(climb);
  private final ReverseIntake reverseIntake = new ReverseIntake(intake);
  private final StopIntakeRollers stopIntakeRollers = new StopIntakeRollers(intake);
  private final AutonomousApproach autonomousApproach = new AutonomousApproach(driveBase);
  private final High_Port_Shooter high_Port_Shooter = new High_Port_Shooter(shooter);


  private final JoystickButton joy1 = new JoystickButton(driverStick, 1);
  private final JoystickButton joy2 = new JoystickButton(driverStick, 2);
  private final JoystickButton joy3 = new JoystickButton(driverStick, 3);
  private final JoystickButton joy4 = new JoystickButton(driverStick, 4);
  private final JoystickButton joy5 = new JoystickButton(driverStick, 5);
  private final JoystickButton joy6 = new JoystickButton(driverStick, 6);
  private final JoystickButton joy7 = new JoystickButton(driverStick, 7);
  private final JoystickButton joy8 = new JoystickButton(driverStick, 8);
  private final JoystickButton joy9 = new JoystickButton(driverStick, 9);
  private final JoystickButton joy10 = new JoystickButton(driverStick, 10);


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
   configureButtonBindings();
    driveBase.setDefaultCommand(arcadeDrive);
    index.setDefaultCommand(runIndex);
  }

  /**g
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  joy1.whileHeld(primativeRunShooter);
  joy2.whenPressed(stopIntakeRollers);
  joy3.whileHeld(reverseIntake, true);
  joy4.whenPressed(retractIntake);
  joy5.whenPressed(runIntake);
  joy6.toggleWhenPressed(extendIntake);
  joy7.whileHeld(ascendClimb);
  joy8.whileHeld(descendClimb);
  joy10.whileHeld(high_Port_Shooter);






  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return autonomousApproach;
  }
}
