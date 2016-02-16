package org.usfirst.frc.team5961.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import static org.usfirst.frc.team5961.robot.Robot.ballEater;
import static org.usfirst.frc.team5961.robot.Robot.cameraController;
/**
 *
 */
public class EatOrShoot extends Command {
	private Boolean isEating = false;
    public EatOrShoot() {
        // Use requires() here to declare subsystem dependencies
        requires(ballEater);
        isEating=!ballEater.haveBall();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (isEating){ // if don't have ball
	    	ballEater.eatBall();
	    	//cameraController.ball_cam();
    	}else{
    		ballEater.throwBall();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(isEating){
    		return ballEater.haveBall();
    	}else{
    		return isTimedOut();
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	ballEater.hold();
    	//cameraController.forward();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
