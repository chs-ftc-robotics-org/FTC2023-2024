package chsftc;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public abstract class Subsystem {
    private LinearOpMode opMode;

    public abstract void disable();
    public abstract void initialize(LinearOpMode opMode);

}
