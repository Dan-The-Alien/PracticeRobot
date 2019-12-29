/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import frc.robot.RobotLogger;
import frc.robot.RobotMap;
import frc.robot.commands.ManualDrive;
import java.util.logging.Level;
import edu.wpi.first.wpilibj.SPI;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private VictorSPX motor_left_back = new VictorSPX(RobotMap.kMotorLeftBack);
  private VictorSPX motor_left_front = new VictorSPX(RobotMap.kMotorLeftFront);
  private VictorSPX motor_right_back = new VictorSPX(RobotMap.kMotorRightBack);
  private VictorSPX motor_right_front = new VictorSPX(RobotMap.kMotorRightFront);

  public Gyro gyro = new ADXRS450_Gyro(SPI.Port.kMXP);

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

  public void drive(double xSpeed, double zRotation, double error, boolean squareInputs) {
   
    // Square the inputs (while preserving the sign) to increase fine control
    // while permitting full power.
    if (squareInputs) {
      xSpeed = Math.copySign(xSpeed * xSpeed, xSpeed);
      zRotation = Math.copySign(zRotation * zRotation, zRotation);
    }

    double leftMotorOutput;
    double rightMotorOutput;

    double maxInput = Math.copySign(Math.max(Math.abs(xSpeed), Math.abs(zRotation)), xSpeed);

    if (xSpeed >= 0.0) {
      // First quadrant, else second quadrant
      if (zRotation >= 0.0) {
        leftMotorOutput = maxInput;
        rightMotorOutput = xSpeed - zRotation;
      } else {
        leftMotorOutput = xSpeed + zRotation;
        rightMotorOutput = maxInput;
      }
    } else {
      // Third quadrant, else fourth quadrant
      if (zRotation >= 0.0) {
        leftMotorOutput = xSpeed + zRotation;
        rightMotorOutput = maxInput;
      } else {
        leftMotorOutput = maxInput;
        rightMotorOutput = xSpeed - zRotation;
      }

      if (zRotation == 0.0) {
        leftMotorOutput = leftMotorOutput + (RobotMap.kPHeading * error);
        rightMotorOutput = rightMotorOutput - (RobotMap.kPHeading * error);
      }
    }

    this.setLeftMotors(leftMotorOutput);
    this.setRightMotors(rightMotorOutput * -1);

  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new ManualDrive());
    RobotLogger.logger.log(Level.INFO, "Drivetrain default command set to ManualDrive");
  }
}