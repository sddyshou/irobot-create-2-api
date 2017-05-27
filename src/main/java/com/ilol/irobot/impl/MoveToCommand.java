package com.ilol.irobot.impl;

public class MoveToCommand extends AbstractCompositeCommand {
    public MoveToCommand(Short distance, Short velocity) {
        if (((distance < 0) && (velocity > 0)) || ((distance > 0) && (velocity < 0))) {
            throw new IllegalArgumentException("Illegal distance and velocity values. Will cause infinite loop.");
        }
        // TODO:
//        setCommand(DriveCommand.straight(velocity), new WaitCommand(OpCode.WAIT_DISTANCE, distance), DriveCommand.stop());
    }
}
