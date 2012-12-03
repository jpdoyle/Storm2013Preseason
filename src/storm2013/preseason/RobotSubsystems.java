/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package storm2013.preseason;

import storm2013.preseason.subsystems.DriveTrain;

/**
 *
 * @author ginto
 */
public class RobotSubsystems {
    private RobotSubsystems() {}
    
    public static OI oi;
    public static DriveTrain driveTrain;
    
    public static void init() {
        oi = OI.getInstance();
        driveTrain = DriveTrain.getInstance();
    }
}
