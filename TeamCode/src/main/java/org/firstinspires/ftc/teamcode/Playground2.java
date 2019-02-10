package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class Playground2 extends AutoEngine358 {
    private boolean done = false;

    @Override
    public void runOpMode() throws InterruptedException {
        initialize();
        runMotor(lift,1,-1800);
        runMotor(extend,1,2500);
    }
}
