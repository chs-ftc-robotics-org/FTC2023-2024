package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import chsftc.Drivetrain;

@TeleOp(name="TeleOp Test", group="Tests")
//@Disabled
// COPIED SAMPLE CODE FROM EXAMPLES FOLDER
// DO NOT MODIFY UNTIL THE chsftc PACKAGE IS FINISHED
public class TeleOpTest extends LinearOpMode {

    public Drivetrain drivetrain = new Drivetrain();

    // Declare OpMode members for each of the 4 motors.
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {

        // Initialize the hardware variables. Note that the strings used here must correspond
        // to the names assigned during the robot configuration step on the DS or RC devices.
        // leftFrontDrive  = hardwareMap.get(DcMotor.class, "left_front_drive");
        // leftBackDrive  = hardwareMap.get(DcMotor.class, "left_back_drive");
        // rightFrontDrive = hardwareMap.get(DcMotor.class, "right_front_drive");
        // rightBackDrive = hardwareMap.get(DcMotor.class, "right_back_drive");
        drivetrain.initialize(this);

        // ########################################################################################
        // !!!            IMPORTANT Drive Information. Test your motor directions.            !!!!!
        // ########################################################################################
        // Most robots need the motors on one side to be reversed to drive forward.
        // The motor reversals shown here are for a "direct drive" robot (the wheels turn the same direction as the motor shaft)
        // If your robot has additional gear reductions or uses a right-angled drive, it's important to ensure
        // that your motors are turning in the correct direction.  So, start out with the reversals here, BUT
        // when you first test your robot, push the left joystick forward and observe the direction the wheels turn.
        // Reverse the direction (flip FORWARD <-> REVERSE ) of any wheel that runs backward
        // Keep testing until ALL the wheels move the robot forward when you push the left joystick forward.

        // Wait for the game to start (driver presses PLAY)
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            drivetrain.omniMove(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);
            telemetry.update();
        }
    }}
