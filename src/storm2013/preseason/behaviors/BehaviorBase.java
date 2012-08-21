package storm2013.preseason.behaviors;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import storm2013.preseason.commands.CommandBase;

/**
 * Base class for "behaviors" - series of commands, possibly for autonomous/teleop
 * @author joe
 */
public class BehaviorBase extends CommandBase {
    
    private CommandGroup group_ = new CommandGroup();
    
    public BehaviorBase() {}
    
    protected void addSequential(Command c) {
        group_.addSequential(c);
    }
    protected void addSequential(Command c,double timeout) {
        group_.addSequential(c,timeout);
    }
    protected void addParallel(Command c) {
        group_.addSequential(c);
    }
    protected void addParallel(Command c,double timeout) {
        group_.addSequential(c,timeout);
    }

    protected void initialize() {
        group_.start();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return !group_.isRunning();
    }

    protected void end() {
        group_.cancel();
    }

    protected void interrupted() {
        end();
    }
    
}
