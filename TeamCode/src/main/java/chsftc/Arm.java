package chsftc;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class Arm extends Subsystem {
    public DcMotor arm;
    public DcMotor wrist;
    // public Servo claw; # comment

    // public double
    public double[] powers = {0, 0};

    @Override
    public void initialize(LinearOpMode opMode) {
        arm = opMode.hardwareMap.get(DcMotor.class, "arm_motor");
        wrist = opMode.hardwareMap.get(DcMotor.class, "wrist_motor");
        arm.setDirection(DcMotor.Direction.FORWARD);
        wrist.setDirection(DcMotor.Direction.FORWARD);
    }

    @Override
    public void disable() {
        // No
        arm.setPower(0.0);
        wrist.setPower(0.0);
    }

    public void moveArm(double power) {

    }

    public void moveWrist(double left, double right) {
        left = Math.min(left, 0.2);
        right = Math.min(right, 0.2);
        double power = left - right;
        powers[1] = power;
        wrist.setPower(power);
    }
}
