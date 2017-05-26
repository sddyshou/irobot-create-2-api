package com.ilol.irobot.sensors;

import com.google.common.base.Optional;
import com.ilol.irobot.enums.OiMode;

public class OiModeData extends UnsignedByteData {
  public OiModeData(String packetName, byte[] response) {
    super(packetName, response);
  }

  public Optional<OiMode> getOiMode() {
    return OiMode.getOiMode(getValue());
  }
}
