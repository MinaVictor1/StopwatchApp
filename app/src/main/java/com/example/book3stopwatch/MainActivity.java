package com.example.book3stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int seconds=0;
    private boolean running;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        runtimer();
    }
    public void onclickstart(View view){

        running=true;
    }
    public void onclickstop(View view){
        running=false;
    }
    public void onclickreset(View view){
        running=false;
        seconds=0;
    }
    private void runtimer(){
        final TextView timeView=(TextView) findViewById(R.id.time_view);
        final Handler handler=new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours=seconds/3600;
                int minutes=(seconds%3600)/60;
                int secs=seconds%60;
                String time=String.format("%d:%02d:%02d",hours,minutes,secs);
                timeView.setText(time);
                if(running)
                    seconds++;
                handler.postDelayed(this::run,1000);
            }
        });
    }
}