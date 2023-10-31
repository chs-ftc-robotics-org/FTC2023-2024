package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import chsftc.Drivetrain;

@TeleOp(name="Motor test", group="Tests")
public class MotorTest extends LinearOpMode {
    public Drivetrain drivetrain = new Drivetrain();
    @Override
    public void runOpMode() {
        drivetrain.initialize(this);
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            drivetrain.move(gamepad1.left_stick_x);
            telemetry.update();
        }
    }
}
