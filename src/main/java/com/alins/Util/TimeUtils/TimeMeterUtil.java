package com.alins.Util.TimeUtils;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 不显示时间的话感觉这类都是纯没用
 */
public class TimeMeterUtil{
    private static int SeTuSecond;
    private static int LocalSecond;
    public int getSeTuSeconds(){
        return SeTuSecond;
    }
    public int getLocalPicSecond(){
        return LocalSecond;
    }

    /**
     *
     * @param endSeconds 结束秒数
     * @return
     */
    public void SeTuSecond(int endSeconds){
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                SeTuSecond++;
                if(SeTuSecond == endSeconds){
                    //到endSeconds就将seconds归零
                    SeTuSecond = 0;
                    timer.cancel();
                }
            }
        };

        //启动计时器,默认为1000ms
        timer.schedule(timerTask,0,1000);
    }

    public void LocalSecond(int endSeconds){
        Timer timers = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                LocalSecond++;
                if(LocalSecond == endSeconds){
                    //到endSeconds就将seconds归零
                    LocalSecond = 0;
                    timers.cancel();
                }
            }
        };

        //启动计时器,默认为1000ms
        timers.schedule(timerTask,0,1000);
    }


}
