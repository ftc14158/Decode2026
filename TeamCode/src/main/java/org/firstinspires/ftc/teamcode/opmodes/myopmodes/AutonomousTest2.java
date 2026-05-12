package org.firstinspires.ftc.teamcode.opmodes.myopmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "AutonomousTest2")
    public abstract class AutonomousTest2 extends LinearOpMode {

    private DcMotor left;

    private DcMotor right;

    @Override
    public void runOpMode(){
        telemetry.addData("Start", 1);
        telemetry.update();
        left = hardwareMap.get(DcMotor.class, "leftMotor");
        right = hardwareMap.get(DcMotor.class, "rightMotor");
        waitForStart();

        right.setPower(1);
        left.setPower(1);

        sleep(2000);

        right.setPower(0);
        left.setPower(0);
    }
}