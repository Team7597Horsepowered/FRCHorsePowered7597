/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import edu.wpi.first.wpilibj.*;

// Do not edit anything above this line:

// Creates "toggle" functionality that can be called and edited in Robot.java:
public class Toggle {
    // Gives true/false statements for use in Toggle:
    public boolean toggleOn;
    public boolean togglePressed;
    public boolean toggleHeld; 
    // Sets the default values for toggles as false:
    public Toggle()
    {
        toggleOn = false;
        togglePressed = false;
    }
    // Allows a toggle button to be used:
    public boolean togglePressed(Joystick _stick, int button) {
        // Checks if the button was pressed:
        if (_stick.getRawButtonPressed(button)) {
            // Checks if the button was off before being pressed:
            if (!togglePressed) {
                // Sets toggleOn to be the opposite of its previous value:
                toggleOn = !toggleOn; 
                togglePressed = true;
            }
        } else {
            togglePressed = false; 
        }
        return toggleOn;
    } 
// Allows a "toggle button" to be held:
public boolean toggleHeld(Joystick _stick, int button)
{
    if (_stick.getRawButton(button)) {
        if (!togglePressed){
            toggleOn = !toggleOn;
            togglePressed = true;
        }
    } else {
        togglePressed = false;
    }
    return togglePressed;
}
} // Question from Dylan: If it's a held button, why not use some sort of 'while' loop? Or am I missing something about this button...:
