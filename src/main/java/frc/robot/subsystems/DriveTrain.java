/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotLogger;
import frc.robot.RobotMap;
import frc.robot.commands.ManualDrive;
import java.lang.Math;
import java.util.logging.Level;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private VictorSPX motor_left_back = new VictorSPX(RobotMap.MOTOR_LEFT_BACK);
  private VictorSPX motor_left_front = new VictorSPX(RobotMap.MOTOR_LEFT_FRONT);
  private VictorSPX motor_right_back = new VictorSPX(RobotMap.MOTOR_RIGHT_BACK);
  private VictorSPX motor_right_front = new VictorSPX(RobotMap.MOTOR_RIGHT_FRONT);

  public void setLeftMotors(double speed) {
    motor_left_back.set(ControlMode.PercentOutput, speed);
    motor_left_front.set(ControlMode.PercentOutput, speed);
    RobotLogger.logger.log(Level.FINEST, "Left motor speed set to " + speed);
  }

  public void setRightMotors(double speed) {
    motor_right_back.set(ControlMode.PercentOutput, -speed);
    motor_right_front.set(ControlMode.PercentOutput, -speed);
    RobotLogger.logger.log(Level.FINEST, "Left motor speed set to " + -speed);
  }

  public double getRobotSpeed(double motorPower1, double motorPower2) {
    double averageMotorPower = (motorPower1 + motorPower2) / 2;
    double rpm = averageMotorPower * RobotMap.MAX_WHEEL_RPM;
    double speed = rpm/60 * (RobotMap.TIRE_DIAMETER * Math.PI);
    return speed;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new ManualDrive());
    RobotLogger.logger.log(Level.INFO, "Drivetrain default command set to ManualDrive");
  }
}