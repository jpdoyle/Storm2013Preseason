/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package storm2013.preseason.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author Evan Allan
 */

public class EncoderDrive extends Command {

    private static final double DRIVE_SPEED = 1; //TODO find the number this should be.
    
    private double leftGoal_, rightGoal_, leftDist_, rightDist_;
    private AccelerateToward accel_ = new AccelerateToward();
    
    public EncoderDrive(){}
    public EncoderDrive(double leftGoal, double rightGoal, double leftDist, double rightDist){ 
        leftGoal_ = leftGoal;
        rightGoal_ = rightGoal;
        leftDist_ = leftDist; //Not really necessary but hey, you might want it
        rightDist_ = leftDist;//This too
        if (leftGoal_ > leftDist_) {accel_.setTargetLeft(DRIVE_SPEED);}
        else if (leftGoal_ < 0) {accel_.setTargetLeft(-DRIVE_SPEED);}
        if (rightGoal_ > rightDist_) {accel_.setTargetRight(DRIVE_SPEED);}
        else if (rightGoal_ < 0) {accel_.setTargetRight(-DRIVE_SPEED);}
    }
    
    public void setLeftDist_(double leftDist) {
        leftDist_ = leftDist;
    }
    public void setRightDist_(double rightDist) {
        rightDist_ = rightDist;
    }
    public void setLeftGoal_(double leftGoal){
        leftGoal_ = leftGoal;
    }
    public void setRightGoal_(double rightGoal){
        rightGoal_ = rightGoal;
    }
    public double getLeftGoal() {
        return leftGoal_;
    }
    public double getRightGoal() {
        return rightGoal_;
    }
    public double getLeftDist() {
        return leftDist_;
    }
    public double getRightDist() {
        return rightDist_;
    }
    
    public void initialize() {
        accel_.start();
    }
    public void execute() {
        //TODO learn about how to get encoder values and use that to find the distance
        //TODO also, make some PID-ish kinda thing, right now it'll bounce back and forth until it reaches the needed value
        if (leftDist_ == leftGoal_){
            accel_.setTargetLeft(0); 
        }
        else if(leftDist_ > leftGoal_ && accel_.getTargetLeft() != -DRIVE_SPEED){
            accel_.setTargetLeft(-DRIVE_SPEED);
        }
        else if(leftDist_ < leftGoal_ && accel_.getTargetLeft() != DRIVE_SPEED){
            accel_.setTargetLeft(DRIVE_SPEED);
        }
        if (rightDist_ == rightGoal_){
            accel_.setTargetRight(0);
        }
        else if(rightDist_ > rightGoal_ && accel_.getTargetRight() != -DRIVE_SPEED){
            accel_.setTargetRight(-DRIVE_SPEED);
        }
        else if(rightDist_ < rightGoal_ && accel_.getTargetRight() != DRIVE_SPEED){
            accel_.setTargetRight(DRIVE_SPEED);
        } 
    }
    public boolean isFinished() {
        return !accel_.isRunning();
    }
    public void end() {
        accel_.cancel();
    }
    public void interrupted() {
        end();
    }
    
}
