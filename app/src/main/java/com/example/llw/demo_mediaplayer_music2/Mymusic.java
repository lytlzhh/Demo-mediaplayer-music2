
package com.example.llw.demo_mediaplayer_music2;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;

public class Mymusic extends Service {
    private Handler handler;
    private MediaPlayer mediaPlayer;
    int[] music = {R.raw.b,R.raw.a,R.raw.c};
    int s = music.length-1;
    int sb = s;
    public Mymusic() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public  void  fun(int f){
        new Thread(){
            @Override
            public void run() {

             //   while (true){
                    Message message = new Message();
                    message.obj = music[s];
                    handler.sendMessage(message);
                if (s!=0)
                {
                    s--;
                }else {
                    s = sb;
                }

                    try {
                        sleep(1000*2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

           // }
        }.start();
    }

    @Override
    public int onStartCommand(final Intent intent, final int flags, final int startId) {
        int d = 0;
        fun( d);
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                Integer ss = (Integer) msg.obj;
                if (mediaPlayer!=null)
                {
                    mediaPlayer.release();
                }
                mediaPlayer=MediaPlayer.create(Mymusic.this,ss);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        try {
                            Thread.sleep(3000);
                           onStartCommand(intent,flags,startId);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        };
        return super.onStartCommand(intent, flags, startId);
    }

}
