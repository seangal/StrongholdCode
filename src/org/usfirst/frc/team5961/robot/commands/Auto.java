package org.usfirst.frc.team5961.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Auto extends CommandGroup {
    double rotateTime=0.5;
    public  Auto(String status) {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	if("1".equals(status)){
    		System.out.println("1");
        	addSequential(new Forward(-0.6,2));
        	addSequential(new Rotate(-0.2,0.3));
        	addSequential(new Forward(-0.4,1.8));
        	addSequential(new Forward(-0.2,0.5));
        	addSequential(new Forward(0.4,0.2));
        	addSequential(new Rotate(0.35,rotateTime));
        	addSequential(new Forward(0.4,1.5*1.1));
        	addSequential(new ThrowBall());
        	addSequential(new Forward(-0.4,1.3));
        	addSequential(new Rotate(-0.35,rotateTime));
    	}else if("0".equals(status)){
        	addSequential(new Forward(-0.4,0.4));
    	}else if("2".equals(status)){
    		addSequential(new Forward(-0.6,3));
    	}else if("3".equals(status)){
    		addSequential(new Forward(0.6,3));
    	}
    }
}
