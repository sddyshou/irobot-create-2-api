package com.ilol.irobot.impl;

import java.util.Arrays;

import com.google.common.base.Optional;
import com.ilol.irobot.Command;
import com.ilol.irobot.CommandExecutor;
import com.ilol.irobot.SensorData;

public class SingleCommand implements Command {

    private byte[] command;

    @Override
    public Optional<? extends SensorData> execute(CommandExecutor commandExecutor) {
        while (true) {
            commandExecutor.send(getCommand());
            Optional<? extends SensorData> response = getResponse(command);
            boolean status = handleResponse(response);
            if (status) {
                return response;
            }
        }
    }

    protected void setCommand(byte[] command) {
        this.command = command;
    }

    protected void setCommand(int[] intCmd) {
        byte[] byteCmd = new byte[intCmd.length];
        for (int i = 0; i < intCmd.length; i++) {
            byteCmd[i] = (byte) intCmd[i];
        }
        setCommand(byteCmd);
    }

    public byte[] getCommand() {
        return command;
    }

    public int getLengthResponse() {
        return 0;
    }

    public Optional<? extends SensorData> getResponse(byte[] response) {
        return Optional.absent();
    }

    protected static byte[] concatAll(byte[] first, byte[]... rest) {
        int totalLength = first.length;
        for (byte[] array : rest) {
            totalLength += array.length;
        }
        byte[] result = Arrays.copyOf(first, totalLength);
        int offset = first.length;
        for (byte[] array : rest) {
            System.arraycopy(array, 0, result, offset, array.length);
            offset += array.length;
        }
        return result;
    }

    public boolean handleResponse(Optional<? extends SensorData> responseData) {
        return true;
    }

}
