package chsftc;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class Arm extends Subsystem {
    public DcMotor arm;
    public DcMotor wrist;
    // public Servo claw; # comment

    public void initialize(LinearOpMode opMode) {

    }

    public void disable() {
        // No
    }
}
