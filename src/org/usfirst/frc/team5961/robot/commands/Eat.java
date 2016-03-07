package org.usfirst.frc.team5961.robot.commands;

import static org.usfirst.frc.team5961.robot.Robot.ballEater;
import static org.usfirst.frc.team5961.robot.Robot.cameraController;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Eat extends Command {

    public Eat() {
        // Use requires() here to declare subsystem dependencies
    	requires(ballEater);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	ballEater.eatBall();
    	cameraController.ball_cam();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return ballEater.haveBall();
    }

    // Called once after isFinished returns true
    protected void end() {
    	ballEater.hold();
    	cameraController.forward();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
