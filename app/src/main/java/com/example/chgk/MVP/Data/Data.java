package com.example.chgk.MVP.Data;

import com.example.chgk.MVP.Model.Raitng;
import com.example.chgk.MVP.Model.Schedule;

import java.util.ArrayList;
import java.util.List;


public class Data implements IData {
    private static List<Raitng> raitngs = new ArrayList<>();
    private static List<Schedule> schedules = new ArrayList<>();

    private void setDataRaitng(){
        raitngs.add(new Raitng("Английский язык", (float) 4.04));
        raitngs.add(new Raitng("Алгебра", (float) 4.56));
        raitngs.add(new Raitng("Русский язык", (float) 4.33));
        raitngs.add(new Raitng("Математика", (float) 4.89));
    }

    private void setDataSchedule(){
        schedules.add(new Schedule("Урок 1", "Что то сделать"));
        schedules.add(new Schedule("Урок 2", "Что то сделать"));
        schedules.add(new Schedule("Урок 3", "Что то сделать"));
        schedules.add(new Schedule("Урок 4", "Что то сделать"));
        schedules.add(new Schedule("Урок 5", "Что то сделать"));
    }

    @Override
    public List<Raitng> getListRaiting() {
        setDataRaitng();
        return raitngs;
    }

    @Override
    public List<Schedule> getListSchedule() {
        setDataSchedule();
        return schedules;
    }

    @Override
    public boolean Login(String log, String pass) {
        return false;
    }
}
