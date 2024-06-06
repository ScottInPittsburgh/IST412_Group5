package com.mycompany.ist412_group5.controller;

import com.mycompany.ist412_group5.model.scheduling.IntSchedulingManager;
import com.mycompany.ist412_group5.model.scheduling.SchedulingManager;
import com.mycompany.ist412_group5.view.SchedulingView;

public class SchedulingController {
    private IntSchedulingManager schedulingManager;
    private SchedulingView schedulingView;

    public SchedulingController() {
        this.schedulingManager = new SchedulingManager();
        this.schedulingView = new SchedulingView();
    }

    public void exampleSchedulingMethod() {
        schedulingManager.exampleSchedulingMethod();
        schedulingView.showActivities();
    }
}

