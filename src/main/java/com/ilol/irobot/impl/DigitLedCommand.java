package com.ilol.irobot.impl;

import com.ilol.irobot.enums.OpCode;

public class DigitLedCommand extends SingleCommand {

    public DigitLedCommand(Integer i1, Integer i2, Integer i3, Integer i4) {
        int[] command = new int[5];
        command[0] = OpCode.LED_DIGIT.op();
        command[1] = check(i1);
        command[2] = check(i2);
        command[3] = check(i3);
        command[4] = check(i4);
        setCommand(command);
    }

    private int check(Integer digit) {
        if (digit < 0 || digit > 10) {
            throw new IllegalArgumentException("LED digit need to in range of [0, 10], the value is " + digit);
        }
        return digit.intValue();
    }
}
