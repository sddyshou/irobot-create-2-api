package com.ilol.irobot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ilol.irobot.enums.InfraredCharacter;
import com.ilol.irobot.impl.SensorCommand;
import com.ilol.irobot.impl.SingleCommand;
import com.ilol.irobot.sensors.BooleanData;
import com.ilol.irobot.sensors.FiveBitsData;
import com.ilol.irobot.sensors.Infrared;

public class SensorTest {

    @Test
    public void testFiveBitsData() {
        SensorCommand command = CommandFactory.sensor(7);

        FiveBitsData response = command.getResponse(new byte[] { 0x01 });
        assertEquals(response.getParameter(0), true);
        assertEquals(response.getParameter(1), false);
        assertEquals(response.getParameter(2), false);
        assertEquals(response.getParameter(3), false);
        assertEquals(response.getParameter(4), false);

        response = command.getResponse(new byte[] { 0x02 });
        assertEquals(response.getParameter(0), false);
        assertEquals(response.getParameter(1), true);
        assertEquals(response.getParameter(2), false);
        assertEquals(response.getParameter(3), false);
        assertEquals(response.getParameter(4), false);

        response = command.getResponse(new byte[] { 0x03 });
        assertEquals(response.getParameter(0), true);
        assertEquals(response.getParameter(1), true);
        assertEquals(response.getParameter(2), false);
        assertEquals(response.getParameter(3), false);
        assertEquals(response.getParameter(4), false);

        response = command.getResponse(new byte[] { 0x10 });
        assertEquals(response.getParameter(0), false);
        assertEquals(response.getParameter(1), false);
        assertEquals(response.getParameter(2), false);
        assertEquals(response.getParameter(3), false);
        assertEquals(response.getParameter(4), true);
    }

    @Test
    public void testBooleanData() {
        SensorCommand command = CommandFactory.sensor(8);
        BooleanData response = command.getResponse(new byte[] { 0x00 });
        assertTrue(response.getFlag().isPresent());
        assertEquals(response.getFlag().get(), false);

        response = command.getResponse(new byte[] { 0x01 });
        assertTrue(response.getFlag().isPresent());
        assertEquals(response.getFlag().get(), true);

        command = CommandFactory.sensor(10);
        response = command.getResponse(new byte[] { 0x00 });
        assertTrue(response.getFlag().isPresent());
        assertEquals(response.getFlag().get(), false);

        response = command.getResponse(new byte[] { 0x01 });
        assertTrue(response.getFlag().isPresent());
        assertEquals(response.getFlag().get(), true);
    }

    @Test
    public void testIr() {
        SensorCommand command = CommandFactory.sensor(17);
        Infrared response = command.getResponse(new byte[] { (byte) 0x81 });
        assertEquals(response.getInfraredByte().get(), InfraredCharacter.LEFT);
    }
}
