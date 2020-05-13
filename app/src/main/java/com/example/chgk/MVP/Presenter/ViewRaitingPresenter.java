package com.example.chgk.MVP.Presenter;

import com.example.chgk.MVP.Data.IData;
import com.example.chgk.MVP.Model.Raitng;
import com.example.chgk.MVP.View.IViewRaiting;

import java.util.ArrayList;
import java.util.List;

public class ViewRaitingPresenter implements IViewRaitingPresenter {
    IViewRaiting iViewRaiting;
    IData iData;
    List<Raitng> raitngs = new ArrayList<>();

    public ViewRaitingPresenter(IViewRaiting iViewRaiting, IData iData) {
        this.iViewRaiting = iViewRaiting;
        this.iData = iData;
    }

    @Override
    public void onRaiting() {
       raitngs = iData.getListRaiting();
       iViewRaiting.onRaitingRes(raitngs);
    }
}
