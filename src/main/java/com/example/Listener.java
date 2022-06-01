package com.example;

import com.example.Config.config;
import com.example.Util.GetRandomPhotos;
import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.message.data.Image;
import net.mamoe.mirai.utils.ExternalResource;

import java.io.File;

public class Listener {
    public void GroupPicture(){
        GlobalEventChannel.INSTANCE.subscribeAlways(GroupMessageEvent.class, event -> {
            String trigger = config.INSTANCE.getTrigger();
            String content = event.getMessage().contentToString();
            if (content.contains(trigger)) {//发送随机图库文件
                String filename = GetRandomPhotos.getPhotoName();//取随机图片
                Image image = ExternalResource.uploadAsImage(new File(filename), event.getSubject());//返回一个图片对象image
                event.getSubject().sendMessage(image);//发送图片
            }
        });
    }
}
