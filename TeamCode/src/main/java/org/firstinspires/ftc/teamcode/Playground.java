package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class Playground extends AutoEngine358 {

    private boolean done = false;

    @Override
    public void runOpMode() throws InterruptedException {
    }

    public void strafe(double power) {

        fL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        runUsingEncoders();

        //Set Drive Power
        fL.setPower(-power);
        bL.setPower(+power);
        fR.setPower(+power);
        bR.setPower(-power);

        telemetry.addData("fL position", fL.getCurrentPosition());
        telemetry.addData("bL position", bL.getCurrentPosition());
        telemetry.addData("fR position", fR.getCurrentPosition());
        telemetry.addData("bR position", bR.getCurrentPosition());
    }
}
