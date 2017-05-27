package com.ilol.irobot.impl;

import java.lang.reflect.Constructor;

import com.google.common.base.Optional;
import com.ilol.irobot.SensorData;
import com.ilol.irobot.enums.OpCode;
import com.ilol.irobot.enums.SensorPacket;

public class SensorCommand extends SingleCommand {

    private SensorPacket sensorPacket = null;

    public SensorCommand(Integer packetId) {
        if (packetId < 0 || packetId > 42) {
            throw new IllegalArgumentException("packetId must be between 0 and 42");
        }

        sensorPacket = SensorPacket.getSensorPacket(packetId).get();
        setCommand(new byte[] { (byte) OpCode.SENSOR.op(), packetId.byteValue() });
    }

    public int getLengthResponse() {
        return sensorPacket.numBytesResponse;
    }

    @Override
    public Optional<? extends SensorData> getResponse(byte[] response) {
        try {
            Constructor<? extends SensorData> responseConstructor = sensorPacket.responseClassType.getConstructor(String.class, byte[].class);
            return Optional.of(responseConstructor.newInstance(sensorPacket.packetName, response));
        } catch (Exception e) {
            throw new RuntimeException("This shouldn't have happened but if it did, contact me at emantos@gmail.com");
        }
    }
}
