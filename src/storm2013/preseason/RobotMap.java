package storm2013.preseason;

public class RobotMap {
    // Motors
    public static final int PORT_MOTOR_DRIVE_LEFT         = 8;
    public static final int PORT_MOTOR_DRIVE_RIGHT        = 3;
    public static final int PORT_MOTOR_SHOOTER_WHEEL      = 5;
    public static final int PORT_MOTOR_3BA                = 10;
    public static final int PORT_MOTOR_BRIDGE_MANIPULATOR = 1;
    public static final int PORT_MOTOR_KANAYERBELT_FEEDER = 4;
    public static final int PORT_MOTOR_KANAYERBELT_BOTTOM = 6;
    public static final int PORT_MOTOR_KANAYERBELT_TOP    = 9;

    // Sensors
    public static final int PORT_IR_BALL_IN_1             = 6;
    public static final int PORT_IR_BALL_IN_2             = 7;
    public static final int PORT_IR_BALL_READY            = 9;
    public static final int PORT_LIMIT_SWITCH_3BA_TOP     = 10;
    public static final int PORT_LIMIT_SWITCH_3BA_BOTTOM  = 8;

    // Gyro
    public static final int PORT_GYRO_ROBOT_ROTATION = 1;

    // Encoders
    public static final int PORT_ENCODER_DRIVE_LEFT_A         = 1;
    public static final int PORT_ENCODER_DRIVE_LEFT_B         = 2;
    public static final int PORT_ENCODER_DRIVE_LEFT_A_BACKUP  = 1;
    public static final int PORT_ENCODER_DRIVE_LEFT_B_BACKUP  = 2;
    public static final int PORT_ENCODER_DRIVE_RIGHT_A        = 3;
    public static final int PORT_ENCODER_DRIVE_RIGHT_B        = 4;
    public static final int PORT_ENCODER_DRIVE_RIGHT_A_BACKUP = 3;
    public static final int PORT_ENCODER_DRIVE_RIGHT_B_BACKUP = 4;
    public static final int PORT_ENCODER_SHOOTER_SPEED        = 5;
    public static final int PORT_ENCODER_BRIDGE_MANIPULATOR   = 2; // <-- ANALOG

    // Solenoids
    public static final int PORT_SOLENOID_HIGH_GEAR = 1;
    public static final int PORT_SOLENOID_LOW_GEAR  = 2;

    //Analog Channels
    public static final int PORT_SWITCH_HYBRID_TYPE = 3;

    //Compressor Info
    public static final int PORT_COMPRESSOR_RELAY           = 1;
    public static final int PORT_COMPRESSOR_PRESSURE_SWITCH = 14;
}
