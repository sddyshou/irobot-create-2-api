package com.ilol.irobot.impl;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Optional;
import com.ilol.irobot.Command;
import com.ilol.irobot.CommandExecutor;
import com.ilol.irobot.SensorData;

public class ChainedCommand implements Command {
    private static final int SLEEP_INTERVAL = 50;
    private List<Command> commands;

    public ChainedCommand() {
        this(new ArrayList<>());
    }

    public ChainedCommand(List<Command> commands) {
        this.commands = commands;
    }

    public void setCommands(List<Command> commands) {
        this.commands = commands;
    }

    @Override
    public <K extends SensorData> Optional<K> execute(CommandExecutor commandExecutor) {
        Optional<K> response = Optional.absent();
        for (Command command : commands) {
            response = command.execute(commandExecutor);
            try {
                Thread.sleep(SLEEP_INTERVAL);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return response;
    }

}
