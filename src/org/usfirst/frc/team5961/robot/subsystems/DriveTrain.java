package org.usfirst.frc.team5961.robot.subsystems;

import org.usfirst.frc.team5961.robot.commands.JoyDrive;

import componets.GearBox;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private Spark left, right;
    
    public DriveTrain(Spark left, Spark right) {
    	this.left = left;
    	this.right=right;
	}
    
    public DriveTrain(int left1port,int left2port, int right1port, int right2port) {
    	this.left = new Spark(left1port);
    	this.right = new Spark(right1port);
    }
            
	public void drive(double speed_left,double speed_right) {
		left.set(speed_left);
		right.set(-speed_right);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new JoyDrive());
    }
    
    /**
	 *
	 * @param speed
	 */
	public void forward(double speed) {
		drive(speed,speed);
	}
}

