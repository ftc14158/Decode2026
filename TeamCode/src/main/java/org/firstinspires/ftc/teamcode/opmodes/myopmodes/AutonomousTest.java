package org.firstinspires.ftc.teamcode.opmodes.myopmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.teamcode.RobotContainer;

@Autonomous(name = "AutonomousTest")
public class AutonomousTest extends OpMode {

    private DcMotor dcMotor;

    private RobotContainer robot;

    private DcMotor leftFront;

    private DcMotor leftRear;


    private DcMotor rightRear;

    private DcMotor rightFront;

    private CRServo crServo;

    public void init() {
       dcMotor = hardwareMap.get(DcMotor.class, "dcMotor");
       robot = hardwareMap.get(RobotContainer.class, "robot");
       crServo = hardwareMap.get(CRServo.class, "crServo");
       leftFront = hardwareMap.get(DcMotor.class, "leftFront");
       leftRear = hardwareMap.get(DcMotor.class, "leftRear");
       rightRear = hardwareMap.get(DcMotor.class, "rightRear");
       rightFront = hardwareMap.get(DcMotor.class, "rightFront");
    }

    public void loop() {
        if (gamepad1.a) {
            dcMotor.setPower(1);
            crServo.setPower(1);
        }
    }
}
