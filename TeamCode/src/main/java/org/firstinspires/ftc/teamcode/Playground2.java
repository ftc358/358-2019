package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class Playground2 extends AutoEngine358 {
    private boolean done = false;

    @Override
    public void runOpMode() throws InterruptedException {
        initialize();
        resetAllDriveMotorEncoders();
        strafe(1, 12.5);
        while (opModeIsActive()) {
            telemetry.addData("fL", fL.getCurrentPosition());
            telemetry.addData("bL", bL.getCurrentPosition());
            telemetry.addData("fR", fR.getCurrentPosition());
            telemetry.addData("bR", bR.getCurrentPosition());
            telemetry.update();
        }
        sleep(1000);
    }
}
