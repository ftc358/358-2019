package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public class LatchModule extends Thread implements RobotModule {

    DcMotor latchMotor;

    LatchModule(DcMotor latchMotor) {
        this.latchMotor = latchMotor;
    }

    public void run() {
        latchMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        latchMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        latchMotor.setTargetPosition(7000);

        latchMotor.setPower(1);

        while (latchMotor.isBusy()) {
            //Wait Until Target Position is Reached
        }

        latchMotor.setPower(0);
    }
}
