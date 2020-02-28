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

import edu.wpi.first.wpilibj.PWMSparkMax;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.ShooterConstants;

public class ShooterSubsystem extends SubsystemBase {

    private final PWMSparkMax indexer;
    private final TalonSRX shooterMaster;
    private final TalonSRX shooterSlave1;
    private final TalonSRX shooterSlave2;
    private final TalonSRX shooterSlave3;

    // No Longer Needed
    

    // No Longer Needed
    private int desiredRPM;

    public ShooterSubsystem() {
        indexer = new PWMSparkMax(ShooterConstants.kIndexerID);
        
        

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
    }
        public void setShooterMotors(double speed) {
    
            shooterMaster.set(ControlMode.PercentOutput, speed);
            shooterSlave1.set(ControlMode.PercentOutput, speed);
            shooterSlave2.set(ControlMode.PercentOutput, speed);
            shooterSlave3.set(ControlMode.PercentOutput, speed);
          }

          public void setIndexerMotor(double speed){
            indexer.set(speed);


          }

        }

	



