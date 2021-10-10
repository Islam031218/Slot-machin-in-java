package com.template;

import android.widget.ImageView;

public class Weel extends Thread {
    int randomCount = 0;

    interface WheelListener {
        void newImage(int img);
    }


    public int currentIndex;
    private WheelListener wheelListener;
    private long frameDuration;
    private long startIn;
    private ImageView btn1;


    public Weel(WheelListener wheelListener, long frameDuration, long startIn, ImageView btn, Integer randomCount) {
        this.wheelListener = wheelListener;
        this.frameDuration = frameDuration;
        this.startIn = startIn;
        btn1 = btn;
        currentIndex = 0;
        this.randomCount = randomCount;

    }

    public void nextImg() {
        currentIndex++;

        if (currentIndex == Utils.arrayImage.length) {
            currentIndex = 0;
        }
    }

    @Override
    public void run() {
        btn1.setAlpha(0);

        try {
            Thread.sleep(startIn);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < Math.random() * randomCount; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            nextImg();

            if (wheelListener != null) {
                wheelListener.newImage(Utils.arrayImage[currentIndex]);
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        btn1.setAlpha(1000);

    }

}

