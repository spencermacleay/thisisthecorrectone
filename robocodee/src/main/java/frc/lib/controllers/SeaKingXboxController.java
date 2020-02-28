package frc.lib.controllers;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class SeaKingXboxController extends XboxController {
    /**
     * Construct an instance of a joystick. The joystick index is the USB port on the drivers
     * station.
     *
     * @param port The port on the Driver Station that the joystick is plugged into.
     */
    public SeaKingXboxController(int port) {
        super(port);
    }

    /**
     * Represents a digital button on an XboxController.
     */
    private enum Button {
        kBumperLeft(5),
        kBumperRight(6),
        kStickLeft(9),
        kStickRight(10),
        kA(1),
        kB(2),
        kX(3),
        kY(4),
        kBack(7),
        kStart(8);

        public final int value;

        Button(int value) {
            this.value = value;
        }
    }

    public final POV pov = new POV(this);

    public final JoystickButton leftBumper = new JoystickButton(this, Button.kBumperLeft.value);
    public final JoystickButton rightBumper = new JoystickButton(this, Button.kBumperRight.value);
    public final JoystickButton leftStickPress = new JoystickButton(this, Button.kStickLeft.value);
    public final JoystickButton rightStickPress = new JoystickButton(this, Button.kStickRight.value);
    public final JoystickButton aButton = new JoystickButton(this, Button.kA.value);
    public final JoystickButton bButton = new JoystickButton(this, Button.kB.value);
    public final JoystickButton xButton = new JoystickButton(this, Button.kX.value);
    public final JoystickButton yButton = new JoystickButton(this, Button.kY.value);
    public final JoystickButton backButton = new JoystickButton(this, Button.kBack.value);
    public final JoystickButton startButton = new JoystickButton(this, Button.kStart.value);
}
