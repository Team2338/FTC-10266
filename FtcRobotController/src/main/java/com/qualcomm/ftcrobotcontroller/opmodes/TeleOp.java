package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Lev on 27.10.2015.
 */
public class TeleOp extends OpMode {
    DcMotor leftMotor;
    DcMotor rightMotor;
    DcMotor armAngleLeft;
    DcMotor armAngleRight;
    DcMotor armExtension;
    Servo finger;
    float leftY = 0;
    float rightY = 0;

    @Override
    public void init() {
        leftMotor = hardwareMap.dcMotor.get("left_drive");
        rightMotor = hardwareMap.dcMotor.get("right_drive");
        rightMotor.setDirection(DcMotor.Direction.REVERSE);

        armAngleLeft = hardwareMap.dcMotor.get("arm_angle_left");
        armAngleRight = hardwareMap.dcMotor.get("arm angle right");

        armExtension = hardwareMap.dcMotor.get("arm_extension");

        finger = hardwareMap.servo.get("finger");
    }

    @Override
    public void loop() {
        leftY = -gamepad1.left_stick_y;
        rightY = -gamepad1.right_stick_y;
        leftMotor.setPower(leftY);
        rightMotor.setPower(rightY);

        if (gamepad2.left_bumper)
        {
            finger.setPosition(0.42);
        }
        else if (gamepad2.right_bumper)
        {
            finger.setPosition(1.0);
        }

       if (gamepad2.dpad_up)
        {
            armAngleLeft.setPower(0.1);
            armAngleRight.setPower(0.1);
        }
        else if (gamepad2.dpad_down)
        {
            armAngleLeft.setPower(-0.1);
            armAngleRight.setPower(-0.1);
        }
        else {
            armAngleLeft.setPower(0);
            armAngleRight.setPower(0);
        }

        if (gamepad2.y)
        {
            armExtension.setPower(0.5);
        }
        else if (gamepad2.a)
        {
            armExtension.setPower(-0.5);
        }
        else
        {
            armExtension.setPower(0);
        }

        telemetry.addData("Arm Angle Position (Left): ", armAngleLeft.getCurrentPosition());
        telemetry.addData("Arm Angle Position (Right): ", armAngleRight.getCurrentPosition());
        telemetry.addData("Finger Position", finger.getPosition());
    }
}
