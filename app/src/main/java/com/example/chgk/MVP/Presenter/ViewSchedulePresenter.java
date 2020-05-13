package com.example.chgk.MVP.Presenter;

import com.example.chgk.MVP.Data.IData;
import com.example.chgk.MVP.Model.Schedule;
import com.example.chgk.MVP.View.IViewSchedule;
import java.util.List;

public class ViewSchedulePresenter implements IViewSchedulePresenter {

    IViewSchedule iViewSchedule;
    IData iData;

    public ViewSchedulePresenter(IViewSchedule iViewSchedule, IData iData) {
        this.iViewSchedule = iViewSchedule;
        this.iData = iData;
    }

    @Override
    public void onShedule() {
       List<Schedule> schedules = iData.getListSchedule();
       iViewSchedule.onScheduleRes(schedules);
    }
}
