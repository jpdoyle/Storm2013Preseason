package storm2013.preseason;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import storm2013.preseason.commands.ReplaceCommand;
import storm2013.preseason.commands.ReplaceSubsystemCommand;
import storm2013.preseason.commands.SmoothTankDrive;
import storm2013.preseason.commands.TankDrive;
import storm2013.preseason.subsystems.DriveTrain;

public class OI {
    // Joysticks
    public static final int PORT_JOYSTICK_DRIVE = 1;
    public static final int PORT_JOYSTICK_SHOOT = 2;

    // Joystick Axiseses
    public static final int AXIS_JOYSTICK_DRIVE_LEFT               = 2;
    public static final int AXIS_JOYSTICK_DRIVE_RIGHT              = 4;
    public static final int AXIS_JOYSTICK_DRIVE_BOTH               = 6;
    public static final int AXIS_JOYSTICK_SHOOT_3BA                = 2;
    public static final int AXIS_JOYSTICK_SHOOT_BRIDGE_MANIPULATOR = 4;
    public static final int AXIS_JOYSTICK_SHOOT_ELEVATOR           = 6;

    // Joystick Buttons
    public static final int BUTTON_JOYSTICK_DRIVE_SWITCH_GEARS    = 5;
    public static final int BUTTON_JOYSTICK_DRIVE_SPEED_MODIFIER  = 6;
    public static final int BUTTON_JOYSTICK_DRIVE_DIRECT_DRIVE    = 8;
    public static final int BUTTON_JOYSTICK_SHOOT_DECREASE_OFFSET = 1;
    public static final int BUTTON_JOYSTICK_SHOOT_RESET_OFFSET    = 2;
    public static final int BUTTON_JOYSTICK_SHOOT_INCREASE_OFFSET = 3;
    public static final int BUTTON_JOYSTICK_SHOOT_TOGGLE_SHOOTER  = 5;
    public static final int BUTTON_JOYSTICK_SHOOT_SHOOT           = 6;
    public static final int BUTTON_JOYSTICK_SHOOT_3BA_SAFETY      = 7;
    public static final int BUTTON_JOYSTICK_SHOOT_PRESHOOT        = 8;
    public static final int BUTTON_JOYSTICK_SHOOT_WARMUP_SHOOTER  = 4;

    
    private final Joystick joystickDrive_ = new Joystick(PORT_JOYSTICK_DRIVE),
                           joystickShoot_ = new Joystick(PORT_JOYSTICK_SHOOT);
    private final JoystickButton buttonSpeedModifier_ = 
                                    new JoystickButton(joystickDrive_, BUTTON_JOYSTICK_DRIVE_SPEED_MODIFIER),
                                 buttonDirectDrive_ =
                                    new JoystickButton(joystickDrive_, BUTTON_JOYSTICK_DRIVE_DIRECT_DRIVE);

    public OI(final DriveTrain driveTrain) {
        buttonSpeedModifier_.whileHeld(new Command() {
            protected void initialize() {
                driveTrain.setLowSpeed(true);
            }

            protected void execute() {}

            protected boolean isFinished() {
                return false;
            }

            protected void end() {
                driveTrain.setLowSpeed(true);
            }

            protected void interrupted() {
                end();
            }
        });
        buttonDirectDrive_.whileHeld(new ReplaceSubsystemCommand(driveTrain,
                                                                 new TankDrive()));
    }

    private double correctForDeadzone_(double axisValue) {
        return Math.abs(axisValue) < 0.2 ? 0.0 : axisValue;
    }

    public double getDriveLeftAxis() {
        double both = -correctForDeadzone_(joystickDrive_.getRawAxis(AXIS_JOYSTICK_DRIVE_BOTH));
        if(both != 0) {
            return both;
        }
        return -correctForDeadzone_(joystickDrive_.getRawAxis(AXIS_JOYSTICK_DRIVE_LEFT));
    }
    public double getDriveRightAxis() {
        double both = -correctForDeadzone_(joystickDrive_.getRawAxis(AXIS_JOYSTICK_DRIVE_BOTH));
        if(both > 0) {
            return both;
        }
        return -correctForDeadzone_(joystickDrive_.getRawAxis(AXIS_JOYSTICK_DRIVE_RIGHT));
    }

    public double get3baAxis() {
        return -correctForDeadzone_(joystickShoot_.getRawAxis(AXIS_JOYSTICK_SHOOT_3BA));
    }
    public double getBridgeManipulatorAxis() {
        return -correctForDeadzone_(joystickShoot_.getRawAxis(AXIS_JOYSTICK_SHOOT_BRIDGE_MANIPULATOR));
    }
    public double getElevatorAxis() {
        return -correctForDeadzone_(joystickShoot_.getRawAxis(AXIS_JOYSTICK_SHOOT_ELEVATOR));
    }
}

