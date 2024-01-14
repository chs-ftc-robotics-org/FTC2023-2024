package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.openftc.easyopencv.*;

@Autonomous(name="OPenCV", group="Auto")
public class OpenCV extends LinearOpMode {
    public int viewId;
    public OpenCvCamera camera;
    public WebcamName webcam;

    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        viewId = hardwareMap
                .appContext
                .getResources()
                .getIdentifier(
                        "cameraMonitorViewId",
                        "id",
                        hardwareMap.appContext.getPackageName()
                );

        webcam = hardwareMap.get(WebcamName.class, "camera");

        camera = OpenCvCameraFactory
                .getInstance()
                .createWebcam(
                        webcam,
                        viewId
                );

        camera.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener() {
            @Override
            public void onOpened() {
                // Usually this is where you'll want to start streaming from the camera (see section 4)
            }
            @Override
            public void onError(int errorCode) {
                /*
                 * This will be called if the camera could not be opened
                 */
            }
        });

        camera.startStreaming(320, 240, OpenCvCameraRotation.UPRIGHT);

    }

    public void disable() {}
}
