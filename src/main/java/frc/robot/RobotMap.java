/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

// If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
  public static int DRIVER_CONTROLLER = 0;

  public static int MOTOR_LEFT_FRONT = 0;
  public static int MOTOR_LEFT_BACK = 1;
  public static int MOTOR_RIGHT_FRONT = 2;
  public static int MOTOR_RIGHT_BACK = 3;
  
  public static int D_LEFT_X = 0;
  public static int D_LEFT_Y = 1;
  public static int D_RIGHT_X = 4;
  public static int D_RIGHT_Y = 5;

  public static int D_TRIGGER_LEFT = 2;
  public static int D_TRIGGER_RIGHT = 3;

  public static int D_BUTTON_LEFT = 4;
  public static int D_BUTTON_RIGHT = 5;
  public static int D_BUTTON_A = 0;
  public static int D_BUTTON_B = 1;
  public static int D_BUTTON_X = 2;
  public static int D_BUTTON_Y = 3;
  public static int D_BUTTON_BACK = 6;
  public static int D_BUTTON_MENU = 7;
  public static int D_BUTTON_STICK_LEFT = 8;
  public static int D_BUTTON_STICK_RIGHT = 9;

  public static int D_DPAD_UP = 0;
  public static int D_DPAD_RIGHT = 90;
  public static int D_DPAD_DOWN = 180;
  public static int D_DPAD_LEFT = 270;


  public static int TIRE_DIAMETER = 6; //inches 
}
