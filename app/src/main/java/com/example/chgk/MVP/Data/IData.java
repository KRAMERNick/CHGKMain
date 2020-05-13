package com.example.chgk.MVP.Data;

import com.example.chgk.MVP.Model.Raitng;
import com.example.chgk.MVP.Model.Schedule;

import java.util.List;

public interface IData {
    List<Raitng> getListRaiting();
    List<Schedule> getListSchedule();
    boolean Login(String log, String pass);
}
