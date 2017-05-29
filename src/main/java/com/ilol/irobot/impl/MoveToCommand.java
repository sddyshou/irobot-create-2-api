package com.ilol.irobot.impl;

import java.util.ArrayList;
import java.util.List;

import com.ilol.irobot.Command;

public class MoveToCommand extends ChainedCommand {

    public MoveToCommand(Short distance, Short velocity) {
        if (((distance < 0) && (velocity > 0)) || ((distance > 0) && (velocity < 0))) {
            velocity = (short) - velocity;
        }
        List<Command> commands = new ArrayList<>(3);
        commands.add(DriveCommand.straight(velocity));
        commands.add(new WaitDistanceCommand(distance));
        commands.add(DriveCommand.stop());
        setCommands(commands);
    }
}
