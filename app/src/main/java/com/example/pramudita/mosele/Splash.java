package com.example.pramudita.mosele;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by noonart on 06/09/2016.
 */
public class Splash extends Activity{
    private static int splashInterval = 3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.splash);

        new Handler().postDelayed(new Runnable() {
                                      @Override
                                      public void run() {
                                          Intent i = new Intent(Splash.this,MainActivity.class);
                                          startActivity(i);

                                          this.finish();
                                      }

                                      private  void finish(){

                                      }
                                  },splashInterval

        );
    };



}
