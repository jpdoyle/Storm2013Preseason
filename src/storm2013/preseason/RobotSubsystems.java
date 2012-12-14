/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package storm2013.preseason;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import storm2013.preseason.subsystems.DriveTrain;

/**
 *
 * @author ginto
 */
public class RobotSubsystems {
    private RobotSubsystems() {}
    
    private static RobotSubsystems instance_ = null;
    
    public static RobotSubsystems getInstance() {
        if(instance_ == null) {
            instance_ = new RobotSubsystems();
        }
        return instance_;
    }
    
    public void sendToDashboard() {
        SmartDashboard.putData(driveTrain);
    }
    
    public final DriveTrain driveTrain = new DriveTrain();
    public final OI oi = new OI(driveTrain);
}
