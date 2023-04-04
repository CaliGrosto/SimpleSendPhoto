package com.alins;

import com.alins.Config.config;
import com.alins.Util.SendPicUtil;
import com.alins.Util.TimeMeterUtil;
import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.SimpleListenerHost;
import net.mamoe.mirai.event.events.MessageEvent;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 *
 * @author Alin
 * date:
 */
public class GroupEventListener extends SimpleListenerHost {
    @EventHandler
    public void GroupEvent(@NotNull MessageEvent event) throws InterruptedException {
        TimeMeterUtil timeMeterUtil = new TimeMeterUtil();

        String content = event.getMessage().contentToString();
        List<String> trigger = config.INSTANCE.getTrigger();
        List<String> picturePath = config.INSTANCE.getPicturePath();
        int size = trigger.size();
        for (int t = 0; t < size; t++){
            if (content.contains(trigger.get(t))){
                if(timeMeterUtil.getLocalPicSecond() == 0){

                    //启动计时器
                    SendPicUtil.SendRandomPic(picturePath.get(t), event);
                    timeMeterUtil.LocalSecond(config.INSTANCE.getSelfPicCD());

                    break;

                }else{
                    event.getSubject().sendMessage(config.INSTANCE.getCdPointOut());
                }
            }
        }
    }
}
