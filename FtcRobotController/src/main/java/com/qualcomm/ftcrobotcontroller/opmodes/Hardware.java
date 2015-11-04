package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by Lev on 27.10.2015.
 */
public class Hardware extends TeleOp {
    public double leftDrive_Power() {
        double motorPower = 0.0;

        if (leftMotor != null) {
            motorPower = leftMotor.getPower();

        }

        return motorPower;
    }

    public double rightDrive_Power() {
        double motorPower = 0.0;

        if (rightMotor != null) {
            motorPower = rightMotor.getPower();

        }

        return motorPower;

    }

    public double armPosition_Power() {
        double motorPower = 0.0;

        if (armPosition != null) {
            motorPower = armPosition.getPower();
        }

        return motorPower;
    }

}


