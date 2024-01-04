package chsftc;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class Arm extends Subsystem {
    public DcMotor arm;
    public DcMotor wrist;
    public Servo clawLeft;
    public Servo clawRight;

    // public double
    public double[] powers = {0, 0};

    @Override
    public void initialize(LinearOpMode opMode) {
        this.opMode = opMode;
        arm = opMode.hardwareMap.get(DcMotor.class, "arm_motor");
        wrist = opMode.hardwareMap.get(DcMotor.class, "wrist_motor");
        clawLeft = opMode.hardwareMap.get(Servo.class, "claw_left");
        clawRight = opMode.hardwareMap.get(Servo.class, "claw_right");
        arm.setDirection(DcMotor.Direction.FORWARD);
        wrist.setDirection(DcMotor.Direction.FORWARD);
    }

    @Override
    public void disable() {
        // No
        arm.setPower(0.0);
        wrist.setPower(0.0);
    }

    public void moveArm(boolean left, boolean right) {
        if(left && !right) {
            arm.setPower(-0.3);
        }
        else if(!left && right) {
            arm.setPower(0.1);
        }
        else {
            arm.setPower(0.0);
        }
    }

    public void moveWrist(double left, double right) {
        left = Math.min(left, 0.2);
        right = Math.min(right, 0.2);
        double power = left - right;
        powers[1] = power;
        wrist.setPower(power);
    }

    public void moveClaws(boolean gamepadX, boolean gamepadA) {
        if(!(gamepadX && gamepadA)) {
            if(gamepadX) {
                clawLeft.setPosition(0);
                clawRight.setPosition(1);
            }
            if(gamepadA) {
                clawLeft.setPosition(1);
                clawRight.setPosition(0);
            }
        }
    }
}
