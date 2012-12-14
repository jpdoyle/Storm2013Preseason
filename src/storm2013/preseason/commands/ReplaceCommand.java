/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package storm2013.preseason.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author ginto
 */
public class ReplaceCommand extends Command {
    Command newCommand_,oldCommand_;

    public ReplaceCommand(Command oldCommand,Command newCommand) {
        oldCommand_ = oldCommand;
        newCommand_ = newCommand;
    }

    protected void initialize() {
        oldCommand_.cancel();
        newCommand_.start();
    }

    protected void execute() {}

    protected boolean isFinished() {
        return !newCommand_.isRunning();
    }

    protected void end() {
        newCommand_.cancel();
        oldCommand_.start();
    }

    protected void interrupted() {
        end();
    }
    
}
