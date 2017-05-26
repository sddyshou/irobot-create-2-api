package com.ilol.irobot.impl;

import com.ilol.irobot.enums.OpCode;

public class MoveToCommand extends AbstractCompositeCommand {
  public MoveToCommand(Short distance, Short velocity) {
    if (((distance < 0) && (velocity > 0))
        || ((distance > 0) && (velocity < 0))) {
      throw new IllegalArgumentException(
          "Illegal distance and velocity values. Will cause infinite loop.");
    }

    setCommand(DriveCommand.straight(velocity), new WaitCommand(
        OpCode.WAIT_DISTANCE, distance), DriveCommand.stop());
  }
}
