package com.example.llw.demo_mediaplayer_music2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnstart;
    private  Button but2;
    private  Button but3;
    private MediaPlayer mediaPlayer1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnstart = (Button) findViewById(R.id.button);
        but2 = (Button) findViewById(R.id.button2);
        but3 = (Button) findViewById(R.id.button3);

        final Intent intent = new Intent(MainActivity.this,Mymusic.class);
        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // startActivity(intent);
                startService(intent);
            }
        });

     /*   but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               new Mymusic().fun();


                Intent intent1 = new Intent(s)
                startService(intent);

            }
        });*/




    }

}
