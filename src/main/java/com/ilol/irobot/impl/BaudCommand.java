package com.ilol.irobot.impl;

import com.ilol.irobot.enums.Baud;
import com.ilol.irobot.enums.OpCode;

public class BaudCommand extends AbstractCommand {
    public BaudCommand(Baud baud) {
        setCommand(new byte[] { (byte) OpCode.BAUD.op(), (byte) baud.getBaudCode() });
    }

    public BaudCommand(Integer parameter) {
        setCommand(new byte[] { (byte) OpCode.BAUD.op(), (byte) Baud.getBaud(parameter).or(Baud._115200).getBaudCode() });
    }
}
