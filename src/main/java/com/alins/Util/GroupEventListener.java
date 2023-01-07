package com.alins.Util;

import com.alins.Config.config;
import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.SimpleListenerHost;
import net.mamoe.mirai.event.events.MessageEvent;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 *
 * @author Alin
 * date:
 */
public class GroupEventListener extends SimpleListenerHost {
    @EventHandler
    public void GroupEvent(@NotNull MessageEvent event)throws Exception{
        String content = event.getMessage().contentToString();
        ArrayList<String> triggerList = new ArrayList<>();
        triggerList.add(config.INSTANCE.getTrigger());
        triggerList.add(config.INSTANCE.getTrigger2());
        triggerList.add(config.INSTANCE.getTrigger3());
        triggerList.add(config.INSTANCE.getTrigger4());
        if(content.contains(triggerList.get(0))){
            RandomPicUtil.SendPic(config.INSTANCE.getPicturePath(), event);
        }else if(content.contains(triggerList.get(1))){
            RandomPicUtil.SendPic(config.INSTANCE.getPicturePath2(), event);
        }else if(content.contains(triggerList.get(2))){
            RandomPicUtil.SendPic(config.INSTANCE.getPicturePath3(), event);
        }else if(content.contains(triggerList.get(3))){
            RandomPicUtil.SendPic(config.INSTANCE.getPicturePath4(), event);
        }
    }
}
