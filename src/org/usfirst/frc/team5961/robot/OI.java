package org.usfirst.frc.team5961.robot;

import static org.usfirst.frc.team5961.robot.Robot.oi;

import org.usfirst.frc.team5961.robot.commands.Eat;
import org.usfirst.frc.team5961.robot.commands.Forward;
import org.usfirst.frc.team5961.robot.commands.Rotate;
import org.usfirst.frc.team5961.robot.commands.StopAndHoldEater;
import org.usfirst.frc.team5961.robot.commands.ToggelSpeed;
import org.usfirst.frc.team5961.robot.commands.eBCam;
import org.usfirst.frc.team5961.robot.commands.eEat;
import org.usfirst.frc.team5961.robot.commands.eFCam;
import org.usfirst.frc.team5961.robot.commands.eThrow;
import org.usfirst.frc.team5961.robot.triggers.POV;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	Joystick driverJoystick = new Joystick(0);
	public Boolean full=false;
	public OI(){
		Button eatButton = new JoystickButton(driverJoystick,OIMap.eatPort);
		Button shootButton = new JoystickButton(driverJoystick,OIMap.throwPort);
		Button eStopRollerButton = new JoystickButton(driverJoystick, OIMap.eStopRoller);
		Button eEatButton = new JoystickButton(driverJoystick, OIMap.eEat);
		Button turboButton = new JoystickButton(driverJoystick, OIMap.turboPort);
		
		Button forwardButton = new JoystickButton(driverJoystick, OIMap.forwardCam);
		Button camButton = new JoystickButton(driverJoystick, OIMap.ballCam);
		
		Trigger povUp=new POV(driverJoystick,0);
		Trigger povDown=new POV(driverJoystick,180);
		Trigger povLeft=new POV(driverJoystick,270);
		//Basic Buttons
		eatButton.whenPressed(new Eat());
		shootButton.whileHeld(new eThrow());
		//Turbo Button
		turboButton.whenPressed(new ToggelSpeed());
		//eButtons
		eStopRollerButton.whenPressed(new StopAndHoldEater());
		eEatButton.whileHeld(new eEat());
		//POV
		povUp.whileActive(new Forward(0.5,1));
		povDown.whileActive(new Forward(-0.5,1));
		povLeft.whenActive(new Rotate(0.35,0.5));
		//cams
		forwardButton.whenPressed(new eFCam());
		camButton.whenPressed(new eBCam());
	}
	public double getDriverY() {
		return driverJoystick.getY();
	}
	public double getDriverX() {
		return driverJoystick.getZ()*SmartDashboard.getNumber("rotateSpeed");
	}
	public double getDriverR(){
		if (full){
			double r = (-oi.getDriverY() + oi.getDriverX());
			if (r>1){
				return 1;
			}else{
				return r;
			}
		}else{
			double r = (-oi.getDriverY() + oi.getDriverX())*RobotMap.maxSpeed;
			if (r>RobotMap.maxSpeed){
				return RobotMap.maxSpeed;
			}else{
				return r;
			}
		}
		
	}
	public double getDriverL(){
		if (full){
			double r = (-oi.getDriverY() - oi.getDriverX());
			if (r>1){
				return 1;
			}else{
				return r;
			}
		}else{
			double r = (-oi.getDriverY() - oi.getDriverX())*RobotMap.maxSpeed;
			if (r>RobotMap.maxSpeed){
				return RobotMap.maxSpeed;
			}else{
				return r;
			}
		}
	}
	
	
}

