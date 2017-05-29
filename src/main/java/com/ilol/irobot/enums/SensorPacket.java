package com.ilol.irobot.enums;

import com.google.common.base.Optional;
import com.ilol.irobot.SensorData;
import com.ilol.irobot.sensors.Angle;
import com.ilol.irobot.sensors.BatteryCapacity;
import com.ilol.irobot.sensors.BatteryCharge;
import com.ilol.irobot.sensors.BatteryTemperature;
import com.ilol.irobot.sensors.BooleanData;
import com.ilol.irobot.sensors.BumpsWheelDrops;
import com.ilol.irobot.sensors.Buttons;
import com.ilol.irobot.sensors.CargoBayAnalogSignal;
import com.ilol.irobot.sensors.CargoBayDigitalInputs;
import com.ilol.irobot.sensors.ChargingSourcesAvailable;
import com.ilol.irobot.sensors.CliffSignal;
import com.ilol.irobot.sensors.Current;
import com.ilol.irobot.sensors.CurrentChargingState;
import com.ilol.irobot.sensors.Distance;
import com.ilol.irobot.sensors.GroupPacket0;
import com.ilol.irobot.sensors.GroupPacket1;
import com.ilol.irobot.sensors.GroupPacket2;
import com.ilol.irobot.sensors.GroupPacket3;
import com.ilol.irobot.sensors.GroupPacket4;
import com.ilol.irobot.sensors.GroupPacket5;
import com.ilol.irobot.sensors.GroupPacket6;
import com.ilol.irobot.sensors.Infrared;
import com.ilol.irobot.sensors.LowSideDriverWheelOvercurrent;
import com.ilol.irobot.sensors.OiModeData;
import com.ilol.irobot.sensors.RequestedRadius;
import com.ilol.irobot.sensors.RequestedVelocity;
import com.ilol.irobot.sensors.UnsignedByteData;
import com.ilol.irobot.sensors.Voltage;
import com.ilol.irobot.sensors.WallSignal;

public enum SensorPacket {
    GROUP_PACKET_0(0, "Group Packet 0", 26, GroupPacket0.class),
    GROUP_PACKET_1(1, "Group Packet 1", 10, GroupPacket1.class),
    GROUP_PACKET_2(2, "Group Packet 2", 6, GroupPacket2.class),
    GROUP_PACKET_3(3, "Group Packet 3", 10, GroupPacket3.class),
    GROUP_PACKET_4(4, "Group Packet 4", 14, GroupPacket4.class),
    GROUP_PACKET_5(5, "Group Packet 5", 12, GroupPacket5.class),
    GROUP_PACKET_6(6, "Group Packet 6", 52, GroupPacket6.class),
    BUMPS_WHEEL_DROPS(7, "Bumps & Wheels Drops", 1, BumpsWheelDrops.class),
    WALL(8, "Wall", 1, BooleanData.class),
    CLIFF_LEFT(9, "Cliff Left", 1, BooleanData.class),
    CLIFF_RIGHT(12, "Cliff Right", 1, BooleanData.class),
    CLIFF_FRONT_LEFT(10, "Cliff Front Left", 1, BooleanData.class),
    CLIFF_FRONT_RIGHT(11, "Cliff Front Right", 1, BooleanData.class),
    VIRTUAL_WALL(13, "Virtual Wall", 1, BooleanData.class),
    LOW_SIDE_DRIVER_OVERCURRENTS(14, "Low Side Driver and Wheel Overcurrents", 1, LowSideDriverWheelOvercurrent.class),
    INFRARED_BYTE(17, "Infrared Byte", 1, Infrared.class),
    BUTTONS(18, "Buttons", 1, Buttons.class),
    DISTANCE(19, "Distance", 2, Distance.class),
    ANGLE(20, "Angle", 2, Angle.class),
    CHARGING_STATE(21, "Current Charging State", 1, CurrentChargingState.class),
    VOLTAGE(22, "Voltage", 2, Voltage.class),
    CURRENT(23, "Current", 2, Current.class),
    BATTERY_TEMPERATURE(24, "Battery Temperature", 1, BatteryTemperature.class),
    BATTERY_CHARGE(25, "Battery Charge", 2, BatteryCharge.class),
    BATTERY_CAPACITY(26, "Battery Capacity", 2, BatteryCapacity.class),
    WALL_SIGNAL(27, "Wall Signal", 2, WallSignal.class),
    CLIFF_LEFT_SIGNAL(28, "Cliff Left Signal", 2, CliffSignal.class),
    CLIFF_FRONT_LEFT_SIGNAL(29, "Cliff Front Left Signal", 2, CliffSignal.class),
    CLIFF_FRONT_RIGHT_SIGNAL(30, "Cliff Front Right Signal", 2, CliffSignal.class),
    CLIFF_RIGHT_SIGNAL(31, "Cliff Right Signal", 2, CliffSignal.class),
    CARGO_BAY_DIGITAL_INPUTS(32, "Cargo Bay Digital Inputs", 1, CargoBayDigitalInputs.class),
    CARGO_BAY_ANALOG_SIGNAL(33, "Cargo Bay Analog Signal", 2, CargoBayAnalogSignal.class),
    CHARGING_SOURCES_AVAILABLE(34, "Charging Sources Available", 1, ChargingSourcesAvailable.class),
    OI_MODE(35, "OI Mode", 1, OiModeData.class),
    SONG_NUMBER(36, "Song Number", 1, UnsignedByteData.class),
    SONG_PLAYING(37, "Song Playing", 1, UnsignedByteData.class),
    NUM_STREAM_PACKETS(38, "Number of Stream Packets", 1, UnsignedByteData.class),
    REQUESTED_VELOCITY(39, "Requested Velocity", 2, RequestedVelocity.class),
    REQUESTED_RADIUS(40, "Request Radius", 2, RequestedRadius.class),
    REQUESTED_RIGHT_VELOCITY(41, "Requested Right Velocity", 2, RequestedVelocity.class),
    REQUESTED_LEFT_VELOCITY(42, "Requested Left Velocity", 2, RequestedVelocity.class);

    public int numBytesResponse;
    public int packetId;
    public String packetName;
    public Class<? extends SensorData> responseClassType;

    SensorPacket(int packetId, String packetName, int numBytesResponse, Class<? extends SensorData> responseClassType) {
        this.packetId = packetId;
        this.packetName = packetName;
        this.numBytesResponse = numBytesResponse;
        this.responseClassType = responseClassType;
    }

    public static Optional<SensorPacket> getSensorPacket(int packetId) {
        for (SensorPacket packet : SensorPacket.values()) {
            if (packetId == packet.packetId) {
                return Optional.of(packet);
            }
        }

        return Optional.absent();
    }
}
