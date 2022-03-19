// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Index extends SubsystemBase {
  private Spark indexMotorR;
  private Spark indexMotorL;
  /** Creates a new Index. */
  public Index() {
    indexMotorR = new Spark(Constants.INDEX_R_SPARK_PORT);
    indexMotorL = new Spark(Constants.INDEX_L_SPARK_PORT);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setSpeed(double speed){
    indexMotorL.setInverted(true);
    indexMotorL.set(speed);
    indexMotorR.set(-speed);
  }
}
