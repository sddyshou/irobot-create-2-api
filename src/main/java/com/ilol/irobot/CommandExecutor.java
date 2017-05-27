package com.ilol.irobot;

public interface CommandExecutor {
    void send(byte[] bytes);

    byte[] recv(int length);
}
