package com.ilol.irobot;

import com.google.common.base.Optional;

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

    public void shutdown() {
        connection.close();
    }
}
