package org.usfirst.frc.team5961.robot;

import static org.usfirst.frc.team5961.robot.Robot.oi;
import static org.usfirst.frc.team5961.robot.Robot.cameraController;

import org.usfirst.frc.team5961.robot.commands.EatOrShoot;
import org.usfirst.frc.team5961.robot.commands.StopAndHoldEater;
import org.usfirst.frc.team5961.robot.commands.eEat;
import org.usfirst.frc.team5961.robot.commands.eThrow;

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
	
	public OI(){
		Button eatButton = new JoystickButton(driverJoystick,OIMap.eatOrShootPort);
		Button eStopRollerButton = new JoystickButton(driverJoystick, OIMap.eStopRoller);
		Button eEatButton = new JoystickButton(driverJoystick, OIMap.eStopRoller);
		Button eThrowButton = new JoystickButton(driverJoystick, OIMap.eStopRoller);
		Button forwardCamButton = new JoystickButton(driverJoystick, OIMap.eStopRoller);
		Button ballCamButton = new JoystickButton(driverJoystick, OIMap.eStopRoller);
		
		eatButton.whileHeld(new EatOrShoot());
		//eButtons
		eStopRollerButton.whenPressed(new StopAndHoldEater());
		eEatButton.whileHeld(new eEat());
		eThrowButton.whileHeld(new eThrow());
		
		//camera buttons
		forwardCamButton.whenPressed(forward());
		ballCamButton.whenPressed(ball());
	}
	
	private Command forward() {
		cameraController.forward();
		return null;
	}
	private Command ball() {
		cameraController.ball_cam();
		return null;
	}
	public double getDriverY() {
		return driverJoystick.getY();
	}
	public double getDriverX() {
		return driverJoystick.getZ();
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

