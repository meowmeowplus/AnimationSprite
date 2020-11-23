package com.example.animationsprite;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.CountDownTimer;

public class AnimationSprite extends MySprite {
    public boolean isTurnedOn;
    private MainScreen mainScreen;
    private MediaPlayer media = null;

    public AnimationSprite(Context context, MainScreen mainScreen, int top, int left, int width, int height) {
        super(context, top, left, width, height);
        this.mainScreen = mainScreen;
        isTurnedOn = false;
    //    startAnimation();
    }

    public CountDownTimer timer = new CountDownTimer(5000,
            100 ) {
        @Override
        public void onTick (long millisUntilFinished) {
            update();
            mainScreen.postInvalidate();
        }

        @Override
        public void onFinish() {
            start();
        }
    };

    public void startAnimation() {
        timer.start();
    }

    public void stopAnimation() {
        timer.cancel();
        update(0);
        //how to make it begin again?
    }

    public void handleClick(Context context) {
        if(this.isTurnedOn){
            startAnimation();
            if(media == null)
            {
                media = MediaPlayer.create(context, R.raw.loi_nho);
                media.start();
            }
        }
        else{
            stopAnimation();
            if(media.isPlaying())
            {
                media.stop();
                media = null;
            }
        }
    }
}
