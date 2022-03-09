// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

// CAN Ports
    public static final int LEFT_FRONT_DRIVE_PORT = 2;
    public static final int LEFT_BACK_DRIVE_PORT = 1;
    public static final int RIGHT_FRONT_DRIVE_PORT = 3;
    public static final int RIGHT_BACK_DRIVE_PORT = 0;

// Driver Ports
    public static final int DRIVERSTICK_PORT = 0;
    public static final int DRIVERSTICK_X_AXIS_PORT = 0;
    public static final int DRIVERSTICK_Y_AXIS_PORT = 1;


// PWM Ports
public static final int INTAKE_SPARK_PORT = 0;

//Scalars
public static final double INTAKE_SPEED_SCALAR = 0;
public static final int INDEX_R_SPARK_PORT = 0;
public static final int INDEX_L_SPARK_PORT = 0;
public static final double INDEX_SPEED_SCALAR = 0;

//IO
public static final int BUTTON_1 = 1;
public static final int BUTTON_2 = 2;

}
