package org.firstinspires.ftc.teamcode.commands;

import com.seattlesolvers.solverslib.command.Command;
import com.seattlesolvers.solverslib.command.CommandBase;
import com.seattlesolvers.solverslib.command.InstantCommand;
import com.seattlesolvers.solverslib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.subsystems.ShooterSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.mechanism.ShooterConstants;

public class ShootBallCommand extends SequentialCommandGroup {

    private final ShooterSubsystem shooterSubsystem;

    public ShootBallCommand(ShooterSubsystem shooterSubsystem) {
        this.shooterSubsystem = shooterSubsystem;
        addRequirements(shooterSubsystem);
        addCommands(
                new InstantCommand( shooterSubsystem::setHopperClosed ),
                new RunCommand( () -> shooterSubsystem.setFlywheelVelocity( ShooterConstants.FlywheelSpeed.SPEED_FAR))
                        .interruptOn( shooterSubsystem::atSpeed )
                        .withTimeout(10000),
                new RunCommand( () -> shooterSubsystem.setIntakePower(ShooterConstants.INTAKE_POWER_REVERSE))
                        .withTimeout(2000),
                new InstantCommand( () -> shooterSubsystem.setIntakePower(0)),
                new RunCommand( shooterSubsystem::setHopperOpen).withTimeout(500),
                new InstantCommand( shooterSubsystem::setHopperClosed),
                new InstantCommand( () -> shooterSubsystem.setFlywheelVelocity(ShooterConstants.FlywheelSpeed.OFF))
        );
    }

    @Override
    public void initialize() {
        super.initialize();
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
    }

    @Override
    public void execute() {
        super.execute();
    }

    @Override
    public boolean isFinished() {
        return super.isFinished();
    }

    @Override
    public Command withTimeout(long millis) {
        return super.withTimeout(millis);
    }
}
