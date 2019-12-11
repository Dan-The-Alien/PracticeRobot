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
  public static int kDriverController = 0;

  public static int kMotorLeftFront = 0;
  public static int kMotorLeftBack = 1;
  public static int kMotorRightFront = 2;
  public static int kMotorRightBack = 3;
  
  public static int kDLeftX = 0;
  public static int kDLeftY = 1;
  public static int kDRightX = 4;
  public static int kDRightY = 5;

  public static int kDTriggerLeft = 2;
  public static int kDTriggerRight = 3;

  public static int kDButtonLeft = 4;
  public static int kDButtonRight = 5;
  public static int kDButtonA = 0;
  public static int kDButtonB = 1;
  public static int kDButtonX = 2;
  public static int kDButtonY = 3;
  public static int kDButtonBack = 6;
  public static int kDButtonMenu = 7;
  public static int kDButtonStickLeft = 8;
  public static int kDButtonStickRight = 9;

  public static int kDDpadUp = 0;
  public static int kDDpadRight = 90;
  public static int kDDpadDown = 180;
  public static int kDDpadLeft = 270;


  public static int kTireDiameter = 6; //inches 
}
