package org.firstinspires.ftc.teamcode;

import android.util.Log;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import java.util.concurrent.TimeUnit;

import static java.lang.Math.sqrt;

@Autonomous
public class AutoD358_Blue extends AutoEngine358 {
    private double POWER = 1;
    private boolean done = false;

    private int cubePosition;
    private boolean didTimeOut = false;

    public void runOpMode() throws InterruptedException {

        initialize(new RobotPosition(11, 11, 315));
        token.setPosition(0);

        waitForStart();

        while (opModeIsActive() && !done) {

            unlatch();

            try {
                TimeLimitedCodeBlock.runWithTimeout(new Runnable() {
                    @Override
                    public void run() {
                        cubePosition = lookForwardAndCheck();
                    }
                }, 5, TimeUnit.SECONDS);
            } catch (Exception e) {
                telemetry.addData("Timed out detecting", "setting detected = 1");
                Log.d("timed out", "setting detected = 1");
                cubePosition = 1;
                didTimeOut = true;
            }

            deactivateVuforia();

            telemetry.addData("cube position", cubePosition);
            telemetry.addData("did time out:", didTimeOut);
            telemetry.addData("current absolute heading", getAbsoluteCurrentHeading());
            telemetry.update();
            deactivateVuforia();

            switch (cubePosition) {
                case 1:
                    turnTo(180, POWER);
                    forward(POWER, 42);
                    turnTo(270, POWER);
                    forward(POWER, 30);
                    turnTo(315, POWER);
                    forward(POWER, 5 * 2 * sqrt(2));
                    dropToken();
                    forward(POWER, 1 * 2 * sqrt(2));
                    turnTo(0, POWER);
                    forward(POWER, 76);
                    break;
                case 2:
                    turnTo(225, POWER);
                    forward(POWER, 18 * 2 * sqrt(2));
                    turnTo(315, POWER);
                    forward(POWER, 4 * 2 * sqrt(2));
                    dropToken();
                    turnTo(0, POWER);
                    forward(POWER, 78);
                    break;
                case 3:
                    turnTo(270, POWER);
                    forward(POWER, 42);
                    turnTo(0, POWER);
                    forward(POWER, -32);
                    turnTo(0, POWER);
                    dropToken();
                    forward(POWER, 74);
                    break;
            }
            runMotor(lift, 1, -1800);
            runMotor(extend, 1, 1000);
            done = true;
        }
    }

    public void dropToken() {
        token.setPosition(0.6);
    }

    public void unlatch() throws InterruptedException {
        runMotor(latch, 1, -10400);
        forward(1, 2);
        strafe(1, 12.5);
        forward(1, -5.5);
        turnTo(315, POWER);
        done = true;
    }
}
