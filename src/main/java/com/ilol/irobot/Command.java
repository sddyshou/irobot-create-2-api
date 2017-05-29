package com.ilol.irobot;

import com.google.common.base.Optional;

public interface Command {
    <K extends SensorData> Optional<K> execute(CommandExecutor commandExecutor);
}
