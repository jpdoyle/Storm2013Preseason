package storm2013.preseason;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import storm2013.preseason.commands.NullCommand;

public class Robot extends IterativeRobot {
    Scheduler scheduler;
    Command autonomousCommand,teleopCommand;

    public void robotInit() {
        scheduler = Scheduler.getInstance();
        
        RobotSubsystems.getInstance();
        
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

    public void disabledPeriodic() {}

    public void autonomousContinuous() {
        // Wait for data from the driver station
        // This prevents continuous from using 100% CPU, while also preventing 
        // the default continuous functions from yelling at us for not
        // implementing them
        m_ds.waitForData();
    }

    public void disabledContinuous() {
        m_ds.waitForData();
    }

    public void teleopContinuous() {
        m_ds.waitForData();
    }
}
