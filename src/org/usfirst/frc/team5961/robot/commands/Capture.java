package org.usfirst.frc.team5961.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import static org.usfirst.frc.team5961.robot.Robot.cameraController;
/**
 *
 */
public class Capture extends Command {

    public Capture() {
        // Use requires() here to declare subsystem dependencies
        requires(cameraController);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	cameraController.grab();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
