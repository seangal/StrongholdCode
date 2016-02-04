package org.usfirst.frc.team5961.robot.commands;

import static org.usfirst.frc.team5961.robot.Robot.driveTrain;
import static org.usfirst.frc.team5961.robot.Robot.oi;
import static org.usfirst.frc.team5961.robot.Robot.cameraController;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class JoyDrive extends Command {


	
    public JoyDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(driveTrain);
    	
    }
    // Called just before this Command runs the first time
    protected void initialize() {
    	driveTrain.drive(0,0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double r = oi.getDriverR();
    	double l = oi.getDriverL();
    	driveTrain.drive(r,l);
    	if(r+l>=0){
    		cameraController.forward();
    	}else{
    		cameraController.back();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	driveTrain.drive(0,0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
