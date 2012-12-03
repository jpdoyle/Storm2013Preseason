package storm2013.preseason.commands;

import edu.wpi.first.wpilibj.command.Command;
import storm2013.preseason.OI;
import storm2013.preseason.RobotSubsystems;
import storm2013.preseason.subsystems.DriveTrain;

public class TankDrive extends Command {
    private DriveTrain driveTrain_ = RobotSubsystems.driveTrain;
    private OI oi_ = RobotSubsystems.oi;
    
    public TankDrive() {
        requires(driveTrain_);
    }

    protected void initialize() {}

    protected void execute() {
        driveTrain_.drive(oi_.getDriveLeftAxis(), oi_.getDriveRightAxis());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {}

    protected void interrupted() {}
}
