package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.ShooterConstants;

public class ShooterSubsystem extends SubsystemBase {

    private final CANSparkMax indexer;
    private final TalonSRX shooterMaster;
    private final TalonSRX shooterSlave1;
    private final TalonSRX shooterSlave2;
    private final TalonSRX shooterSlave3;

    private final PIDController shooterPID;

    private int desiredRPM;

    public ShooterSubsystem() {
        indexer = new CANSparkMax(ShooterConstants.kIndexerCANID, MotorType.kBrushless);
        indexer.restoreFactoryDefaults();
        indexer.setIdleMode(IdleMode.kCoast);
        indexer.setSmartCurrentLimit(40);

        shooterMaster = new TalonSRX(ShooterConstants.kShooterMasterCANID);
        shooterSlave1 = new TalonSRX(ShooterConstants.kShooterSlave1CANID);
        shooterSlave2 = new TalonSRX(ShooterConstants.kShooterSlave2CANID);
        shooterSlave3 = new TalonSRX(ShooterConstants.kShooterSlave3CANID);

        shooterMaster.configFactoryDefault();
        shooterSlave1.configFactoryDefault();
        shooterSlave2.configFactoryDefault();
        shooterSlave3.configFactoryDefault();

        shooterMaster.configPeakCurrentLimit(60);
        shooterMaster.configPeakCurrentDuration(250);

        // DO NOT CHANGE THIS!
        // a flywheel spinning at any speed will NOT be happy being forced to suddenly stop
        shooterMaster.setNeutralMode(NeutralMode.Coast);
        shooterSlave1.setNeutralMode(NeutralMode.Coast);
        shooterSlave2.setNeutralMode(NeutralMode.Coast);
        shooterSlave3.setNeutralMode(NeutralMode.Coast);

        shooterMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);

        shooterSlave1.follow(shooterMaster);
        shooterSlave2.follow(shooterMaster);
        shooterSlave3.follow(shooterMaster);

        // no I or D for velocity loops
        shooterPID = new PIDController(ShooterConstants.kP, 0, 0);
    }

    private double getShooterActualRPM() {
        // divide by 4096 to get rotations/100ms
        // multiply by 10 to get rotations/second
        // multiply by 60 to get rotations/minute
        double encoderRPM = (shooterMaster.getSelectedSensorVelocity() / 4096.0) * 10 * 60;

        // change this to a ratio if you have one between the encoder and the wheel
        double wheelRPM = encoderRPM * 1;

        return wheelRPM;
    }

    private double calculateOutput(int desiredRPM) {
        double pidOutput = shooterPID.calculate(getShooterActualRPM());
        double feedforward = ShooterConstants.shooterFeedforward.calculate(desiredRPM);

        return pidOutput + feedforward;
    }

    public void setRPM(int desiredRPM) {
        this.desiredRPM = desiredRPM;
        double shooterPower = calculateOutput(desiredRPM);
        shooterMaster.set(ControlMode.PercentOutput, shooterPower);
    }

    public void autoShoot() {
        boolean shooterRPMCloseEnough = Math.abs(getShooterActualRPM() - desiredRPM) < 100;
        if (shooterRPMCloseEnough) {
            indexer.set(1);
        } else {
            indexer.set(0);
        }
    }
}

