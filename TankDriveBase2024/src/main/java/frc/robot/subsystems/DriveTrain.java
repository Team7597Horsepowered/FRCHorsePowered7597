package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase{
    private WPI_VictorSPX victorLeft2, victorRight2;
    private WPI_VictorSPX victorLeft1, victorRight1;

    public DriveTrain(){
        victorLeft1 = new WPI_VictorSPX(Constants.MOTOR_PORTS_LEFT[0]);
        victorRight1 = new WPI_VictorSPX(Constants.MOTOR_PORTS_RIGHT[0]);
        victorLeft2 = new WPI_VictorSPX(Constants.MOTOR_PORTS_LEFT[1]);
        victorRight2 = new WPI_VictorSPX(Constants.MOTOR_PORTS_RIGHT[1]);

        victorLeft1.configFactoryDefault();
        victorLeft1.setInverted(true);

        victorRight1.configFactoryDefault();
        victorRight1.setInverted(false);

        victorLeft2.configFactoryDefault();
        victorLeft2.setInverted(true);
        victorLeft2.follow(victorLeft1);

        victorRight2.configFactoryDefault();
        victorRight2.setInverted(false);
        victorRight2.follow(victorRight1);

    }
    
    public void setBothMotors(double speedLeft, double speedRight){
    setLeftMotors(speedLeft);
    setRightMotors(speedRight);
    }

    public void setLeftMotors(double speed){
        victorLeft1.set(ControlMode.PercentOutput, speed);
    }

    public void setRightMotors(double speed){
        victorRight1.set(ControlMode.PercentOutput, speed);
    }
    public void setBothMotors(double speed){
        setLeftMotors(speed);
        setRightMotors(speed);
    }
}