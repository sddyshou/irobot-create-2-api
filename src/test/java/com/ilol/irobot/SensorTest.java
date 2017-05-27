package com.ilol.irobot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ilol.irobot.enums.InfraredCharacter;
import com.ilol.irobot.impl.SingleCommand;
import com.ilol.irobot.sensors.BooleanData;
import com.ilol.irobot.sensors.FiveBitsData;
import com.ilol.irobot.sensors.Infrared;

public class SensorTest {
    @Test
    public void test() {
        SingleCommand command = CommandFactory.sensor(7);
        assertEquals(command.getLengthResponse(), 1);
    }

    @Test
    public void testFiveBitsData() {
        SingleCommand command = CommandFactory.sensor(7);
        command.getResponse(new byte[] { 0x01 }).get();
        FiveBitsData response = (FiveBitsData) command.getResponse(new byte[] { 0x01 }).get();
        assertEquals(response.getParameter(0), true);
        assertEquals(response.getParameter(1), false);
        assertEquals(response.getParameter(2), false);
        assertEquals(response.getParameter(3), false);
        assertEquals(response.getParameter(4), false);

        response = (FiveBitsData) command.getResponse(new byte[] { 0x02 }).get();
        assertEquals(response.getParameter(0), false);
        assertEquals(response.getParameter(1), true);
        assertEquals(response.getParameter(2), false);
        assertEquals(response.getParameter(3), false);
        assertEquals(response.getParameter(4), false);

        response = (FiveBitsData) command.getResponse(new byte[] { 0x03 }).get();
        assertEquals(response.getParameter(0), true);
        assertEquals(response.getParameter(1), true);
        assertEquals(response.getParameter(2), false);
        assertEquals(response.getParameter(3), false);
        assertEquals(response.getParameter(4), false);

        response = (FiveBitsData) command.getResponse(new byte[] { 0x10 }).get();
        assertEquals(response.getParameter(0), false);
        assertEquals(response.getParameter(1), false);
        assertEquals(response.getParameter(2), false);
        assertEquals(response.getParameter(3), false);
        assertEquals(response.getParameter(4), true);
    }

    @Test
    public void testBooleanData() {
        SingleCommand command = CommandFactory.sensor(8);
        BooleanData response = (BooleanData) command.getResponse(new byte[] { 0x00 }).get();
        assertTrue(response.getFlag().isPresent());
        assertEquals(response.getFlag().get(), false);

        response = (BooleanData) command.getResponse(new byte[] { 0x01 }).get();
        assertTrue(response.getFlag().isPresent());
        assertEquals(response.getFlag().get(), true);

        command = CommandFactory.sensor(10);
        response = (BooleanData) command.getResponse(new byte[] { 0x00 }).get();
        assertTrue(response.getFlag().isPresent());
        assertEquals(response.getFlag().get(), false);

        response = (BooleanData) command.getResponse(new byte[] { 0x01 }).get();
        assertTrue(response.getFlag().isPresent());
        assertEquals(response.getFlag().get(), true);
    }

    @Test
    public void testIr() {
        SingleCommand command = CommandFactory.sensor(17);
        Infrared response = (Infrared) command.getResponse(new byte[] { (byte) 0x81 }).get();
        assertEquals(response.getInfraredByte().get(), InfraredCharacter.LEFT);
    }
}
