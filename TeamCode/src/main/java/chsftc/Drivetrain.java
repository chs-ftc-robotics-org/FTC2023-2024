package chsftc;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.ArrayList;

public class Drivetrain extends Subsystem {
    // Drivetrain is the class we will use to control the robot's movement in other files
    // Define variables used
    private final double REDUCE = 2.0 / 5.0;

    private LinearOpMode opMode;

    // Define motor variables
    public DcMotor frontLeft;
    public DcMotor frontRight;
    public DcMotor backLeft;
    public DcMotor backRight;

    public double[] powers = {0.0, 0.0, 0.0, 0.0};

    // Get the robot's motors from the hardware map
    @Override
    public void initialize(LinearOpMode opMode) {
        this.opMode = opMode;

        frontLeft = opMode.hardwareMap.get(DcMotor.class, "front_left");
        frontRight = opMode.hardwareMap.get(DcMotor.class, "front_right");
        backLeft = opMode.hardwareMap.get(DcMotor.class, "back_left");
        backRight = opMode.hardwareMap.get(DcMotor.class, "back_right");

        // Use motor.setDirection(DcMotor.Direction.REVERSE) to reverse a motor if needed
        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        frontRight.setDirection(DcMotor.Direction.FORWARD);
        backLeft.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.FORWARD);
    }

    // Make the robot halt
    @Override
    public void disable() {
        move(0);
    }

    public void move(double power) {
        power *= REDUCE;
        frontLeft.setPower(power);
        frontRight.setPower(power);
        backLeft.setPower(power);
        backRight.setPower(power);
        powers[0] = power;
        powers[1] = power;
        powers[2] = power;
        powers[3] = power;
    }

    /* Positive power: Turn righ3/
       Negative power: Turn left */
    public void turn(double power) {
        power *= REDUCE;
        frontLeft.setPower(power);
        frontRight.setPower(-power);
        backLeft.setPower(power);
        backRight.setPower(-power);
        powers[0] = power;
        powers[1] = -power;
        powers[2] = power;
        powers[3] = -power;
    }

    /* Positive power: Move right
       Negative power: Move left */
    public void strafe(double power) {
        power *= REDUCE;
        frontLeft.setPower(power);
        frontRight.setPower(-power);
        backLeft.setPower(-power);
        backRight.setPower(power);
        powers[0] = power;
        powers[1] = -power;
        powers[2] = -power;
        powers[3] = power;
    }

    public void omniMove(double axial, double lateral, double yaw) {
        // Do E
        double frontLeftPower  = axial + lateral + yaw;
        double frontRightPower = axial - lateral - yaw;
        double backLeftPower   = axial - lateral + yaw;
        double backRightPower  = axial + lateral - yaw;

        double max;
        max = Math.max(Math.abs(frontLeftPower), Math.abs(frontLeftPower));
        max = Math.max(max, Math.abs(backLeftPower));
        max = Math.max(max, Math.abs(backRightPower));

        if (max > 1.0) {
            frontLeftPower  /= max;
            frontRightPower /= max;
            backLeftPower   /= max;
            backRightPower  /= max;
        }
        frontRightPower *= REDUCE;
        frontLeftPower  *= REDUCE;
        backLeftPower   *= REDUCE;
        backRightPower  *= REDUCE;

        frontLeft.setPower(frontLeftPower);
        frontRight.setPower(frontRightPower);
        backLeft.setPower(backLeftPower);
        backRight.setPower(backRightPower);
        powers[0] = frontLeftPower;
        powers[1] = frontRightPower;
        powers[2] = backLeftPower;
        powers[3] = backRightPower;
        //what
    }
    public void testIndividual(double fl, double fr, double bl, double br){
        fl *= REDUCE;
        fr *= REDUCE;
        bl *= REDUCE;
        br *= REDUCE;
        frontLeft.setPower(fl);
        frontRight.setPower(fr);
        backLeft.setPower(bl);
        backRight.setPower(br);
        powers[0] = fl;
        powers[1] = fr;
        powers[2] = bl;
        powers[3] = br;
    }
}
