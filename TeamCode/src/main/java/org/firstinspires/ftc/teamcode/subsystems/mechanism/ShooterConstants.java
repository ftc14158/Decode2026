package org.firstinspires.ftc.teamcode.subsystems.mechanism;

import com.acmerobotics.dashboard.config.Config;

@Config
public class ShooterConstants {
    public enum FlywheelSpeed {
        SPEED_MANUAL,
        SPEED_BANK,
        SPEED_FAR,
        SPEED_MAX,
        OFF
    }

    public static final double SPEED_BANK = 1300;
    public static final double SPEED_FAR = 1900;

    public static final double INTAKE_POWER_FORWARD = 0.5;
    public static final double INTAKE_POWER_REVERSE = -0.5;

    public static final double HOPPER_FORWARD = 1;
    public static final double HOPPER_REVERSE = -1;

    // Flywheel PID Constants
    public static double FLYWHEEL_KP = 0.005;
    public static double FLYWHEEL_KI = 0.0;
    public static double FLYWHEEL_KD = 0.0001;
    public static double FLYWHEEL_KF = 0.0005;
    public static double FLYWHEEL_TOLERANCE = 50.0;
}