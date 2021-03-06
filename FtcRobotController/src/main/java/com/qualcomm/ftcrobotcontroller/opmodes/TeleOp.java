package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;


public class TeleOp extends OpMode {
    DcMotor leftMotor;
    DcMotor rightMotor;
    DcMotor armAngle;
    DcMotor armExtension;
    Servo fingerLeft;
    Servo fingerRight;
    float oneLeftY = 0;
    float oneRightY = 0;
    float twoLeftY = 0;

    @Override
    public void init() {
        leftMotor = hardwareMap.dcMotor.get("left_drive");
        rightMotor = hardwareMap.dcMotor.get("right_drive");
        rightMotor.setDirection(DcMotor.Direction.REVERSE);

        armAngle = hardwareMap.dcMotor.get("arm_angle");

        armExtension = hardwareMap.dcMotor.get("arm_extension");

        fingerLeft = hardwareMap.servo.get("finger_left");
        fingerRight = hardwareMap.servo.get("finger_right");
    }

    @Override
    public void loop() {
        oneLeftY = -gamepad1.left_stick_y;
        oneRightY = -gamepad1.right_stick_y;
        twoLeftY = gamepad2.left_stick_y;

        leftMotor.setPower(oneLeftY);
        rightMotor.setPower(oneRightY);
        armExtension.setPower(twoLeftY);

        if (gamepad2.left_bumper) {
            fingerLeft.setPosition(0.42);
        } else if (gamepad2.right_bumper) {
            fingerLeft.setPosition(1.0);
        }

        if (gamepad2.x) {
            fingerRight.setPosition(0.4);
        } else if (gamepad2.b) {
            fingerRight.setPosition(0.8);
        }

        if (gamepad2.y) {
            armAngle.setPower(0.20);
        } else if (gamepad2.a) {
            armAngle.setPower(-0.20);
        } else {
            armAngle.setPower(0.0);
        }

        telemetry.addData("Arm Angle Position: ", armAngle.getCurrentPosition());
        telemetry.addData("Left Finger Position", fingerLeft.getPosition());
        telemetry.addData("Right Finger Position", fingerRight.getPosition());
    }
}