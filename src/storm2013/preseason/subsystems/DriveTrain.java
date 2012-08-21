package storm2013.preseason.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import storm2013.preseason.RobotMap;
import storm2013.preseason.commands.SmoothTankDrive;

public class DriveTrain extends Subsystem {
    public static final String KEY_LEFT_SPEED  = "leftMotorSpeed";
    public static final String KEY_RIGHT_SPEED = "rightMotorSpeed";
    public static final String KEY_DRIVE_GEAR  = "gear";

    private final SpeedController leftMotor_  = new Victor(RobotMap.PORT_MOTOR_DRIVE_LEFT),
                                  rightMotor_ = new Victor(RobotMap.PORT_MOTOR_DRIVE_RIGHT);

    private final RobotDrive drive_ = new RobotDrive(leftMotor_, rightMotor_);

    private final Solenoid highGear_ = new Solenoid(RobotMap.PORT_SOLENOID_HIGH_GEAR),
                           lowGear_  = new Solenoid(RobotMap.PORT_SOLENOID_LOW_GEAR);

    // DOES NOT call drive_.setInvertedMotor() because it would only affect
    // output, and therefore cannot be used in accelerateToward(). Instead,
    // everything to do with the right gets negated manually.
    public DriveTrain() {
        highGear_.set(false);
        lowGear_.set(true);
        updateTable();
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new SmoothTankDrive());
    }

    public void drive(double left,double right) {
        drive_.tankDrive(left, -right);
        updateTable();
    }
    
    public double getLeftSpeed() {
        return leftMotor_.get();
    }
    
    public double getRightSpeed() {
        return -rightMotor_.get();
    }

    public void setHighGear(boolean highGear) {
        highGear_.set(highGear);
        lowGear_.set(!highGear);
        updateTable();
    }

    public void toggleGear() {
        setHighGear(!isHighGear());
    }

    public boolean isHighGear() {
        return highGear_.get();
    }
    
    boolean tableInUse = false;

    private void updateTable() {
        if(!tableInUse)
            return;
        NetworkTable table = super.getTable();

        table.putDouble(KEY_LEFT_SPEED, leftMotor_.get());
        table.putDouble(KEY_RIGHT_SPEED, -rightMotor_.get());
        table.putString(KEY_DRIVE_GEAR, highGear_.get() ? "High" : "Low");
    }

    public NetworkTable getTable() {
        tableInUse = true;
        updateTable();
        return super.getTable();
    }
}
