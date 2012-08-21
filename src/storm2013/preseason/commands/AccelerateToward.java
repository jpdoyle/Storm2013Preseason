package storm2013.preseason.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author joe
 */
public class AccelerateToward extends CommandBase {
    
    private double left_ = 0,right_ = 0;
    private double accelRate_ = 1,decelRate_ = 1;
    private Timer time_ = new Timer();
    
    public AccelerateToward() {}
    
    public AccelerateToward(double left,double right,double accelRate,double decelRate) {
        left_ = left;
        right_ = right;
        accelRate_ = accelRate;
        decelRate_ = decelRate;
        time_ = new Timer();
        requires(driveTrain);
    }
    
    public void setTargetRight(double right) {
        right_ = right;
    }
    public void setTargetLeft(double left) {
        left_ = left;
    }
    public void setTarget(double left,double right) {
        left_ = left;
        right_ = right;
    }
    public void setAccelRate(double accel) {
        accelRate_ = accel;
    }
    public void setDecelRate(double decel) {
        decelRate_ = decel;
    }
    public void setRate(double accel,double decel) {
        accelRate_ = accel;
        decelRate_ = decel;
    }
    
    public double getTargetRight() {
        return right_;
    }
    public double getTargetLeft() {
        return left_;
    }
    public double getUpRate() {
        return accelRate_;
    }
    public double getDownRate() {
        return decelRate_;
    }

    protected void initialize() {
        time_.start();
        time_.reset();
    }
    protected void execute() {
        double dt = time_.get()/1000;
        time_.reset();
        
        double currLeftSpeed  = driveTrain.getLeftSpeed(),
               currRightSpeed = driveTrain.getRightSpeed();
        
        // Determine required rate - takes account for negative being backward
        // so that it always accelerates at accelRate/sec and always decelerates
        // at decelRate/sec regardless of direction.
        double dLeft  = (currLeftSpeed < left_ && left_ <= 0) ? -accelRate_ :
                        (currLeftSpeed > left_ && left_ >= 0) ? accelRate_  :
                        (currLeftSpeed > 0) ? -decelRate_ : decelRate_,
               dRight = (currRightSpeed < right_ && right_ <= 0) ? -accelRate_ :
                        (currRightSpeed > right_ && right_ >= 0) ? accelRate_  :
                        (currRightSpeed > 0) ? -decelRate_ : decelRate_;
        
        double newLeftSpeed  = currLeftSpeed  + dLeft*dt,
               newRightSpeed = currRightSpeed + dRight*dt;
        
        if(newLeftSpeed > left_) {
            if(left_ > 0) {
                newLeftSpeed = left_;
            }
        } else if(left_ < 0) {
            newLeftSpeed = left_;
        }
        
        if(newRightSpeed > right_) {
            if(right_ > 0) {
                newRightSpeed = right_;
            }
        } else if(right_ < 0) {
            newRightSpeed = right_;
        }
        
        driveTrain.drive(newLeftSpeed,newRightSpeed);
    }
    protected boolean isFinished() {
        return false;
    }
    protected void end() {
        time_.stop();
    }
    protected void interrupted() {
        end();
    }
}
