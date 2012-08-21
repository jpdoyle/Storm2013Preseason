package storm2013.preseason;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import storm2013.preseason.commands.CommandBase;
import storm2013.preseason.commands.NullCommand;

public class Robot extends IterativeRobot {
    Scheduler scheduler;
    Command autonomousCommand,teleopCommand;

    public void robotInit() {
        scheduler = Scheduler.getInstance();
        
        CommandBase.init();
        
        autonomousCommand = new NullCommand();
        teleopCommand     = new NullCommand();
    }

    public void autonomousInit() {
        teleopCommand.cancel();
        autonomousCommand.start();
    }

    public void autonomousPeriodic() {
        scheduler.run();
    }

    public void teleopInit() {
        autonomousCommand.cancel();
        teleopCommand.start();
    }

    public void teleopPeriodic() {
        scheduler.run();
    }

    public void disabledInit() {
        teleopCommand.cancel();
        autonomousCommand.cancel();
    }

    public void disabledPeriodic() {
        Timer.delay(0.1);
    }

    public void autonomousContinuous() {
        m_ds.waitForData();
    }

    public void disabledContinuous() {
        m_ds.waitForData();
    }

    public void teleopContinuous() {
        m_ds.waitForData();
    }
}
