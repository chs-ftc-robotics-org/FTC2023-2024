package chsftc;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class PlaneLauncher extends Subsystem {
    public DcMotor launcher;
    public ElapsedTime launchTimer;
    public boolean running = false;

    @Override
    public void initialize(LinearOpMode opMode) {
        this.opMode = opMode;
        launcher = opMode.hardwareMap.get(DcMotor.class, "launcher1");
        launchTimer = new ElapsedTime();
    }

    @Override
    public void disable() {
        running = false;
        launcher.setPower(0.0);
    }

    public void launch() {
        if(running && launchTimer.seconds() > 0.5) disable();

        boolean pressed = opMode.gamepad1.b;
        if(pressed) {
            launchTimer.reset();
            running = true;
            launcher.setPower(1.0);
        }
    }
}


