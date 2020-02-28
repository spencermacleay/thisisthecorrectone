package frc.lib.controllers;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.button.Button;

import static edu.wpi.first.wpilibj.util.ErrorMessages.requireNonNullParam;

public class AxisButton extends Button {
    private final GenericHID m_joystick;
    private final int m_axisNumber;

    /**
     * Creates a joystick button for triggering commands.
     *
     * @param joystick     The GenericHID object that has the button (e.g. Joystick, KinectStick,
     *                     etc)
     * @param axisNumber The axis number (see {@link GenericHID#getRawAxis(int) }
     */
    public AxisButton(GenericHID joystick, int axisNumber) {
        requireNonNullParam(joystick, "joystick", "JoystickButton");

        m_joystick = joystick;
        m_axisNumber = axisNumber;
    }

    /**
     * Gets the value of the axis button.
     *
     * @return The value of the axis button
     */
    @Override
    public boolean get() {
        return Math.abs(m_joystick.getRawAxis(m_axisNumber)) > 0.5;
    }
}