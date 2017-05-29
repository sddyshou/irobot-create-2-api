package com.ilol.irobot;

import com.ilol.irobot.enums.Baud;
import com.ilol.irobot.enums.OpCode;
import com.ilol.irobot.impl.BaudCommand;
import com.ilol.irobot.impl.DriveCommand;
import com.ilol.irobot.impl.DigitLedCommand;
import com.ilol.irobot.impl.LowSideDriver;
import com.ilol.irobot.impl.OpCommand;
import com.ilol.irobot.impl.SensorCommand;
import com.ilol.irobot.impl.SingleCommand;

public class CommandFactory {
    public static SingleCommand start() {
        return new OpCommand(OpCode.START);
    }

    public static SingleCommand setSafe() {
        return new OpCommand(OpCode.SAFE);
    }

    public static SingleCommand setFull() {
        return new OpCommand(OpCode.FULL);
    }

    public static SingleCommand setBaud(Baud baud) {
        return new BaudCommand(baud);
    }

    public static SingleCommand drive(short velocity, short radius) {
        return DriveCommand.getDrive(velocity, radius);
    }

    public static SingleCommand driveDirect(short velocityLeft, short velocityRight) {
        return DriveCommand.getDriveDirect(velocityLeft, velocityRight);
    }

    public static SingleCommand setLedDigits(Integer i1, Integer i2, Integer i3, Integer i4) {
        return new DigitLedCommand(i1, i2, i3, i4);
    }

    public static SingleCommand setPwmLowSide(int dutyCycle0, int dutyCycle1, int dutyCycle2) {
        return new LowSideDriver(dutyCycle0, dutyCycle1, dutyCycle2);
    }

    public static SingleCommand setLowSide(boolean driver0, boolean driver1, boolean driver2) {
        return new LowSideDriver(driver0, driver1, driver2);
    }

    public static SensorCommand sensor(int packetId) {
        return new SensorCommand(packetId);
    }
}
