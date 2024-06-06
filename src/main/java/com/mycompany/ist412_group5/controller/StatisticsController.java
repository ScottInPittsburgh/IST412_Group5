package com.mycompany.ist412_group5.controller;

import com.mycompany.ist412_group5.model.statistics.IntStatisticsManager;
import com.mycompany.ist412_group5.model.statistics.StatisticsManager;
import com.mycompany.ist412_group5.view.StatisticsView;

public class StatisticsController {
    private IntStatisticsManager statisticsManager;
    private StatisticsView statisticsView;

    public StatisticsController() {
        this.statisticsManager = new StatisticsManager();
        this.statisticsView = new StatisticsView();
    }

    public void exampleStatisticsMethod() {
        statisticsManager.exampleStatisticsMethod();
        statisticsView.showStatistics();
    }
}
