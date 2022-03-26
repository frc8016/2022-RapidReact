// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {

  private CANSparkMax leftShooterMotor = new CANSparkMax(Constants.L_SHOOTER_PORT, MotorType.kBrushless);
  private CANSparkMax rightShooterMotor = new CANSparkMax(Constants.R_SHOOTER_PORT, MotorType.kBrushless);
  private CANSparkMax feedMotor = new CANSparkMax(Constants.SHOOTER_FEED_MOTOR_PORT, MotorType.kBrushed);
  private RelativeEncoder leftEncoder = leftShooterMotor.getEncoder();
  private RelativeEncoder rightEncoder = rightShooterMotor.getEncoder();
  private DigitalInput feedLimitSwitch = new DigitalInput(Constants.FEED_LIMIT_SWITCH_PORT);

  private boolean hasOpened = true;
  private boolean feedFinished = false;

  /** Creates a new Shooter. */
  public Shooter() {}


  public void init(){}

  public void setFlywheelSpeed(double speed){
    rightShooterMotor.set(speed);
    leftShooterMotor.follow(rightShooterMotor, true);
  }

  //Returns Left Flywheel Motor Velocity in RPM
  public double getLEVelocity(){
    return leftEncoder.getVelocity();
  }

  //Returns Right Flywheel Motor Velocity in RPM
  public double getREVelocity(){
    return rightEncoder.getVelocity();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void zeroFeed(double speed){
    if(feedLimitSwitch.get()){
      feedMotor.set(0);
    }
    else{
      feedMotor.set(speed);
    }

  }
  
  public boolean getFeedFinished(){
    return this.feedFinished;
  }

  public void setFeedMotor(double speed){
    feedMotor.set(speed);

  }
  public boolean cycleFeed(double speed){
    if(feedLimitSwitch.get()){
      hasOpened = false;
      feedMotor.set(speed);
    }
    else{
      hasOpened = true;
    }
    while(hasOpened){
      feedMotor.set(speed);
      if(feedLimitSwitch.get()){
        hasOpened = false;
        feedFinished = true;
        return true;
        }
      }
    feedFinished = false;
    return false;

  }



}
