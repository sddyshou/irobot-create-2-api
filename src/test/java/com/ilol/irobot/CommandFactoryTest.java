package com.ilol.irobot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ilol.irobot.enums.Baud;

public class CommandFactoryTest {

    @Test
    public void testBaudAndDemo() {
        Command command = CommandFactory.setBaud(Baud._300);
        byte[] comm = command.getCommand();
        assertTrue(comm[0] == (byte) 129);
        assertTrue(comm[1] == (byte) 0x00);

    }

    @Test
    public void testStartSafeFull() {
        Command command = CommandFactory.start();
        byte[] comm = command.getCommand();
        assertTrue(comm[0] == (byte) 128);

        command = CommandFactory.setSafe();
        comm = command.getCommand();
        assertTrue(comm[0] == (byte) 131);

        command = CommandFactory.setFull();
        comm = command.getCommand();
        assertTrue(comm[0] == (byte) 132);
    }

    @Test
    public void testDriveAndDriveDirect() {
        Command command = CommandFactory.drive((short) -200, (short) 500);
        byte[] comm = command.getCommand();
        assertTrue(comm[0] == (byte) 137);
        assertTrue(comm[1] == (byte) 0xff);
        assertTrue(comm[2] == (byte) 0x38);
        assertTrue(comm[3] == (byte) 0x01);
        assertTrue(comm[4] == (byte) 0xf4);

        command = CommandFactory.drive((short) 100, (short) 0);
        comm = command.getCommand();

        command = CommandFactory.driveDirect((short) -500, (short) 500);
        comm = command.getCommand();
        assertTrue(comm[0] == (byte) 145);
        assertTrue(comm[1] == (byte) 0xfe);
        assertTrue(comm[2] == (byte) 0x0c);
        assertTrue(comm[3] == (byte) 0x01);
        assertTrue(comm[4] == (byte) 0xf4);
    }

    @Test
    public void testLed() {
        Command command = CommandFactory.setLedDigits(1, 2, 3, 4);
        byte[] comm = command.getCommand();
        assertEquals((byte) 163, comm[0]);
        assertEquals((byte) 1, comm[1]);
        assertEquals((byte) 2, comm[2]);
        assertEquals((byte) 3, comm[3]);
        assertEquals((byte) 4, comm[4]);
    }

    @Test
    public void testPwmLowSide() {
        Command command = CommandFactory.setPwmLowSide(128, 128, 128);
        byte[] comm = command.getCommand();
        assertTrue(comm[0] == (byte) 144);
        assertTrue(comm[1] == (byte) 0x80);
        assertTrue(comm[1] == (byte) 0x80);
        assertTrue(comm[1] == (byte) 0x80);
    }

    @Test
    public void testLowSide() {
        Command command = CommandFactory.setLowSide(true, true, true);
        byte[] comm = command.getCommand();
        assertTrue(comm[0] == (byte) 138);
        assertTrue(comm[1] == (byte) 0x07);

        command = CommandFactory.setLowSide(true, false, false);
        comm = command.getCommand();
        assertTrue(comm[0] == (byte) 138);
        assertTrue(comm[1] == (byte) 0x01);

        command = CommandFactory.setLowSide(false, true, false);
        comm = command.getCommand();
        assertTrue(comm[0] == (byte) 138);
        assertTrue(comm[1] == (byte) 0x02);

        command = CommandFactory.setLowSide(false, false, true);
        comm = command.getCommand();
        assertTrue(comm[0] == (byte) 138);
        assertTrue(comm[1] == (byte) 0x04);

        command = CommandFactory.setLowSide(true, true, false);
        comm = command.getCommand();
        assertTrue(comm[0] == (byte) 138);
        assertTrue(comm[1] == (byte) 0x03);
    }

}
