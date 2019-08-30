package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp
public class CeciliaTestTeleOp extends LinearOpMode {

    DcMotor motor1;
    DcMotor motor2;

    public void runOpMode() throws InterruptedException {

        waitForStart();

        while (opModeIsActive()) {

            //motor

            motor1 = hardwareMap.dcMotor.get("1");
            motor2 = hardwareMap.dcMotor.get("2");

            motor1.setPower(gamepad1.left_stick_y);
            motor2.setPower(gamepad1.left_stick_y);

            //servo

//            servo = hardwareMap.servo.get("servo");
//
//            continuousServo = hardwareMap.crservo.get("continuousServo");
//
//            servo.setPosition(gamepad1.left_trigger);
//
//            if (gamepad1.left_bumper) {
//                currentPower = -1;
//            } else if (gamepad1.right_bumper) {
//                currentPower = 1;
//            } else if (gamepad1.b) {
//                currentPower = 0;
//            }
//
//            continuousServo.setPower(currentPower);

        }


    }

}
