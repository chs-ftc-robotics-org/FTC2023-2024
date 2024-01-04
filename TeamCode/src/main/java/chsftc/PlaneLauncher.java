package chsftc;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

public class PlaneLauncher extends Subsystem {
    public Servo launcher;

    @Override
    public void initialize(LinearOpMode opMode) {
        this.opMode = opMode;
        launcher = opMode.hardwareMap.get(Servo.class, "launcher1");
    }

    @Override
    public void disable() {

    }

    public void launch() {
        System.out.println("Servo spins");
    }
}


