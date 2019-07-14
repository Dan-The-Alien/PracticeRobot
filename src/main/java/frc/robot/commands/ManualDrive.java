/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class ManualDrive extends Command {
  public ManualDrive() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.driveTrain);
  }
  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double driveStick =  Robot.oi.getDriverRawAxis(RobotMap.D_LEFT_Y);
    double turnStick = Robot.oi.getDriverRawAxis(RobotMap.D_RIGHT_X);

    Robot.driveTrain.setLeftMotor(driveStick - (0.5 * turnStick - 0.5));
    Robot.driveTrain.setRightMotor(driveStick + (0.5 * turnStick - 0.5));


  }
  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.driveTrain.setLeftMotor(0);
    Robot.driveTrain.setRightMotor(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    this.end();
  }
}
