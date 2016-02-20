package org.usfirst.frc.team5961.robot.subsystems;

import org.usfirst.frc.team5961.robot.RobotMap;
import org.usfirst.frc.team5961.robot.commands.StopAndHoldEater;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class BallEater extends Subsystem {
    
	private VictorSP victor;
	private DigitalInput limit;
	public BallEater(int port,int limitPort) {
    	this.victor = new VictorSP(port);
    	this.limit = new DigitalInput(limitPort);
    }
	public void eatBall(){
		victor.set(-SmartDashboard.getNumber("eatSpeed",RobotMap.eatSpeed));
	}
	public void throwBall(){
		victor.set(SmartDashboard.getNumber("throwSpeed",RobotMap.throwSpeed));
	}
	public void hold(){
		victor.set(-SmartDashboard.getNumber("holdSpeed",RobotMap.holdSpeed));
	}
	public void stop(){
		victor.set(0);
	}
    public void initDefaultCommand() {
        setDefaultCommand(new StopAndHoldEater());
    }
	public boolean haveBall() {
		return !limit.get();
	}
}

