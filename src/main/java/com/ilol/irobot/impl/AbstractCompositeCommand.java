package com.ilol.irobot.impl;

import com.ilol.irobot.Command;

public class AbstractCompositeCommand extends AbstractCommand {

    protected void setCommand(Command... commands) {
        byte[] comm = new byte[] {};
        for (Command command : commands) {
            comm = concatAll(comm, command.getCommand());
        }
        setCommand(comm);
    }
}
