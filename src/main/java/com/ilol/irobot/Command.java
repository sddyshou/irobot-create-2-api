package com.ilol.irobot;

import com.google.common.base.Optional;

public interface Command {
    Optional<? extends SensorData> execute(CommandExecutor commandExecutor);
}
