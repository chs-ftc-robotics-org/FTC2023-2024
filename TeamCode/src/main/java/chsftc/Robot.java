package chsftc;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/* Final class that will bring together the other subclasses in this Java package
   So we can access all the of the robot's functionality from one class */
public class Robot {
    // Leave this alone for now
    public Drivetrain drivetrain = new Drivetrain();
    public Arm arm = new Arm();

    public Robot(LinearOpMode opMode) {
        drivetrain.initialize(opMode);
        arm.initialize(opMode);
    }
}
