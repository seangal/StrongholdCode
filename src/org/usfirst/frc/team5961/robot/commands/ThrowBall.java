package org.usfirst.frc.team5961.robot.commands;

import static org.usfirst.frc.team5961.robot.Robot.ballEater;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ThrowBall extends Command {

    public ThrowBall() {
    	 requires(ballEater);

    }

    // Called just before this Command runs the first time
    protected void initialize() {
   	 setTimeout(2); //should be here, not in constructor :)
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	ballEater.throwBall();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	ballEater.hold();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
}
