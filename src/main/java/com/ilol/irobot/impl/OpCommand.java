package com.ilol.irobot.impl;

import com.ilol.irobot.enums.OpCode;

public class OpCommand extends SingleCommand {
    public OpCommand(OpCode op) {
        setCommand(new byte[] { (byte) op.op() });
    }

    // an op code with an unsigned byte parameter
    public OpCommand(OpCode op, Integer parameter) {
        if (parameter > 255 || parameter < 0) {
            throw new IllegalArgumentException("parameter must be between 255 and 0");
        }

        setCommand(new byte[] { (byte) op.op(), (byte) parameter.intValue() });
    }

    // an op code with a signed byte parameter, since bytes in Java are signed.
    public OpCommand(OpCode op, Byte parameter) {
        setCommand(new byte[] { (byte) op.op(), parameter });
    }
}
