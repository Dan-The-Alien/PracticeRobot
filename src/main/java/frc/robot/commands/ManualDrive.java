/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.logging.Level;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotLogger;
import frc.robot.RobotMap;

public class ManualDrive extends Command {
  public ManualDrive() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.driveTrain);
  }
  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    RobotLogger.logger.log(Level.INFO, "ManualDrive command initialized");
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double leftStick =  Robot.oi.getDriverRawAxis(RobotMap.kDLeftY);
    double rightStick = Robot.oi.getDriverRawAxis(RobotMap.kDRightY);

    Robot.driveTrain.setLeftMotors(leftStick);
    Robot.driveTrain.setRightMotors(rightStick);

    
  }
  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.driveTrain.setLeftMotors(0);
    Robot.driveTrain.setRightMotors(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    this.end();
    RobotLogger.logger.log(Level.INFO, "Command ManualDrive interrupted");
  }
}