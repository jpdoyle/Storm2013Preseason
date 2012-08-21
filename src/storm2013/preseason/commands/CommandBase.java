package storm2013.preseason.commands;

import edu.wpi.first.wpilibj.command.Command;
import storm2013.preseason.OI;
import storm2013.preseason.subsystems.DriveTrain;

public abstract class CommandBase extends Command {

    public static OI oi;
    public static DriveTrain driveTrain;

    public static void init() {
        oi = OI.getInstance();
        driveTrain = new DriveTrain();
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
