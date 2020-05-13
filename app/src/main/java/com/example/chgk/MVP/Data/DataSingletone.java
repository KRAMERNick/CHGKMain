package com.example.chgk.MVP.Data;

import android.os.AsyncTask;

import com.example.chgk.MVP.Model.Raitng;
import com.example.chgk.MVP.Model.Schedule;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class DataSingletone implements IData {

    private static String login_in = "";
    private static String password_in = "";
    private static String server = "chgk.space/21";
    protected String resultString;


    private List<Raitng> raitngs = new ArrayList<>();
    private List<Schedule> schedules = new ArrayList<>();

    private static DataSingletone instance;

    private DataSingletone(){

    }

    public static DataSingletone getInstance(){
        if(instance == null){
            instance = new DataSingletone();
        }
        return instance;
    }

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
        if (raitngs.isEmpty()){
            setDataRaitng();
            return raitngs;
        }else {
            return raitngs;
        }
    }

    @Override
    public List<Schedule> getListSchedule() {
        if (schedules.isEmpty()){
            setDataSchedule();
            return schedules;
        }else {
            return schedules;
        }
    }

    @Override
    public boolean Login(String login, String password) {
        login_in = login;
        password_in = password;
        try {
            SendData sendData = new SendData();
            sendData.execute().get();
        }catch (Exception e){
            e.fillInStackTrace();
        }

        return false;
    }

    class SendData extends AsyncTask<Void, Void, Void> {

        String resultString = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {

                String myURL = "https://"+server+"/server.php";

                String parammetrs = "login = "+login_in+"&password "+password_in;
                byte[] data = null;
                InputStream is = null;

                try {
                    URL url = new URL(myURL);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setReadTimeout(10000);
                    conn.setConnectTimeout(15000);
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Connection", "Keep-Alive");
                    conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
                    conn.setRequestProperty("Content-Length", "" + Integer.toString(parammetrs.getBytes().length));
                    conn.setDoOutput(true);
                    conn.setDoInput(true);


                    // конвертируем передаваемую строку в UTF-8
                    data = parammetrs.getBytes("UTF-8");

                    OutputStream os = conn.getOutputStream();

                    // передаем данные на сервер
                    os.write(data);
                    os.flush();
                    os.close();
                    data = null;
                    conn.connect();
                    int responseCode= conn.getResponseCode();


                    // передаем ответ сервер
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();

                    if (responseCode == 200) {    // Если все ОК (ответ 200)
                        is = conn.getInputStream();

                        byte[] buffer = new byte[8192]; // размер буфера

                        // Далее так читаем ответ
                        int bytesRead;

                        while ((bytesRead = is.read(buffer)) != -1) {
                            baos.write(buffer, 0, bytesRead);
                        }

                        data = baos.toByteArray();
                        resultString = new String(data, "UTF-8");  // сохраняем в переменную ответ сервера, у нас "OK"

                    } else {
                    }

                    conn.disconnect();

                } catch (MalformedURLException e) {

                    //resultString = "MalformedURLException:" + e.getMessage();
                } catch (IOException e) {

                    //resultString = "IOException:" + e.getMessage();
                } catch (Exception e) {

                    //resultString = "Exception:" + e.getMessage();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }


        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
        }

    }
}

