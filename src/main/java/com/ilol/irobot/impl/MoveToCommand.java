package com.ilol.irobot.impl;

import java.util.ArrayList;
import java.util.List;

import com.ilol.irobot.Command;

public class MoveToCommand extends ChainedCommand {

    public MoveToCommand(Short distance, Short velocity) {
        if (((distance < 0) && (velocity > 0)) || ((distance > 0) && (velocity < 0))) {
            throw new IllegalArgumentException("Illegal distance and velocity values. Will cause infinite loop.");
        }
        List<Command> commands = new ArrayList<>(3);
        commands.add(DriveCommand.straight(velocity));
        commands.add(new WaitTimeCommand(3));
        commands.add(DriveCommand.stop());
        setCommands(commands);
    }
}
