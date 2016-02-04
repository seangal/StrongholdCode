package org.usfirst.frc.team5961.robot;

import static org.usfirst.frc.team5961.robot.Robot.oi;

import org.usfirst.frc.team5961.robot.commands.Eat;
import org.usfirst.frc.team5961.robot.commands.ThrowBall;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	Joystick driverJoystick = new Joystick(0);
	final int eatPort = 2;
	final int throwPort = 1;
	public OI(){
		Button eatButton = new JoystickButton(driverJoystick,eatPort);
		Button throwButton = new JoystickButton(driverJoystick,throwPort);
		eatButton.whenPressed(eat());
		throwButton.whenPressed(new ThrowBall());
	}
	Command eat(){
		System.out.println("eat");
		return new Eat();
	}
	
	public double getDriverY() {
		return driverJoystick.getY();
	}
	public double getDriverX() {
		return driverJoystick.getX();
	}
	public double getDriverR(){
		double r = (-oi.getDriverY() + oi.getDriverX())*RobotMap.maxSpeed;
		if (r>RobotMap.maxSpeed){
			return RobotMap.maxSpeed;
		}else{
			return r;
		}
		
	}
	public double getDriverL(){
		double l = (-oi.getDriverY() - oi.getDriverX())*RobotMap.maxSpeed;
		if (l>RobotMap.maxSpeed){
			return RobotMap.maxSpeed;
		}else{
			return l;
		}
	}
}

