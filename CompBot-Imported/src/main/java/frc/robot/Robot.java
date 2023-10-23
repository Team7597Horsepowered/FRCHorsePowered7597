// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value;
//Control
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/*
  This is a demo program showing the use of the DifferentialDrive class. Runs the motors with
  arcade steering.
 */

public class Robot extends TimedRobot {
//These are your declarations. 
//Declarations start with public or private. Public if you change the declaration further in the code. Private if you  don't want it changed
//Then you follow up with what it is
//Then the name of the declaration
//Then what it equals. (Ex: = 9; or = new WPI_TalonSRX(3);)

//Claw 
  private WPI_TalonSRX elevatorMotor = new WPI_TalonSRX(3);
  private WPI_VictorSPX clawTop = new WPI_VictorSPX(7);
  private WPI_VictorSPX clawBottom = new WPI_VictorSPX(8);
  private WPI_VictorSPX rotate = new WPI_VictorSPX(6);
  /* NOTE:
  number in WPI_VictorSPX() differs depending on which engine:
  Use (PHEONIX TUNER -> CAN Devices -> Blink) per number to determine where it is located: */
  //Motorcontrollers
  private WPI_VictorSPX frontLeftMotor = new WPI_VictorSPX(1);
  private WPI_VictorSPX frontRightMotor = new WPI_VictorSPX(5);
  private WPI_VictorSPX backLeftMotor = new WPI_VictorSPX(2);
  private WPI_VictorSPX backRightMotor = new WPI_VictorSPX(4);
  
// Differential Drive is the actual drive. When declaring pass in the fron two motors of drive train.
  private DifferentialDrive _drive = new DifferentialDrive(frontRightMotor, frontLeftMotor);
  private Joystick JoyStick1 = new Joystick(0);
  private XboxController _control = new XboxController(1);
  private PS4Controller p4_Controller = new PS4Controller(2);
 
  //Pneumatics
  //change channels based on layout
  private final DoubleSolenoid solenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0,1);
  private final Solenoid exampleSolenoidPCM = new Solenoid(PneumaticsModuleType.CTREPCM, 2);
  private final Compressor compressor = new Compressor(PneumaticsModuleType.CTREPCM);
 

  // Toggles are from the Toggle.Java class. Toggle is the button. 
  private Toggle _elevatorToggle = new Toggle();
  private XToggle _xelevatorToggle = new XToggle();

  private Toggle _rotateToggle = new Toggle();
  private XToggle _xrotateToggle = new XToggle();

  private Toggle _clawToggle = new Toggle();
  private XToggle _xclawToggle = new XToggle();
  private Toggle _clawRevToggle = new Toggle();
  private XToggle _xclawRevToggle = new XToggle();

  int driveTimer = 0;
  int elevTimer = 0;
  int rotateTimer = 0;
  int clawTimer = 0;
  boolean runAutonomous = true;
  boolean isEnabled = false;
  boolean toggle = false;

  // Assuming this is used as a timer for the autonomous period:

  @Override
  public void robotInit() {
    CameraServer.startAutomaticCapture();
    // ^^You Need This for the camera input off of the RoboRio you will also need the associated import
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
    frontRightMotor.setInverted(true);
    backRightMotor.setInverted(true);

    backLeftMotor.follow(frontLeftMotor);
    backRightMotor.follow(frontRightMotor);
    clawTop.follow(clawBottom);

    driveTimer = 0;
    elevTimer = 0;
    rotateTimer = 0;
    clawTimer = 0;
    
  }
  

  @Override
  public void autonomousPeriodic() {
/*
    while (rotateTimer <= 450) {
      rotate.set(ControlMode.PercentOutput, 0.5);
      rotateTimer = rotateTimer + 1;
      try {
        Thread.sleep(1);
        } catch (InterruptedException e) {
          e.printStackTrace();
    }}
    rotate.set(ControlMode.PercentOutput, 0);

    try {
      Thread.sleep(300);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    
    while (clawTimer <= 200) {
      clawBottom.set(ControlMode.PercentOutput, -0.95);
      clawTimer = clawTimer + 1;
      try {
        Thread.sleep(1);
        } catch (InterruptedException e) {
          e.printStackTrace();
    }}
    clawBottom.set(ControlMode.PercentOutput, 0);

    try {
        Thread.sleep(400);
      } catch (InterruptedException e) {
        e.printStackTrace();
    }
*/
    while(driveTimer <= 20000) {
      while(driveTimer <= 9000) {
        _drive.arcadeDrive(0.4,0);
        driveTimer = driveTimer + 1;
      }
      while(driveTimer >= 9000 && driveTimer <=15000 ) {
        _drive.arcadeDrive(0.6,1);
        driveTimer = driveTimer + 1;
      }
      while(driveTimer >= 15000 && driveTimer <=20000 ) {
        _drive.arcadeDrive(1,0);
        driveTimer = driveTimer + 1;
      }
    
      try {
        Thread.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
    }}
    _drive.arcadeDrive(0, 0);  
/*
  while(elevTimer <= 6000) {
    elevatorMotor.set(ControlMode.PercentOutput, 1);
    elevTimer = elevTimer + 1;
    if (driveTimer <= 1400) {
      _drive.arcadeDrive(-0.6,0);
      driveTimer = driveTimer + 1;
    } else {
      _drive.arcadeDrive(0, 0);
    }
    if ((elevTimer > 2000) && (rotateTimer <= 900)) {
      rotate.set(ControlMode.PercentOutput, 0.4);
      rotateTimer = rotateTimer + 1;
    } else {
      rotate.set(ControlMode.PercentOutput, 0);
    }
    try {
        Thread.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
    }}
    elevatorMotor.set(ControlMode.PercentOutput, 0);
*/
  }
  
