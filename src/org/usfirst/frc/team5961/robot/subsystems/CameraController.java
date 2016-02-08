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
    int sessionball;
    Image frame;
    Image frameEffects;
    CameraServer server;
	
	public CameraController(String cam0,String cam1) {
		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
    	sessionfront = NIVision.IMAQdxOpenCamera("cam1", NIVision.IMAQdxCameraControlMode.CameraControlModeController);
    	sessionball = NIVision.IMAQdxOpenCamera("cam0", NIVision.IMAQdxCameraControlMode.CameraControlModeController);
    	currSession = sessionfront;
    	NIVision.IMAQdxConfigureGrab(currSession);
    }
	public void forward(){
		NIVision.IMAQdxStopAcquisition(currSession);
	    currSession = sessionfront;
        NIVision.IMAQdxConfigureGrab(currSession);
	}
	public void ball_cam(){
		NIVision.IMAQdxStopAcquisition(currSession);
	    currSession = sessionball;
        NIVision.IMAQdxConfigureGrab(currSession);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new Capture());
    }
    public void grab(){
    	NIVision.IMAQdxGrab(currSession, frame, 1); // save picture in frame
    	if(currSession==sessionball){ // if ball camera
    		NIVision.imaqFlip(frameEffects, frame, NIVision.FlipAxis.CENTER_AXIS); // הופך את התמונה בשני הצירים
    		//מסרטט
    	}else{
    		frameEffects = drawPrespectiveAimLinesOnFrontCam(frame);
    	}
    	CameraServer.getInstance().setImage(frameEffects); // show final image
    }
    
    public Image drawPrespectiveAimLinesOnFrontCam(Image frame){
    	NIVision.imaqDrawLineOnImage(frameEffects, frame, NIVision.DrawMode.PAINT_VALUE, new NIVision.Point(1,1), new NIVision.Point(100,100), 1);
    	return frameEffects;
    }
}

