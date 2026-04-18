package org.firstinspires.ftc.teamcode.commands;

import com.seattlesolvers.solverslib.command.InstantCommand;
import com.seattlesolvers.solverslib.command.SequentialCommandGroup;
import com.seattlesolvers.solverslib.command.WaitUntilCommand;

import org.firstinspires.ftc.teamcode.subsystems.ArmSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.SlideConstants;

public class ArmStartPositionCommand extends SequentialCommandGroup {

    private ArmSubsystem arm;

    public ArmStartPositionCommand(ArmSubsystem arm) {
        this.arm = arm;

        addCommands(
                // Retract slide first
                new InstantCommand( () -> { arm.setSlidePosition(SlideConstants.SLIDE_CRUISE);}),
                new WaitUntilCommand( arm::slideCloseToPos ),
                // Then move to cruise level
                new InstantCommand( () -> { arm.setWristPositionLevel(0);} ),
                new InstantCommand( () -> { arm.goToLevel( 0 );} )
        );
        addRequirements(arm);
    }

}
