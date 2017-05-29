package com.ilol.irobot.impl;

import com.google.common.base.Optional;
import com.ilol.irobot.CommandExecutor;
import com.ilol.irobot.SensorData;

public class WaitTimeCommand extends SingleCommand {
    private int seconds;

    public WaitTimeCommand(Integer seconds) {
        this.seconds = seconds.intValue();
    }

    @Override
    public <K extends SensorData> Optional<K> execute(CommandExecutor commandExecutor) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException("Failed to sleep for " + seconds + "seconds");
        }
        return Optional.absent();
    }
}
