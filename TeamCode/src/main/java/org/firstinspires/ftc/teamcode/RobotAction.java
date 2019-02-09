package org.firstinspires.ftc.teamcode;

public abstract class RobotAction {

    abstract public Boolean getRequireMultithreading();

    abstract public Runnable getActionMethod();
}