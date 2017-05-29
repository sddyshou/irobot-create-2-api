package com.ilol.irobot.impl;

import com.google.common.base.Optional;
import com.ilol.irobot.CommandExecutor;
import com.ilol.irobot.SensorData;
import com.ilol.irobot.enums.SensorPacket;
import com.ilol.irobot.sensors.Angle;

public class WaitAngleCommand extends SingleCommand {
    private static final long WAIT_INTERVAL = 50;
    private short waitAngle;

    public WaitAngleCommand(short waitAngle) {
        this.waitAngle = waitAngle;
    }

    @Override
    public <K extends SensorData> Optional<K> execute(CommandExecutor commandExecutor) {
        SensorCommand distanceCommand = new SensorCommand(SensorPacket.ANGLE.packetId);
        distanceCommand.execute(commandExecutor); // reset angle
        if (waitAngle == 0) {
            return Optional.absent();
        }
        short totalAngle = 0;
        while (true) {
            Optional<Angle> angle = distanceCommand.execute(commandExecutor);
            if (angle.isPresent()) {
                totalAngle += angle.get().getAngle();
                if ((totalAngle > 0 && waitAngle < 0) && (totalAngle < 0 && waitAngle > 0)) {
                    return Optional.absent();
                }
                if (waitAngle > 0) {
                    if (totalAngle >= waitAngle) {
                        return Optional.absent();
                    }
                } else {
                    if (totalAngle < waitAngle) {
                        return Optional.absent();
                    }
                }
            } else {
                System.out.println("Angle data not available");
                return Optional.absent();
            }
            try {
                Thread.sleep(WAIT_INTERVAL);
            } catch (InterruptedException e) {
            }
        }
    }

}
