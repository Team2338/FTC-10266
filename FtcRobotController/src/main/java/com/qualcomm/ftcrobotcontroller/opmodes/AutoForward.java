package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Eddie Ho on 11/10/2015.
 */
public class AutoForward extends LinearOpMode {
    DcMotor leftMotor;
    DcMotor rightMotor;

    @Override
    public void runOpMode() throws InterruptedException {
        //setup the left and right motors from the configuration file
        leftMotor = hardwareMap.dcMotor.get("left_drive");
        rightMotor = hardwareMap.dcMotor.get("right_drive");
        //reverse the right side motor
        rightMotor.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();

        leftMotor.setPower(1.0);
        rightMotor.setPower(1.0);

        sleep(2000);

        leftMotor.setPower(0.0);
        rightMotor.setPower(0.0);
    }
}
