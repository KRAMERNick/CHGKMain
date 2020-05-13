package com.example.chgk.ui.Raiting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.chgk.MVP.Data.DataSingletone;
import com.example.chgk.MVP.Model.Raitng;
import com.example.chgk.MVP.Presenter.IViewRaitingPresenter;
import com.example.chgk.MVP.Presenter.ViewRaitingPresenter;
import com.example.chgk.MVP.View.IViewRaiting;
import com.example.chgk.R;

import java.util.List;


public class RatingFragment extends Fragment implements IViewRaiting {

    private IViewRaitingPresenter iViewRaitingPresenter;
    private ListView listView;
    private RaitingAdapter raitingAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.values_fragment, container, false);
        listView = root.findViewById(R.id.all_values);
        iViewRaitingPresenter = new ViewRaitingPresenter(this, DataSingletone.getInstance());
        iViewRaitingPresenter.onRaiting();
        return root;
    }

    @Override
    public void onRaitingRes(List<Raitng> raitngList) {
        raitingAdapter = new RaitingAdapter(getContext(), raitngList);
        listView.setAdapter(raitingAdapter);
    }
}
