package org.firstinspires.ftc.teamcode.subsystems.mechanism;

import com.acmerobotics.dashboard.config.Config;

@Config
public class ShooterConstants {
    public enum FlywheelSpeed {
        SPEED_MANUAL,
        SPEED_BANK,
        SPEED_FAR,
        SPEED_MAX,
        OFF };

    public static double K_P = 110.0; // 10.0;
    public static double K_I = 0;
    public static double K_D = 5.0; // 0.0;
    public static double K_F = 12.0; // 20.0;

    public static double SPEED_BANK = 1300;
    public static double SPEED_FAR = 1400;

    public static final double INTAKE_POWER_FORWARD = 0.5;
    public static final double INTAKE_POWER_REVERSE = -0.5;

    public static final double HOPPER_FORWARD = 1;
    public static final double HOPPER_REVERSE = -1;

}
