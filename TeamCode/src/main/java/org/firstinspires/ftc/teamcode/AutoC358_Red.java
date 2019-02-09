package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import static java.lang.Math.sqrt;

@Autonomous
public class AutoC358_Red extends AutoEngine358 {
    private double POWER = 1;
    private boolean done = false;

    public void runOpMode() throws InterruptedException {

        initialize(new RobotPosition(11, -11, 225));

        token.setPosition(0);
        latch.setPower(0);

        waitForStart();

        while (opModeIsActive() && !done) {

            unlatch();

            int cubePosition = lookForwardAndCheck();
            deactivateVuforia();

            telemetry.addData("cube position", cubePosition);
            telemetry.addData("current absolute heading", getAbsoluteCurrentHeading());
            telemetry.update();

            switch (cubePosition) {
                case 1:
                    turnTo(90, POWER);
                    forward(POWER, 28);
                    turnTo(45, POWER);
                    forward(POWER, 7 * 2 * sqrt(2));
                    turnTo(180, POWER);
                    forward(POWER, -60);
                    turnTo(180, POWER);
                    dropToken();
                    forward(POWER, 76);
                    done = true;
                    break;
                case 2:
                    turnTo(135, POWER);
                    forward(POWER, 6 * 2 * sqrt(2));
                    forward(POWER, -4 * 2 * sqrt(2));
                    turnTo(45, POWER);
                    forward(POWER, 18 * 2 * sqrt(2));
                    turnTo(180, POWER);
                    forward(POWER, -44);
                    turnTo(180, POWER);
                    dropToken();
                    forward(POWER, 76);
                    done = true;
                    break;
                case 3:
                    turnTo(180, POWER);
                    forward(POWER, 24);
                    forward(POWER, -12);
                    turnTo(45, POWER);
                    forward(POWER, 21 * 2 * sqrt(2));
                    turnTo(180, POWER);
                    forward(POWER, -44);
                    turnTo(180, POWER);
                    dropToken();
                    forward(POWER, 76);
                    done = true;
                    break;
            }
        }
    }

    public void dropToken() {
        token.setPosition(0.6);
    }

    public void unlatch() throws InterruptedException {
        runMotor(latch, 1, -10400);
        forward(1, 2);
        strafe(1, 12.5);
        turnTo(225, POWER);
        forward(1, -5.5);
        done = true;
    }
}
