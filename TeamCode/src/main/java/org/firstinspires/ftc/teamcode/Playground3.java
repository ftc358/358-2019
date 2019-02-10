package org.firstinspires.ftc.teamcode;

import android.util.Log;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.concurrent.TimeUnit;

@TeleOp
public class Playground3 extends AutoEngine358 {

    int detected;

    double timeSpent;

    @Override
    public void runOpMode() throws InterruptedException {
        initialize();
        try {
            ElapsedTime timer = new ElapsedTime();
            TimeLimitedCodeBlock.runWithTimeout(new Runnable() {
                @Override
                public void run() {
                    detected = lookForwardAndCheck();
                    timeSpent = timer.time(TimeUnit.SECONDS);
                }
            }, 5, TimeUnit.SECONDS);
        } catch (Exception e) {
            telemetry.addData("Timed out detecting", "setting detected = 2");
            Log.d("timed out", "setting detected to 2");
            detected = 2;
        }
        telemetry.addData("Detection", detected);
        telemetry.update();
        Log.d("detection", detected+ "");
        Log.d("Time used:", timeSpent+"");
    }
}
