package com.example.chgk;

import com.google.gson.Gson;

import android.content.Intent;
import android.os.Build;
import android.widget.EditText;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.os.AsyncTask;
import android.view.View.OnClickListener;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class LoginActivity extends AppCompatActivity {


    public static String login_in = "";
    public static String password_in = "";


    public EditText log;
    public EditText pas;



    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        Button btn = (Button) findViewById(R.id.button);
        log = (EditText) findViewById(R.id.editText2);
        pas = (EditText) findViewById(R.id.editText);




        btn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                login_in = log.getText().toString();
                password_in = pas.getText().toString();


                try {

                    new SendData().execute();


                } catch (Exception e) {

                }





            }
        });
    }







   public  class SendData extends AsyncTask<Void, Void, Void> {
       String resultString = null;
       String id;
       String login;
       String error;




       @Override
       protected void onPreExecute() {
           super.onPreExecute();
       }

       @RequiresApi(api = Build.VERSION_CODES.KITKAT)
       @Override
       protected Void doInBackground(Void... params) {
           try {

               String myURL = "http://chgk.space:8080/login.php";

               String parammetrs = "login=" + login_in + "&password=" + password_in;
               byte[] data = null;
               InputStream is = null;


               try {
                   URL url = new URL(myURL);
                   HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                   conn.setReadTimeout(10000);
                   conn.setConnectTimeout(15000);
                   conn.setRequestMethod("POST");
                   conn.setRequestProperty("Connection", "Keep-Alive");
                   conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                   conn.setRequestProperty("Content-Length", "" + Integer.toString(parammetrs.getBytes().length));
                   conn.setDoOutput(true);
                   conn.setDoInput(true);



                   data = parammetrs.getBytes("UTF-8");


                   OutputStream os = conn.getOutputStream();



                   os.write(data);
                   os.flush();
                   os.close();
                   data = null;
                   conn.connect();
                   int responseCode = conn.getResponseCode();


                   ByteArrayOutputStream baos = new ByteArrayOutputStream();

                   if (responseCode == 200) {
                       is = conn.getInputStream();

                       byte[] buffer = new byte[8192]; // размер буфера


                       int bytesRead;


                       while ((bytesRead = is.read(buffer)) != -1) {
                           baos.write(buffer, 0, bytesRead);
                       }


                       data = baos.toByteArray();
                       resultString = new String(data, "UTF-8");
                       System.out.println(resultString);
                       Gson gson = new Gson();
                       SendData user = gson.fromJson(resultString, SendData.class);
                       if(!user.id.equals("error") && !user.login.equals("error")){
                           Intent i = new Intent (LoginActivity.this, MainActivity.class);
                           startActivity(i);
                       } else {
                           Toast.makeText(LoginActivity.this, "Ошибка входа", Toast.LENGTH_SHORT).show();
                       }






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





   }


}



