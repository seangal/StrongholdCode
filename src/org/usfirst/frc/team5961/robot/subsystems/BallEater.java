package org.usfirst.frc.team5961.robot.subsystems;

import org.usfirst.frc.team5961.robot.commands.StopEat;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BallEater extends Subsystem {
    
	private VictorSP victor;
	private double speed=0.45;
	
	public BallEater(int port) {
    	this.victor = new VictorSP(port);
	}
	public void eatBall(){
		victor.set(speed);
	}
	public void throwBall(){
		victor.set(-speed);
	}
	public void stop(){
		victor.set(0);
	}
    public void initDefaultCommand() {
        setDefaultCommand(new StopEat());
    }
}

