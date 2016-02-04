package org.usfirst.frc.team5961.robot.subsystems;

import org.usfirst.frc.team5961.robot.commands.Capture;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CameraController extends Subsystem {
    

    int currSession;
    int sessionfront;
    int sessionback;
    Image frame;
    CameraServer server;
	
	public CameraController(String cam0,String cam1) {
		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
    	sessionfront = NIVision.IMAQdxOpenCamera("cam0", NIVision.IMAQdxCameraControlMode.CameraControlModeController);
    	sessionback = NIVision.IMAQdxOpenCamera("cam1", NIVision.IMAQdxCameraControlMode.CameraControlModeController);
    	currSession = sessionfront;
    	NIVision.IMAQdxConfigureGrab(currSession);
    }
	public void forward(){
		NIVision.IMAQdxStopAcquisition(currSession);
	    currSession = sessionfront;
        NIVision.IMAQdxConfigureGrab(currSession);
	}
	public void back(){
		NIVision.IMAQdxStopAcquisition(currSession);
	    currSession = sessionback;
        NIVision.IMAQdxConfigureGrab(currSession);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new Capture());
    }
    public void grab(){
    	NIVision.IMAQdxGrab(currSession, frame, 1);
    	CameraServer.getInstance().setImage(frame);
    }
}

