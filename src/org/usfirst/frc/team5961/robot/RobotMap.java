package org.usfirst.frc.team5961.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	public static final int leftVictor1 = 0;
	public static final int leftVictor2 = 1;
	public static final int rightVictor1 = 2;
	public static final int rightVictor2 = 3;
	
	public static final int ballVictor = 9;
	
	public static final int limitPort = 0;
	
	public static final double maxSpeed = 0.5;
	public static final double eatSpeed = 0.45;
	public static final double throwSpeed = 0.5;
	public static final double holdSpeed = 0.2;
}
