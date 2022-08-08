package org.firstinspires.ftc.teamcode

import com.acmerobotics.dashboard.FtcDashboard
import com.acmerobotics.dashboard.config.Config
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import org.firstinspires.ftc.teamcode.util.ToggleButton

@Disabled
@TeleOp(name = "Baked Bread Bot")
@Config class BreadBotTeleOpMode: LinearOpMode() {
    override fun runOpMode() {
        val drive = MecanumDrive(hardwareMap)
        val telemetry = MultipleTelemetry(telemetry, FtcDashboard.getInstance().telemetry)

        val spinButton = ToggleButton { gamepad1.x }
        val fastButton = ToggleButton { gamepad1.y }

        waitForStart()

        while (opModeIsActive()) {
            if (spinButton.isActive) {
                drive.move(0.0, 0.0, 0.2)
                telemetry.addData("Spinning", "Yes")
            } else {
                drive.teleOpRobotCentric(gamepad1, if (fastButton.isActive && ENABLE_FAST_MODE) 1.0 else 0.4)
                telemetry.addData("Spinning", "No")
            }

            telemetry.addData("Fast Mode", when {
                !ENABLE_FAST_MODE -> "Disabled"
                fastButton.isActive -> "Yes"
                else -> "No"
            })

            telemetry.addData("X", gamepad1.left_stick_x)
            telemetry.addData("Y", -gamepad1.left_stick_y)
            telemetry.addData("Rot", gamepad1.right_stick_x)

            spinButton.update()
            fastButton.update()
            telemetry.update()
        }
    }

    companion object {
        var ENABLE_FAST_MODE = true
    }
}