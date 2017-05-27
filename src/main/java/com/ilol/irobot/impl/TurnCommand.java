package com.ilol.irobot.impl;

import com.ilol.irobot.Command;

public class TurnCommand extends ChainedCommand {
    public TurnCommand(Short angle) {
        this(angle, (short) 100);
    }

    public TurnCommand(Short angle, Short velocity) {
        Command turn = angle > 0 ? DriveCommand.turnCCLW(velocity) : DriveCommand.turnCLW(velocity);
        // TODO:
//        setCommand(turn);
    }
}
