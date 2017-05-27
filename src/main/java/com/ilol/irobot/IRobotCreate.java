package com.ilol.irobot;

import com.google.common.base.Optional;
import com.ilol.irobot.impl.ChainedCommand;

public class IRobotCreate {

    private Connection connection;

    public IRobotCreate(Connection connection) {
        this.connection = connection;
    }

    public void init() {
        connection.open();
    }

    public Optional<? extends SensorData> execute(Command command) {
        return command.execute(connection);
    }

//    private Optional<SensorData> getResponse(Command command) {
//        if (command.isExpectResponse()) {
//            byte[] response = connection.recv(command.getLengthResponse());
//            if (response != null && response.length == command.getLengthResponse()) {
//                return Optional.of(command.getResponse(response));
//            } else {
//                throw new RuntimeException("Response is null or not of expected length.");
//            }
//        }
//
//        return Optional.absent();
//    }

    public void shutdown() {
        connection.close();
    }
}
