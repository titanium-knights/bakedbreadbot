package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import org.firstinspires.ftc.teamcode.util.ToggleButton

@TeleOp(name = "Baked Bread Bot")
class BreadBotTeleOpMode: LinearOpMode() {
    override fun runOpMode() {
        val drive = MecanumDrive(hardwareMap)

        val spinButton = ToggleButton { gamepad1.x }
        val fastButton = ToggleButton { gamepad1.y }

        waitForStart()

        while (opModeIsActive()) {
            if (spinButton.isActive) {
                drive.move(0.0, 0.0, 0.2)
            } else {
                drive.teleOpRobotCentric(gamepad1, if (fastButton.isActive) 1.0 else 0.4)
            }

            spinButton.update()
            fastButton.update()
        }
    }
}