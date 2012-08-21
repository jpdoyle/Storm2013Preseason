package storm2013.preseason.commands;

public class TankDrive extends CommandBase {
    public TankDrive() {
        requires(driveTrain);
    }

    protected void initialize() {}

    protected void execute() {
        driveTrain.drive(oi.getDriveLeftAxis(), oi.getDriveRightAxis());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {}

    protected void interrupted() {}
}
