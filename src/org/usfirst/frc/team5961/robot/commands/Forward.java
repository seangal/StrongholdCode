package org.usfirst.frc.team5961.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import static org.usfirst.frc.team5961.robot.Robot.driveTrain;
//import static org.usfirst.frc.team5961.robot.Robot.cameraController;;
/**
 *
 */
public class Forward extends Command {
	double speed;
	double time;
    
    public Forward(double speed2, double time2) {
    	requires(driveTrain);
		this.speed = speed2;
		this.time = time2;
	}

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(time);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		driveTrain.forward(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	driveTrain.forward(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
