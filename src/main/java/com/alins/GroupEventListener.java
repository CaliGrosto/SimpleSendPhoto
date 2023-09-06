package com.alins;

import com.alins.Config.config;
import com.alins.Util.SendPicUtil;
import com.alins.Util.TimeUtils.TimeMeterUtil;
import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.SimpleListenerHost;
import net.mamoe.mirai.event.events.MessageEvent;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author Alin
 */
public class GroupEventListener extends SimpleListenerHost {
    int number = -1;//目前无放回所取到的数组元素是第number个
    int[] ints = null;
    @EventHandler
    public void GroupEvent(@NotNull MessageEvent event) {
        String content = event.getMessage().contentToString();
        List<String> trigger = config.INSTANCE.getTrigger();

        int size = trigger.size();
        for (int t = 0; t < size; t++){
            if(config.INSTANCE.getFuzzyMatching()){
                if (content.equals(trigger.get(t))){
                    Shit(t,event);
                }else if(content.contains(trigger.get(t))){
                    Shit(t,event);
                }
            }
        }
    }

    /**
     * 码如其名，就是依托淳谢特，就是淳懒，主打一个能用就行
     * @param t
     */
    public void Shit(int t,MessageEvent event){
        TimeMeterUtil timeMeterUtil = new TimeMeterUtil();
        List<String> picturePath = config.INSTANCE.getPicturePath();
        boolean NoPutBackSampling = config.INSTANCE.getNoPutBackSampling();
        //启动计时器
        if(timeMeterUtil.getLocalPicSecond() == 0){
            if (NoPutBackSampling){
                if (number == -1){
                    //数组重置
                    ints = SendPicUtil.GetRandomArray(picturePath.get(t));
                    number = 0;
                }
                SendPicUtil.SendNoPutBackPic(ints,number,picturePath.get(t),event);
                number++;
                if (number > SendPicUtil.getFilePathLength(picturePath.get(t))-1){
                    number = -1;
                }
            }else{
                SendPicUtil.SendRandomPic(picturePath.get(t), event);
            }
            timeMeterUtil.LocalSecond(config.INSTANCE.getSelfPicCD());
        }else{
            event.getSubject().sendMessage(config.INSTANCE.getCdPointOut());
        }
    }
}
