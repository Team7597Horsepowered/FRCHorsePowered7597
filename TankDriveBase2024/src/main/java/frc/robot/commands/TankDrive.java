package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class TankDrive extends CommandBase {
    public TankDrive(){
        addRequirements(Robot.m_DriveTrain);
    }

    @Override
    public void initialize(){
        Robot.m_DriveTrain.setBothMotors(0);
    }

    @Override
    public void execute(){
        Robot.m_DriveTrain.setBothMotors(RobotContainer.m_OI.getLeftYAxis(), RobotContainer.m_OI.getRightYAxis());
    }
    @Override
    public void end(boolean interrupted) {
        Robot.m_DriveTrain.setBothMotors(0);
    } 

    @Override
    public boolean isFinished() {
        return false;
    }
}

