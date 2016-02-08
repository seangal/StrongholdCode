package org.usfirst.frc.team5961.robot.subsystems;

import org.usfirst.frc.team5961.robot.commands.JoyDrive;

import componets.GearBox;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private GearBox left, right;
    
    public DriveTrain(GearBox left, GearBox right) {
    	this.left = left;
    	this.right=right;
	}
    
    public DriveTrain(int left1port,int left2port, int right1port, int right2port) {
    	this.left = new GearBox(left1port,left2port);
    	this.right = new GearBox(right1port,right2port);
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

