/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package storm2013.preseason.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author ginto
 */
public class ReplaceSubsystemCommand extends ReplaceCommand {
    Subsystem subsystem_;
    
    public ReplaceSubsystemCommand(Subsystem subsystem,Command newCommand) {
        super(null,newCommand);
        subsystem_ = subsystem;
    }
    
    protected void initialize() {
        super.oldCommand_ = subsystem_.getCurrentCommand();
        super.initialize();
    }
}
