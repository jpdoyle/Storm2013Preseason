package storm2013.preseason.commands;

/**
 *
 * @author joe
 */
public class NullCommand extends CommandBase {
    protected void initialize() {}

    protected void execute() {}

    protected boolean isFinished() {
        return true;
    }

    protected void end() {}
    
    protected void interrupted() {}
}
