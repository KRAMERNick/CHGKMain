package com.example.chgk.MVP.Model;

import com.example.chgk.MVP.Model.ISchedule;

public class Schedule implements ISchedule {
    private String lesson;
    private String homeWork;

    public Schedule(String lesson, String homeWork) {
        this.lesson = lesson;
        this.homeWork = homeWork;
    }


    @Override
    public String getHomeWork() {
        return homeWork;
    }

    @Override
    public String getLesson() {
        return lesson;
    }
}
