package com.ilol.irobot.enums;

public enum OpCode {
    START(128),
    BAUD(129),
    SAFE(131),
    FULL(132),
    STOP(173),
    RESET(7),
    SPOT(134),
    DRIVE(137),
    DRIVE_DIRECT(145),
    LED_DIGIT(163),
    PWM(144),
    LOW_SIDE_DRIVER(138),
    SONG(140),
    PLAY_SONG(141),
    SENSOR(142),
    QUERY_LIST(149),
    STREAM(148),
    PAUSE_RESUME_STREAM(150);

    private int opCode;

    OpCode(int opCode) {
        this.opCode = opCode;
    }

    public int op() {
        return opCode;
    }
}
