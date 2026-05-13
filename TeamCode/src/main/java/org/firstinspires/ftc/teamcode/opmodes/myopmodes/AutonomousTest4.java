package org.firstinspires.ftc.teamcode.opmodes.myopmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.teamcode.RobotContainer;

@Autonomous(name = "AutonomousTest4")
    public class AutonomousTest4 extends LinearOpMode {

    private RobotContainer robot;

    private DcMotor rightRear;

    private DcMotor leftFront;

    private DcMotor rightFront;

    private DcMotor leftRear;

    @Override
    public void runOpMode(){
        telemetry.addData("Start", 2);
        telemetry.update();
        robot = hardwareMap.get(RobotContainer.class, "robot");
        rightRear = hardwareMap.get(DcMotor.class, "BackMotor");
        leftFront = hardwareMap.get(DcMotor.class, "FrontMotor");
        leftRear = hardwareMap.get(DcMotor.class, "leftRear");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        waitForStart();

        rightFront.setPower(1);
        leftFront.setPower(1);
        rightRear.setPower(1);
        leftRear.setPower(1);

        sleep(3000);

        rightFront.setPower(0);
        leftFront.setPower(0);
        }
    }