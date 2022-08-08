package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Config
@TeleOp(name = "TELEOP")
public class TeleopDemo extends OpMode {
    MecanumDrive drive;
    public static double SPEED_MULTIPLIER = 0.5;
    @Override
    public void init() {
        drive = new MecanumDrive(hardwareMap);
    }

    @Override
    public void loop() {
        drive.teleOpRobotCentric(gamepad1, SPEED_MULTIPLIER);
    }
}
