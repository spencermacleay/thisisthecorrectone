package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DrivetrainSubsystem;

import java.util.function.DoubleSupplier;

public class TeleopDriveCommand extends CommandBase {
    private RobotContainer m_robotContainer;
    
    
  public static DrivetrainSubsystem drivetrainSubsystem;
    
    
    
    
    
    
    
    public TeleopDriveCommand(){
   
     addRequirements(drivetrainSubsystem);
      
        
    }

    @Override
    public void execute() {
      double leftStickY= m_robotContainer.GetDriverRawAxis(Constants.leftStickY);
      double rightStickY= m_robotContainer.GetDriverRawAxis(Constants.rightStickY);
     
     
      drivetrainSubsystem.setLeftMotors(leftStickY);
      drivetrainSubsystem.setRightMotors(rightStickY);
    }

    @Override
    public void end(boolean interrupted) {
        
    }
}
