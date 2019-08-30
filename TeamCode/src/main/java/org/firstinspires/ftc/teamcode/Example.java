package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.AutoEngine358;

@Autonomous
public class Example extends AutoEngine358 {

    double power = 1;
    int cubePosition;
    private boolean done = false;

    public void runOpMode() throws InterruptedException {

        initialize();

        waitForStart();

        while (opModeIsActive() && !done) {
            forward(power, 33);
            turn(90, power);
            forward(power, 8);
            cubePosition = lookForwardAndCheck();
            telemetry.addData("Response, ", cubePosition);
            telemetry.update();
            switch (cubePosition) {
                case 1:
                    turn(-180, power);
                    forward(power, 36);
                    turn(-45, power);
                    forward(power,15);
                    done = true;
                    break;
                case 2:
                    forward(power, 28);
                    turn(45, power);
                    forward(power,15);
                    done = true;
                    break;
            }
        }
    }
}
