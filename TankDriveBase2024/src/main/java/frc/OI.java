package frc;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants;

public class OI {
    XboxController driveController;

    public OI(){
        driveController = new XboxController(Constants.CONTROLLER_PORT);
    }
    public double getLeftYAxis(){
        if (Math.abs(driveController.getLeftY()) > Constants.JOYSTICK_DEADZONE){
            return driveController.getLeftY();
        }else{
            return 0;
        }
    }
    public double getRightYAxis(){
        if (Math.abs(driveController.getRightY()) > Constants.JOYSTICK_DEADZONE){
            return driveController.getRightY();
        }else{
            return 0;
        }
    }
}

