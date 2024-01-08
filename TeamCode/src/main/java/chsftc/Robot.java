package chsftc;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/* Final class that will bring together the other subclasses in this Java package
   So we can access all the of the robot's functionality from one class */
public class Robot {
    // Leave this alone for now
    public Drivetrain drivetrain = new Drivetrain();
    public Arm arm = new Arm();
    public PlaneLauncher launcher = new PlaneLauncher();

    public Subsystem[] subsystems = {
        drivetrain,
        arm,
        launcher
    };

    public Robot(LinearOpMode opMode) {
        for(Subsystem sub : subsystems) sub.initialize(opMode);
    }

    public void disableAll() {
        for(Subsystem sub : subsystems) sub.disable();
    }
}
