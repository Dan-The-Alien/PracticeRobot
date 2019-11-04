/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class RobotVision extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.


  //I'm still working on this one here, if anyone (I'm looking at you, Kai) wants to develop it, feel free. 
  //The rPi vision co-processor returns Network Table vaules ranging from 0 to 1 (I think) for the values 
  //of the detected object's x position, y position, and area. I need a program here that can interpret those 
  //values to determine the object's distance and location relative to the robot, in inches
  //(or other real-world unit).

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
