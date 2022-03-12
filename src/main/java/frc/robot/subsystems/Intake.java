// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class Intake extends SubsystemBase {
  private Spark intakeRollers;

  private DoubleSolenoid leftSolenoid;
  private DoubleSolenoid rightSolenoid;

  /** Creates a new Intake. */
  public Intake() {
    intakeRollers = new Spark(Constants.INTAKE_SPARK_PORT);
    leftSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.L_PNEUMATIC_FORWARD_CHANNEL, Constants.L_PNEUMATIC_REVERSE_CHANNEL);
    rightSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.R_PNEUMATIC_FORWARD_CHANNEL, Constants.R_PNEUMATIC_REVERSE_CHANNEL);
    leftSolenoid.set(Value.kOff);
    rightSolenoid.set(Value.kOff);
  }

  public void setRollerSpeed(double speed){
    intakeRollers.set(speed);
  }

  public void extendIntake(){
    leftSolenoid.set(Value.kForward);
    rightSolenoid.set(Value.kForward);
  }

  public void retractIntake(){
    leftSolenoid.set(Value.kReverse);
    rightSolenoid.set(Value.kReverse);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
