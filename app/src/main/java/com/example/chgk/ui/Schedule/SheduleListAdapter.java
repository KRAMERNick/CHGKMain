package com.example.chgk.ui.Schedule;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.chgk.MVP.Model.Schedule;
import com.example.chgk.R;

import java.util.List;






public class SheduleListAdapter extends BaseAdapter {

    private Context mContext;
    private List<Schedule> scheduleList;

    public SheduleListAdapter(Context mContext, List<Schedule> scheduleList) {
        this.mContext = mContext;
        this.scheduleList = scheduleList;
    }

    @Override
    public int getCount() {
        return scheduleList.size();
    }

    @Override
    public Object getItem(int i) {
        return scheduleList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(mContext, R.layout.item_list2, null);
        TextView lesson = v.findViewById(R.id.mLesson);
        TextView homework = v.findViewById(R.id.mHomeWork);

        lesson.setText(scheduleList.get(i).getLesson());
        homework.setText(scheduleList.get(i).getHomeWork());
        return v;
    }
}
