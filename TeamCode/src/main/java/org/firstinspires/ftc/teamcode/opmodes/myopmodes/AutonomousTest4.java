package org.firstinspires.ftc.teamcode.opmodes.myopmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "AutonomousTest4")
    public abstract class AutonomousTest4 extends LinearOpMode {

    private DcMotor back;

    private DcMotor front;

    @Override
    public void runOpMode(){
        telemetry.addData("Start", 2);
        telemetry.update();
        back = hardwareMap.get(DcMotor.class, "BackMotor");
        front = hardwareMap.get(DcMotor.class, "FrontMotor");
        waitForStart();

        back.setPower(1);
        front.setPower(1);

        sleep(3000);

        back.setPower(0);
        front.setPower(0);
    }
}