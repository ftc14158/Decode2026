package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.seattlesolvers.solverslib.command.SubsystemBase;

import org.firstinspires.ftc.teamcode.RobotContainer;
import org.firstinspires.ftc.teamcode.subsystems.mechanism.ShooterConstants;
import org.firstinspires.ftc.teamcode.subsystems.mechanism.ShooterConstants.FlywheelSpeed;

public class ShooterSubsystem extends SubsystemBase {

    private RobotContainer robot;
    private DcMotor flywheel;
    private DcMotor coreHex;
    private CRServo servo;
    private static final int bankVelocity = 1300;
    private static final int farVelocity = 1900;
    private static final int maxVelocity = 2200;
    private ElapsedTime autoDriveTimer = new ElapsedTime();

    public ShooterSubsystem(HardwareMap hardwareMap, RobotContainer robot) {

        this.robot = robot;
        flywheel = hardwareMap.get(DcMotor.class, "flywheel");
        coreHex = hardwareMap.get(DcMotor.class, "coreHex");
        servo = hardwareMap.get(CRServo.class, "servo");

        // Establishing the direction and mode for the motors
        flywheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        flywheel.setDirection(DcMotor.Direction.REVERSE);

        coreHex.setDirection(DcMotor.Direction.REVERSE);
        //Ensures the servo is active and ready
        servo.setPower(0);

    }

    /**
     * Manual control for the Core Hex powered feeder and the agitator servo in the hopper
     */

    // servo = hopper agitator
    public void setHopperPower(double power) {
        servo.setPower(power);
    }

    public void setIntakePower(double power) {
        coreHex.setPower(power);
    }


    /**
     * This if/else statement contains the controls for the flywheel, both manual and auto.
     * Circle and Square will spin up ONLY the flywheel to the target velocity set.
     * The bumpers will activate the flywheel, Core Hex feeder, and servo to cycle a series of balls.
     */
    public void setFlywheelVelocity(FlywheelSpeed sp) {
        switch(sp) {
            case SPEED_BANK:
                flywheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                ((DcMotorEx) flywheel).setVelocity(ShooterConstants.SPEED_BANK);
                break;
            case SPEED_FAR:
                flywheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                ((DcMotorEx) flywheel).setVelocity(ShooterConstants.SPEED_FAR);
            case SPEED_MAX:
                flywheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                ((DcMotorEx) flywheel).setPower(1);

            default:
                ((DcMotorEx) flywheel).setVelocity(0);
                coreHex.setPower(0);
                servo.setPower(0);
            }
        }
    }