// This is used after the autonomous period ends, then gets input from the controller to drive the vehicle:
  @Override
  public void teleopPeriodic() {
    
    driveTimer = 0;
    elevTimer = 0;
    rotateTimer = 0;
    clawTimer = 0;

    // Drive with arcade drive.
    // That means that the Y axis drives forward
    // and backward, and the X turns left and right.

    // Gets the position of the stick controller:
    _drive.arcadeDrive(-JoyStick1.getY(), JoyStick1.getX());

    //Pneumatics
    //Solonoids to increase air in cylinders/pistons
    if ((JoyStick1.getRawButtonPressed(3)) || (_control.getAButtonPressed())) {
      turnIntakeOn(); // When pressed the intake turns on
      //exampleSolenoidPCM.set(true);
      solenoid.set(DoubleSolenoid.Value.kForward);
   }
   if ((JoyStick1.getRawButtonReleased(3)) || (_control.getAButtonReleased())) {
      turnIntakeOff(); // When released the intake turns off
      //exampleSolenoidPCM.set(false);
      solenoid.set(DoubleSolenoid.Value.kOff);
   }
    //Solonoids to release air from cylinders/pistons
    if ((JoyStick1.getRawButtonPressed(4)) || (_control.getBButtonPressed())){
      turnIntakeOn(); // When released the intake turns off
      //exampleSolenoidPCM.set(false);
      solenoid.set(DoubleSolenoid.Value.kReverse);
    }
    if ((JoyStick1.getRawButtonReleased(4)) || (_control.getBButtonReleased())){
      turnIntakeOff(); // When released the intake turns on
      //exampleSolenoidPCM.set(true);
      solenoid.set(DoubleSolenoid.Value.kOff);
    }
    if ((JoyStick1.getRawButtonPressed(5)) || (_control.getYButtonPressed())){
      turnIntakeOn();
      compressor.isEnabled();
    }
    if (((JoyStick1.getRawButtonReleased(5)) || (_control.getYButtonReleased()))){
      turnIntakeOff();
      compressor.disable();
    }
    if (JoyStick1.getRawButtonPressed(6)){
      if (toggle) {
        retractIntake();
        toggle = false;
        compressor.isEnabled();
      } else {
        deployIntake();
        toggle = true;
        compressor.disable();
      }
    }

    //Elevator Control
    if ((_control.getLeftY() > 0.05) || (_control.getLeftY() < -0.05)){

        elevatorMotor.set(ControlMode.PercentOutput, (-_control.getLeftY() * 2));
    
    } else if ((_xelevatorToggle.xtoggleHeld(_control, 2)) || (_elevatorToggle.toggleHeld(JoyStick1, 5))) { 

        elevatorMotor.set(ControlMode.PercentOutput, 1);

    } else if ((_xelevatorToggle.xtoggleHeld(_control, 1)) || (_elevatorToggle.toggleHeld(JoyStick1, 3))) {

        elevatorMotor.set(ControlMode.PercentOutput, -1);

   } else {

       elevatorMotor.set(ControlMode.PercentOutput, 0);

   }
    
    //Rotate Control
    if ((_control.getRightY() > 0.05) || (_control.getRightY() < -0.05)) {

      rotate.set(ControlMode.PercentOutput, -_control.getRightY() / 2);
    
    } else if ((_rotateToggle.toggleHeld(JoyStick1, 6)) || (_xrotateToggle.xtoggleHeld(_control, 4))) {

      rotate.set(ControlMode.PercentOutput, 1);

    } else if ((_rotateToggle.toggleHeld(JoyStick1, 4)) || (_xrotateToggle.xtoggleHeld(_control, 3))){

      rotate.set(ControlMode.PercentOutput, -0.3);

    } else {

     rotate.set(ControlMode.PercentOutput, 0);

    }

  //Claw Control
  if ((_clawToggle.toggleHeld(JoyStick1, 1)) || (_xclawToggle.xtoggleHeld(_control, 5))) { //Reload

    clawBottom.set(ControlMode.PercentOutput, 0.95);

  } else if ((_clawRevToggle.toggleHeld(JoyStick1, 2))  || (_xclawRevToggle.xtoggleHeld(_control, 6))) { //Shoot

    clawBottom.set(ControlMode.PercentOutput, -0.6);

  } else{

    clawBottom.set(ControlMode.PercentOutput, 0);

}

  }


  private void deployIntake() {
  }


  private void retractIntake() {
  }


  private void turnIntakeOn() {
  }


  private void turnIntakeOff() {
  }
}

