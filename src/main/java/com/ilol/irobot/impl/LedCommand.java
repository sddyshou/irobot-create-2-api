package com.ilol.irobot.impl;

import com.ilol.irobot.enums.OpCode;

public class LedCommand extends AbstractCommand {
  public LedCommand(Boolean play, Boolean advance, Integer powerColor,
      Integer powerIntensity) {
    if ((powerColor > 255 || powerColor < 0)
        || (powerIntensity > 255 || powerIntensity < 0)) {
      throw new IllegalArgumentException();
    }

    byte led1 = 0x00;
    if (play) {
      led1 = (byte) (led1 | 0x02);
    }
    if (advance) {
      led1 = (byte) (led1 | 0x08);
    }
    byte[] command = new byte[] { (byte) OpCode.LED.op(), led1,
        (byte) powerColor.intValue(), (byte) powerIntensity.intValue() };
    for (byte b : command) {
        System.out.println((int)b);
    }
    setCommand(command);
  }
}
