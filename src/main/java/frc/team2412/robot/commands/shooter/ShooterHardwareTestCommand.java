package frc.team2412.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.team2412.robot.subsystem.ShooterSubsystem;
import frc.team2412.robot.subsystem.ShooterSubsystem.ShooterConstants;

public class ShooterHardwareTestCommand extends SequentialCommandGroup {
    public ShooterHardwareTestCommand(ShooterSubsystem shooter) {
        addCommands(new ShooterTurretSetAngleCommand(shooter, ShooterConstants.MIN_TURRET_ANGLE),
                new ShooterTurretSetAngleCommand(shooter, ShooterConstants.MAX_TURRET_ANGLE),
                new ShooterTurretSetAngleCommand(shooter,
                        (ShooterConstants.MIN_TURRET_ANGLE + ShooterConstants.MAX_TURRET_ANGLE) / 2),
                new ShooterHoodSetConstantAngleCommand(shooter, ShooterConstants.MAX_HOOD_ANGLE),
                new ShooterHoodSetConstantAngleCommand(shooter, ShooterConstants.MIN_HOOD_ANGLE),
                new ShooterFlywheelStartCommand(shooter),
                new WaitCommand(1),
                new ShooterFlywheelStopCommand(shooter));
    }
}
