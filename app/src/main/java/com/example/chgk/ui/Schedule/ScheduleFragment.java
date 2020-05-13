package com.example.chgk.ui.Schedule;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.chgk.MVP.Data.DataSingletone;
import com.example.chgk.MVP.Model.Schedule;
import com.example.chgk.MVP.Presenter.IViewSchedulePresenter;
import com.example.chgk.MVP.Presenter.ViewSchedulePresenter;
import com.example.chgk.MVP.View.IViewSchedule;
import com.example.chgk.R;

import java.util.List;


public class ScheduleFragment extends Fragment implements IViewSchedule {

    private IViewSchedulePresenter iViewSchedulePresenter;
    private ListView listView;
    private SheduleListAdapter sheduleListAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.timetable_fragment, container, false);
        listView = view.findViewById(R.id.all_schedule);
        iViewSchedulePresenter = new ViewSchedulePresenter(this, DataSingletone.getInstance());
        iViewSchedulePresenter.onShedule();
        return view;
    }

    @Override
    public void onScheduleRes(List<Schedule> schedules) {
        sheduleListAdapter = new SheduleListAdapter(getContext(), schedules);
        listView.setAdapter(sheduleListAdapter);
    }
}
