package com.example.hscom;

public class PlannerItemDemo {
    private String task,time;
    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public PlannerItemDemo(String task, String time){
        this.task = task;
        this.time = time;
    }

}
