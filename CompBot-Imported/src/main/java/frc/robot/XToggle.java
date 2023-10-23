package frc.robot;
import edu.wpi.first.wpilibj.*;

public class XToggle {
    public boolean xtoggleOn;
    public boolean xtogglePressed;
    public boolean xtoggleHeld;

    public XToggle()
    {
        xtoggleOn = false;
        xtogglePressed = false;
    }
    // Allows a toggle button to be used:
    public boolean xtogglePressed(XboxController _control, int button) {
        // Checks if the button was pressed:
        if (_control.getRawButtonPressed(button)) {
            // Checks if the button was off before being pressed:
            if (!xtogglePressed) {
                // Sets toggleOn to be the opposite of its previous value:
                xtoggleOn = !xtoggleOn; 
                xtogglePressed = true;
            }
        } else {
            xtogglePressed = false; 
        }
        return xtoggleOn;
    } 
// Allows a "toggle button" to be held:
public boolean xtoggleHeld(XboxController _control, int button)
{
    if (_control.getRawButton(button)) {
        if (!xtogglePressed){
            xtoggleOn = !xtoggleOn;
            xtogglePressed = true;
        }
    } else {
        xtogglePressed = false;
    }
    return xtogglePressed;
}
}
