package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by Lev on 27.10.2015.
 */
public class TeleOp extends OpMode {
    DcMotor leftMotor;
    DcMotor rightMotor;
    DcMotor armPosition;
    float leftY = 0;
    float rightY = 0;

    @Override
    public void init() {
        leftMotor = hardwareMap.dcMotor.get("left_drive");
        rightMotor = hardwareMap.dcMotor.get("right_drive");
        rightMotor.setDirection(DcMotor.Direction.REVERSE);

        armPosition = hardwareMap.dcMotor.get("arm_position");
        armPosition.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
    }

    @Override
    public void loop() {
        leftY = -gamepad1.left_stick_y;
        rightY = -gamepad1.right_stick_y;
        leftMotor.setPower(leftY);
        rightMotor.setPower(rightY);


        if (gamepad2.dpad_up)
        {
            armPosition.setPower(0.2);
        }
        else if (gamepad2.dpad_down)
        {
            armPosition.setPower(-0.2);
        }
        else {
            armPosition.setPower(0);
        }

        telemetry.addData("Arm Position", armPosition.getCurrentPosition());
    }
}
