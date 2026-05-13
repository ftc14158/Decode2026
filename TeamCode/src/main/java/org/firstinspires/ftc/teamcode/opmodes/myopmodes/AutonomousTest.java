package org.firstinspires.ftc.teamcode.opmodes.myopmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.teamcode.RobotContainer;

@Autonomous(name = "AutonomousTest")
public class AutonomousTest extends LinearOpMode {

    private RobotContainer robot;

    private DcMotor dcMotor;

    private DcMotor leftFront;

    private DcMotor leftRear;


    private DcMotor rightRear;

    private DcMotor rightFront;

    private CRServo crServo;

    public void runOpMode() {
       dcMotor = hardwareMap.get(DcMotor.class, "dcMotor");
       robot = hardwareMap.get(RobotContainer.class, "robot");
       crServo = hardwareMap.get(CRServo.class, "crServo");
       leftFront = hardwareMap.get(DcMotor.class, "leftFront");
       leftRear = hardwareMap.get(DcMotor.class, "leftRear");
       rightRear = hardwareMap.get(DcMotor.class, "rightRear");
       rightFront = hardwareMap.get(DcMotor.class, "rightFront");
       waitForStart();

       crServo.setPower(1);
       dcMotor.setPower(1);

       sleep(3000);

       crServo.setPower(0);
       dcMotor.setPower(0);
    }
}