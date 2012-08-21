package storm2013.preseason.behaviors.teleop;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitForChildren;
import storm2013.preseason.commands.NullCommand;

/**
 *
 * @author joe
 */
public class TeleopTemplate extends CommandGroup {
    public TeleopTemplate() {
        addSequential(new NullCommand());
        addParallel(new NullCommand());
        addSequential(new NullCommand());
        addSequential(new WaitForChildren());
        addSequential(new NullCommand());
    }
}
