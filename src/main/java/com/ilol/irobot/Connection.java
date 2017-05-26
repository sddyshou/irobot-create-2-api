package com.ilol.irobot;

public interface Connection {
  void open();

  void send(byte[] bytes);

  byte[] recv(int length);

  void close();
}
