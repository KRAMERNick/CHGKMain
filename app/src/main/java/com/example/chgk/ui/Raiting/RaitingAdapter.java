package com.example.chgk.ui.Raiting;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.chgk.MVP.Model.Raitng;
import com.example.chgk.R;

import java.util.List;


public class RaitingAdapter extends BaseAdapter {

    private Context mContext;
    private List<Raitng> raitngList;

    public RaitingAdapter(Context mContext, List<Raitng> raitngList) {
        this.mContext = mContext;
        this.raitngList = raitngList;
    }

    @Override
    public int getCount() {
        return raitngList.size();
    }

    @Override
    public Object getItem(int i) {
        return raitngList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(mContext, R.layout.item_list, null);

        TextView name = v.findViewById(R.id.mName);
        TextView average  = v.findViewById(R.id.mAverage);

        name.setText(raitngList.get(i).getName());
        average.setText(raitngList.get(i).getAverage().toString());

        return v;
    }
}
