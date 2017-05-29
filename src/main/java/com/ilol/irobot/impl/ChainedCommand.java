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
    public <K extends SensorData> Optional<K> execute(CommandExecutor commandExecutor) {
        Optional<K> response = Optional.absent();
        for (Command command : commands) {
            response = command.execute(commandExecutor);
        }
        return response;
    }

}
