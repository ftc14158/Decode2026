package org.firstinspires.ftc.teamcode.opmodes.myopmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.teamcode.RobotContainer;

@TeleOp(name = "test6")
public abstract class Test6 extends OpMode {

    private RobotContainer robot;

    private DcMotor dcMotor;

    private CRServo crServo;

    private Servo standardServo;

    private TouchSensor touchSensor;


    public void initialize() {
        dcMotor = hardwareMap.get(DcMotor.class, "testMotor");
        crServo = hardwareMap.get(CRServo.class, "crServo");
        standardServo = hardwareMap.get(Servo.class, "standardServo");
        touchSensor = hardwareMap.get(TouchSensor.class, "touchSensor");
        robot = hardwareMap.get(RobotContainer.class, "robot");
    }

    public void loop() {
        if (gamepad1.a) {
            dcMotor.setPower(1);
        }

        if (gamepad1.b) {
            crServo.setPower(1);
        }

        if (gamepad1.right_trigger_pressed) {
            crServo.setPower(1);
        }

        if (gamepad1.left_trigger_pressed) {
            crServo.setPower(-1);
        }

        if (touchSensor.isPressed()) {
            telemetry.addLine("Touch Sensor is pressed");
            dcMotor.setPower(1);
        } else {
            telemetry.addLine("Touch Sensor is no longer pressed");
            dcMotor.setPower(0);
        }

        if (gamepad1.x) {
            telemetry.addLine("Everything has been stopped");
            crServo.setPower(0);
            dcMotor.setPower(0);
        }

        if (gamepad1.y) {
            telemetry.addLine("Y pressed");
        }

        if (gamepad1.dpad_down) {
            dcMotor.setPower(1);
        }

        if (gamepad1.dpad_left) {
            crServo.setPower(1);
        }

        if (gamepad1.dpad_right) {
            dcMotor.setPower(1);
        }


        if (gamepad1.dpad_up) {
            telemetry.addLine("Dpad up is pressed");
            dcMotor.setPower(1);
        }

        if (gamepad1.right_trigger_pressed) {
            robot.getGamepad1();
        }

        while (gamepad1.startWasPressed()) {
            dcMotor.setPower(0);
            crServo.setPower(0);
            standardServo.setPosition(-1);
            telemetry.addLine("Everything but the Servo has been stopped because it can't");
        }
    }
}