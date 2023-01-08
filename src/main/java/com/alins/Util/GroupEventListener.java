package com.alins.Util;

import com.alins.Config.config;
import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.SimpleListenerHost;
import net.mamoe.mirai.event.events.MessageEvent;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Alin
 * date:
 */
public class GroupEventListener extends SimpleListenerHost {
    @EventHandler
    public void GroupEvent(@NotNull MessageEvent event){
        String content = event.getMessage().contentToString();
        List<String> trigger = config.INSTANCE.getTrigger();
        List<String> picturePath = config.INSTANCE.getPicturePath();
        int size = trigger.size();
        for (int t = 0; t < size; t++){
            if (content.contains(trigger.get(t))){
                RandomPicUtil.SendPic(picturePath.get(t), event);
                break;
            }
        }
    }
}
