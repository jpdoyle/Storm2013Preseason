package storm2013.preseason.commands;

public class SmoothTankDrive extends CommandBase {
    public static final double VALUE_SPEED_ACCELERATION = 1;
    public static final double VALUE_SPEED_DECELERATION = 1;
    
    private AccelerateToward accelerate_;
    
    public SmoothTankDrive() {
        accelerate_ = new AccelerateToward(0,0,VALUE_SPEED_ACCELERATION,VALUE_SPEED_DECELERATION);
    }

    protected void initialize() {
        accelerate_.start();
    }

    protected void execute() {
        accelerate_.setTarget(oi.getDriveLeftAxis(),oi.getDriveRightAxis());
    }

    protected boolean isFinished() {
        return !accelerate_.isRunning();
    }

    protected void end() {
        accelerate_.cancel();
    }

    protected void interrupted() {
        end();
    }
}
