package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SpindexerSubsystem extends SubsystemBase {

    private final PWMSparkMax spindexer;

    public SpindexerSubsystem() {
        spindexer = new PWMSparkMax(Constants.SpindexerConstants.kSpindexerCANID);
        
    }

    public void slowSpin() {
        spindexer.set(0.25);
    }

    public void intakingSpin() {
        spindexer.set(0.6);
    }

    public void speedySpin() {
        spindexer.set(1.0);
    }
}
