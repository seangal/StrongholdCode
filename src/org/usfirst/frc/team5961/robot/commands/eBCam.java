package org.usfirst.frc.team5961.robot.commands;

import static org.usfirst.frc.team5961.robot.Robot.cameraController;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class eBCam extends Command {

    public eBCam() {
        // Use requires() here to declare subsystem dependencies
    	requires(cameraController);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	cameraController.ball_cam();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
