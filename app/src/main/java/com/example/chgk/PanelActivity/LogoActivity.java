package com.example.chgk.PanelActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.chgk.MainActivity;
import com.example.chgk.R;

public class LogoActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_logo);
        init();
        StartMainActivity();
    }
    private void init(){

    }

    public void onClickStart(View view) {
        Intent i = new Intent (LogoActivity.this, MainActivity.class);
        startActivity(i);
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
                Intent i = new Intent (LogoActivity.this, MainActivity.class);
                startActivity(i);
            }
        }).start();
    }

}
