package com.example.chgk.MVP.Presenter;

import com.example.chgk.MVP.Data.IData;
import com.example.chgk.MVP.View.IViewLogin;

public class ViewLoginPresenter implements IViewLoginPresenter {

    IViewLogin iViewLogin;
    IData iData;
    boolean state = false;

    public ViewLoginPresenter(IViewLogin iViewLogin, IData iData) {
        this.iViewLogin = iViewLogin;
        this.iData = iData;
    }

    @Override
    public void onLogin(String log, String pass) {
        state = iData.Login(log, pass);
        iViewLogin.onLoginRes(state);

    }
}
