package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.controller.PIDFController;
import com.seattlesolvers.solverslib.hardware.motors.MotorEx;

import org.firstinspires.ftc.teamcode.RobotContainer;
import org.firstinspires.ftc.teamcode.subsystems.mechanism.ShooterConstants;
import org.firstinspires.ftc.teamcode.subsystems.mechanism.ShooterConstants.FlywheelSpeed;

public class ShooterSubsystem extends SubsystemBase {

    private RobotContainer robot;
    private MotorEx flywheel;
    private MotorEx coreHex;
    private CRServo servo;

    private PIDFController pidController;
    private double targetVelocity = 0.0;
    private double intakePower = 0.0;
    private double hopperPower = 0.0;

    public ShooterSubsystem(HardwareMap hardwareMap, RobotContainer robot) {
        this.robot = robot;

        flywheel = new MotorEx(hardwareMap, "flywheel");
        coreHex = new MotorEx(hardwareMap, "coreHex");
        servo = hardwareMap.get(CRServo.class, "servo");

        flywheel.setInverted(true);
        flywheel.setRunMode(MotorEx.RunMode.RawPower);

        coreHex.setInverted(true);
        coreHex.setRunMode(MotorEx.RunMode.RawPower);

        servo.setPower(0);

        pidController = new PIDFController(
                ShooterConstants.FLYWHEEL_KP,
                ShooterConstants.FLYWHEEL_KI,
                ShooterConstants.FLYWHEEL_KD,
                ShooterConstants.FLYWHEEL_KF
        );
    }

    public void setHopperPower(double power) {
        this.hopperPower = power;
    }

    public void setIntakePower(double power) {
        this.intakePower = power;
    }

    public void setFlywheelVelocity(FlywheelSpeed sp) {
        switch(sp) {
            case SPEED_BANK:
                targetVelocity = ShooterConstants.SPEED_BANK;
                break;
            case SPEED_FAR:
                targetVelocity = ShooterConstants.SPEED_FAR;
                break;
            case SPEED_MAX:
                targetVelocity = 2200;
                break;
            case OFF:
            default:
                targetVelocity = 0;
                break;
        }
    }

    public boolean atTargetVelocity() {
        if (targetVelocity == 0) return true;
        return Math.abs(flywheel.getVelocity() - targetVelocity) < ShooterConstants.FLYWHEEL_TOLERANCE;
    }

    @Override
    public void periodic() {
        // 1. Calculate Flywheel PID
        if (targetVelocity == 0) {
            flywheel.set(0);
        } else {
            double power = pidController.calculate(flywheel.getVelocity(), targetVelocity);
            flywheel.set(power);
        }
        
        // 2. Continuously apply intake & hopper states (solves the power loss issue)
        coreHex.set(intakePower);
        servo.setPower(hopperPower);
    }
}
