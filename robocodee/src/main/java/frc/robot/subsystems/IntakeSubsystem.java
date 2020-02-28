package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.PWMSparkMax;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class IntakeSubsystem extends SubsystemBase {

    private final Solenoid extensionPiston;
    private final PWMSparkMax spinnyMotor;

    public IntakeSubsystem() {
        extensionPiston = new Solenoid(IntakeConstants.kExtensionSolenoidPort);

        spinnyMotor = new PWMSparkMax(IntakeConstants.kGrabbyMotorCANID);
        
    }

    public void startIntaking() {
        extensionPiston.set(true);
        spinnyMotor.set(-0.75);
    }

    public void stopIntaking() {
        extensionPiston.set(false);
        spinnyMotor.set(0);
    }
}
