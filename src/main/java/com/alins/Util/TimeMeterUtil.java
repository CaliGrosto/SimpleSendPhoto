package com.alins.Util;

import java.util.Timer;
import java.util.TimerTask;

public class TimeMeterUtil{
    private static int seconds;

    public int getSeconds(){
        return seconds;
    }

    /**
     *
     * @param endSeconds 结束秒数
     * @return
     */
    public void startTimeMeter(int endSeconds){
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                seconds++;
                if(seconds == endSeconds){
                    //到endSeconds就将seconds归零
                    seconds = 0;
                    timer.cancel();
                }
            }
        };

        //启动计时器,默认为1000ms
        timer.schedule(timerTask,0,1000);
    }
}
