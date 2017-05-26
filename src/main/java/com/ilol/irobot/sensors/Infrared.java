package com.ilol.irobot.sensors;

import com.google.common.base.Optional;
import com.ilol.irobot.enums.InfraredCharacter;

public class Infrared extends UnsignedByteData {
  public Infrared(String packetName, byte[] response) {
    super(packetName, response);
  }

  public Optional<InfraredCharacter> getInfraredByte() {
    return InfraredCharacter.getCharacter(getValue());
  }

  public String toString() {
    return String.format("[%s] = %s", getPacketName(), getInfraredByte()
        .orNull());
  }
}
