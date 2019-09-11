package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import java.lang.Math;


@TeleOp
public class GTEST2 extends LinearOpMode {
    DcMotor motor1, motor2;
    Servo servoTest;

    public void runOpMode() throws InterruptedException {

        motor1 = hardwareMap.dcMotor.get("motor1");
        motor2 = hardwareMap.dcMotor.get("motor2");
        servoTest = hardwareMap.servo.get("servo1");

        waitForStart();
        boolean button = false;
        while (opModeIsActive()) {
            telemetry.addData("opModeIsActive", opModeIsActive());
            telemetry.update();

            int LeftD, RightD;
            if (gamepad1.left_stick_y < 0) {
                LeftD = -1;
            } else {
                LeftD = 1;
            }

            if (gamepad1.right_stick_y < 0) {
                RightD = 1;
            } else {
                RightD = -1;
            }


            motor1.setPower(0.8*LeftD * Math.pow(Math.abs(gamepad1.left_stick_y),2));
            telemetry.addData("motor1", LeftD * Math.sqrt(Math.abs(gamepad1.left_stick_y)));
            motor2.setPower(0.8*RightD * Math.pow(Math.abs(gamepad1.right_stick_y),2));
            telemetry.addData("motor2", RightD * Math.sqrt(Math.abs(gamepad1.right_stick_y)));
            telemetry.update();


            if (gamepad1.right_bumper && button) {
                servoTest.setPosition(-0.2);
                button = false;
            } else if (gamepad1.left_bumper && !button) {
                servoTest.setPosition(0.35);
                button = true;
            }
            telemetry.addData("opModeIsActive", opModeIsActive());

            telemetry.addData("Servo Position", servoTest.getPosition());
            telemetry.addData("Status", "Running");
            telemetry.update();
        }
    }

}



