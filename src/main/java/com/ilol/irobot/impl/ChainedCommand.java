package com.ilol.irobot.impl;

import java.util.List;

import com.google.common.base.Optional;
import com.ilol.irobot.Command;
import com.ilol.irobot.CommandExecutor;
import com.ilol.irobot.SensorData;

public class ChainedCommand implements Command {
    private List<Command> commands;

    public void setCommands(List<Command> commands) {
        this.commands = commands;
    }

    @Override
    public Optional<? extends SensorData> execute(CommandExecutor commandExecutor) {
        Optional<? extends SensorData> response = Optional.absent();
        for (Command command : commands) {
            response = command.execute(commandExecutor);
        }
        return response;
    }

}
