package com.ilol.irobot.impl;

import com.google.common.base.Optional;
import com.ilol.irobot.CommandExecutor;
import com.ilol.irobot.SensorData;
import com.ilol.irobot.enums.SensorPacket;
import com.ilol.irobot.sensors.Distance;

public class WaitDistanceCommand extends SingleCommand {
    private static final int WAIT_INTERVAL = 100;
    private short waitDistance;

    public WaitDistanceCommand(Short waitDistance) {
        this.waitDistance = waitDistance;
    }

    @Override
    public <K extends SensorData> Optional<K> execute(CommandExecutor commandExecutor) {
        SensorCommand distanceCommand = new SensorCommand(SensorPacket.DISTANCE.packetId);
        distanceCommand.execute(commandExecutor); // reset distance
        if (waitDistance == 0) {
            return Optional.absent();
        }
        short totalDistance = 0;
        while (true) {
            Optional<Distance> distance = distanceCommand.execute(commandExecutor);
            if (distance.isPresent()) {
                totalDistance += distance.get().getDistance();
                if ((totalDistance > 0 && waitDistance < 0) && (totalDistance < 0 && waitDistance > 0)) {
                    return Optional.absent();
                }
                if (waitDistance > 0) {
                    if (totalDistance >= waitDistance) {
                        return Optional.absent();
                    }
                } else {
                    if (totalDistance <= waitDistance) {
                        return Optional.absent();
                    }
                }
            } else {
                System.out.println("Distance data not available");
                return Optional.absent();
            }
            try {
                Thread.sleep(WAIT_INTERVAL);
            } catch (InterruptedException e) {
            }
        }
    }
}
