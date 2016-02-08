package org.usfirst.frc.team5961.robot.commands;

import static org.usfirst.frc.team5961.robot.Robot.ballEater;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StopAndHoldEater extends Command {

    public StopAndHoldEater() {
            // Use requires() here to declare subsystem dependencies
            requires(ballEater);
        }

        // Called just before this Command runs the first time
        protected void initialize() {
        	
        }

        // Called repeatedly when this Command is scheduled to run
        protected void execute() {
        	if(ballEater.haveBall()){
        		ballEater.hold();
        	}else{
        		ballEater.stop();
        	}
        }

        // Make this return true when this Command no longer needs to run execute()
        protected boolean isFinished() {
            return false;
        }
        protected void end() {
        	ballEater.stop();
        }

        // Called when another command which requires one or more of the same
        // subsystems is scheduled to run
        protected void interrupted() {
        	end();
        }
}
