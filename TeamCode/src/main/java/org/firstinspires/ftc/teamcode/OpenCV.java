package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.openftc.easyopencv.*;

@Autonomous(name="Autonomous Check", group="Auto")
public class OpenCV extends LinearOpMode {
    public int viewId;
    public OpenCvCamera internalCam;

    public void runOpMode() {
        viewId = hardwareMap
                .appContext
                .getResources()
                .getIdentifier(
                        "cameraMonitorViewId",
                        "id",
                        hardwareMap.appContext.getPackageName()
                );

        /*
        internalCam = OpenCvCameraFactory
                .getInstance()
                .createInternalCamera(
                        OpenCvInternalCamera.CameraDirection.BACK,
                        //cameraMonitorViewId
                );


         */
        WebcamName webcamName = hardwareMap.get(WebcamName.class, "camera");

    }

    public void disable() {}
}
