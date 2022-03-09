// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class DriveBase extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private WPI_TalonSRX driveLeftFront;
  private WPI_TalonSRX driveLeftBack;
  private WPI_TalonSRX driveRightFront;
  private WPI_TalonSRX driveRightBack;

  private MotorControllerGroup leftControllerGroup;
  private MotorControllerGroup rightControllerGroup;
  private DifferentialDrive differentialDrive;

  public DriveBase() {
    this.driveLeftFront = new WPI_TalonSRX(Constants.LEFT_FRONT_DRIVE_PORT);
    this.driveLeftBack = new WPI_TalonSRX(Constants.LEFT_BACK_DRIVE_PORT);
    this.driveRightFront = new WPI_TalonSRX(Constants.RIGHT_FRONT_DRIVE_PORT);
    this.driveRightBack = new WPI_TalonSRX(Constants.RIGHT_BACK_DRIVE_PORT);

    this.leftControllerGroup = new MotorControllerGroup(driveLeftFront, driveLeftBack);
    this.rightControllerGroup = new MotorControllerGroup(driveRightFront, driveRightBack);
    this.differentialDrive = new DifferentialDrive(leftControllerGroup, rightControllerGroup);
  }

  public void arcadeDrive(double speed, double rot){
    rightControllerGroup.setInverted(true);
    differentialDrive.arcadeDrive(speed, rot);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
