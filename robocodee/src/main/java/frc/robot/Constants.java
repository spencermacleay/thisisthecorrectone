package frc.robot;

import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;

public class Constants {
    public static class DrivetrainConstants {
        public static final int kLeftMasterCANID = 1;
        public static final int kLeftSlaveCANID = 3;
        public static final int kRightMasterCANID = 5;
        public static final int kRightSlaveCANID = 4;
    }
        public static final int RightJoystickY = 5;
        public static final int LeftJoystickY = 1;
    public static class IntakeConstants {
        public static final int kExtensionSolenoidPort = 0;
        public static final int kGrabbyMotorCANID = 0;
    }

    public static class SpindexerConstants {
        public static final int kSpindexerCANID = 7;
    }

    public static class ShooterConstants {
        public static final int kIndexerCANID = 2;
        public static final int kShooterMasterCANID = 1;
        public static final int kShooterSlave1CANID = 2;
        public static final int kShooterSlave2CANID = 3;
        public static final int kShooterSlave3CANID = 4;

        // you MUST run frc-characterization to get these values
        // you CANNOT guess or trial-and-error them!
        private static final double kS = 0.0; // CHANGE ME!
        private static final double kV = 0.0; // CHANGE ME!
        private static final double kA = 0.0; // CHANGE ME!

        public static final SimpleMotorFeedforward shooterFeedforward = new SimpleMotorFeedforward(kS, kV, kA);

        public static final double kP = 0.05;
    }

    //public static class WoFConstants {
       // public static final int kExtensionPistonPort = 1;
       // public static final int kWheelyMotorCANID = 8;
   // }

    //public static class ClimberConstants {
        //public static final int kWinchyMotorCANID = 9;
    //}
}