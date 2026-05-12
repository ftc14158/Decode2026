package org.firstinspires.ftc.teamcode.opmodes.myopmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;

@TeleOp()
public class Test7 extends OpMode {

    private DcMotor dcMotor;

    private Servo servo;

    private CRServo crServo;

    @Override
    public void init() {
        dcMotor = hardwareMap.get(DcMotor.class, "dcMotor");
        servo = hardwareMap.get(Servo.class, "servo");
        crServo = hardwareMap.get(CRServo.class, "crServo");
    }

    @Override
    public void loop() {
        if (gamepad1.startWasPressed()) {
            dcMotor.setPower(1);
            servo.setPosition(1);
            crServo.setPower(1);
        }
    }

    public void start() {
        telemetry.addLine("Starting");
    }

    public void stop() {
        telemetry.addLine("Stopped");
    }
}