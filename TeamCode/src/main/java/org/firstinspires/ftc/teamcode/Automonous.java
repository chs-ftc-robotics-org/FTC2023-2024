package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import chsftc.Drivetrain;

@Autonomous(name="Autonomous Check", group="Auto")
public class Automonous extends LinearOpMode {
    public Drivetrain dt = new Drivetrain();
    public ElapsedTime timer;

    @Override
    public void runOpMode() throws InterruptedException {
        dt.initialize(this);
        timer = new ElapsedTime();
        waitForStart();

        timer.reset();
        while(opModeIsActive()) {
            if(timer.seconds() < 3) {
                dt.move(0.4);
                telemetry.addData("Timer", timer.toString());
                telemetry.update();
            } else {
                dt.move(0);
            }
        }
    }
}
