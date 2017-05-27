package com.ilol.irobot;

public interface Connection extends CommandExecutor {
    void open();

    void close();
}
