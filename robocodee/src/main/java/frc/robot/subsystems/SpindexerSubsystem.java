package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SpindexerSubsystem extends SubsystemBase {

    private final VictorSPX spindexer;

    public SpindexerSubsystem() {
        spindexer = new VictorSPX(Constants.SpindexerConstants.kSpindexerCANID);
        spindexer.configFactoryDefault();
        spindexer.setNeutralMode(NeutralMode.Coast);
    }

    public void slowSpin() {
        spindexer.set(ControlMode.PercentOutput, -0.25);
    }

    public void intakingSpin() {
        spindexer.set(ControlMode.PercentOutput, -0.6);
    }

    public void speedySpin() {
        spindexer.set(ControlMode.PercentOutput, -1.0);
    }
}
