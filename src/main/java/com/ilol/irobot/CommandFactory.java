package com.ilol.irobot;

import com.ilol.irobot.enums.Baud;
import com.ilol.irobot.enums.Event;
import com.ilol.irobot.enums.OpCode;
import com.ilol.irobot.impl.BaudCommand;
import com.ilol.irobot.impl.DigitalOutputCommand;
import com.ilol.irobot.impl.DriveCommand;
import com.ilol.irobot.impl.LedCommand;
import com.ilol.irobot.impl.LowSideDriver;
import com.ilol.irobot.impl.OpCommand;
import com.ilol.irobot.impl.SensorCommand;
import com.ilol.irobot.impl.WaitCommand;

public class CommandFactory {
  public static Command start() {
    return new OpCommand(OpCode.START);
  }

  public static Command setSafe() {
    return new OpCommand(OpCode.SAFE);
  }

  public static Command setFull() {
    return new OpCommand(OpCode.FULL);
  }

  public static Command setBaud(Baud baud) {
    return new BaudCommand(baud);
  }

  public static Command drive(short velocity, short radius) {
    return DriveCommand.getDrive(velocity, radius);
  }

  public static Command driveDirect(short velocityLeft, short velocityRight) {
    return DriveCommand.getDriveDirect(velocityLeft, velocityRight);
  }

  public static Command setLed(boolean play, boolean advance, int powerColor,
      int powerIntensity) {
    return new LedCommand(play, advance, powerColor, powerIntensity);
  }

  public static Command setDigitalOutput(boolean pin20, boolean pin7,
      boolean pin19) {
    return new DigitalOutputCommand(pin20, pin7, pin19);
  }

  public static Command setPwmLowSide(int dutyCycle0, int dutyCycle1,
      int dutyCycle2) {
    return new LowSideDriver(dutyCycle0, dutyCycle1, dutyCycle2);
  }

  public static Command setLowSide(boolean driver0, boolean driver1,
      boolean driver2) {
    return new LowSideDriver(driver0, driver1, driver2);
  }

  public static Command sendIR(int byteToSend) {
    return new OpCommand(OpCode.SEND_IR, byteToSend);
  }

  public static Command waitTime(int timeToWait) {
    return new OpCommand(OpCode.WAIT_TIME, timeToWait);
  }

  public static Command waitDistance(short distance) {
    return WaitCommand.waitDistance(distance);
  }

  public static Command waitAngle(short angle) {
    return WaitCommand.waitAngle(angle);
  }

  public static Command waitEvent(Event event) {
    return new OpCommand(OpCode.WAIT_EVENT, event.byteEquivalent);
  }

  public static Command sensor(int packetId) {
    return new SensorCommand(packetId);
  }
}
