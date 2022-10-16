// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.TalonSRXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveBase extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private WPI_TalonSRX driveLeftFront;
  private WPI_TalonSRX driveLeftBack;
  private WPI_TalonSRX driveRightFront;
  private WPI_TalonSRX driveRightBack;

  private MotorControllerGroup leftControllerGroup;
  private MotorControllerGroup rightControllerGroup;
  private DifferentialDrive differentialDrive;
  private double initalLEncoderValue = 0;
  private double initialRencoderValue = 0;
  private boolean atLocation = false;

  public DriveBase() {
    this.driveLeftFront = new WPI_TalonSRX(Constants.LEFT_FRONT_DRIVE_PORT);
    this.driveLeftBack = new WPI_TalonSRX(Constants.LEFT_BACK_DRIVE_PORT);
    this.driveRightFront = new WPI_TalonSRX(Constants.RIGHT_FRONT_DRIVE_PORT);
    this.driveRightBack = new WPI_TalonSRX(Constants.RIGHT_BACK_DRIVE_PORT);

    driveLeftBack.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
    driveRightFront.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);

    this.leftControllerGroup = new MotorControllerGroup(driveLeftFront, driveLeftBack);
    this.rightControllerGroup = new MotorControllerGroup(driveRightFront, driveRightBack);
    this.differentialDrive = new DifferentialDrive(leftControllerGroup, rightControllerGroup);
  }

  public void arcadeDrive(double speed, double rot){
    rightControllerGroup.setInverted(true);
    differentialDrive.arcadeDrive(-speed, rot);
    SmartDashboard.putNumber("leftEncoderRotations", driveLeftBack.getSelectedSensorPosition()/4096);
    SmartDashboard.putNumber("rightEncoderRotations", driveRightFront.getSelectedSensorPosition()/4096);


  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public boolean getAtLocation(){
    return this.atLocation;
  }



  public boolean driveToDistance(double distance_in){
    double currentDistance = (((Math.abs(driveRightFront.getSelectedSensorPosition())/4096) + (Math.abs(driveLeftBack.getSelectedSensorPosition())/4096))/2) * 18.84;
    if(distance_in - currentDistance >0){
      differentialDrive.tankDrive(-Constants.AUTONOMOUS_DRIVE_SPEED, Constants.AUTONOMOUS_DRIVE_SPEED);
    }
    else{
      differentialDrive.tankDrive(0, 0);
      atLocation = true;
    }
    return (distance_in - currentDistance > 0);

    
  }
  public void resetDriveEncoders(){
    driveRightFront.setSelectedSensorPosition(0);
    driveLeftBack.setSelectedSensorPosition(0);
  }

  public boolean LDriveToDistance(double distance_in, double speed){
    double currentLDistance = (Math.abs(driveLeftBack.getSelectedSensorPosition())/4096) * 18.84;
    if(distance_in - currentLDistance >0){
      differentialDrive.tankDrive(-Constants.AUTONOMOUS_DRIVE_SPEED, Constants.AUTONOMOUS_DRIVE_SPEED);
    }
    else{
      differentialDrive.tankDrive(0, 0);
      atLocation = true;
    }
    return (distance_in - currentLDistance > 0);

  }
  public boolean RDriveToDistance(double distance_in, double speed){
    double currentLDistance = (Math.abs(driveRightFront.getSelectedSensorPosition())/4096) * 18.84;
    if(distance_in - currentLDistance >0){
      differentialDrive.tankDrive(-Constants.AUTONOMOUS_DRIVE_SPEED, Constants.AUTONOMOUS_DRIVE_SPEED);
    }
    else{
      differentialDrive.tankDrive(0, 0);
      atLocation = true;
    }
    return (distance_in - currentLDistance > 0);

  }


  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
