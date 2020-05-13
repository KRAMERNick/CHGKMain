package com.example.chgk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class LogoActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logo_fragment);
        init();
        StartMainActivity();

    }
    private void init(){

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
    private void StartMainActivity(){
        new  Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent i = new Intent (LogoActivity.this,LoginActivity.class);
                startActivity(i);
            }
        }).start();
    }

}
