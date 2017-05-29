package com.ilol.irobot.impl;

import java.util.ArrayList;
import java.util.List;

import com.ilol.irobot.Command;

public class TurnCommand extends ChainedCommand {
    public TurnCommand(Short angle) {
        this(angle, (short) 100);
    }

    /**
     *
     * @param angle positive is clockwise
     * @param velocity
     */
    public TurnCommand(Short angle, Short velocity) {
        angle = (short) -angle;
        Command turn = angle > 0 ? DriveCommand.turnCCLW(velocity) : DriveCommand.turnCLW(velocity);
        List<Command> commands = new ArrayList<>(3);
        commands.add(turn);
        commands.add(new WaitAngleCommand(angle));
        commands.add(DriveCommand.stop());
        setCommands(commands);
    }
}
