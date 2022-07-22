package com.example;

import com.example.Config.config;
import com.example.Util.GetRandomPhotos;
import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.message.data.Image;
import net.mamoe.mirai.utils.ExternalResource;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Listener {
    public void GroupPicture() {
        GlobalEventChannel.INSTANCE.subscribeAlways(GroupMessageEvent.class, event -> {
            String trigger = config.INSTANCE.getTrigger();
            String content = event.getMessage().contentToString();
            String path = config.INSTANCE.getPicturePath();

            if (content.contains(trigger)) {//发送随机图库文件
                String filename = GetRandomPhotos.getPhotoName(path);//取随机图片
                Image image = ExternalResource.uploadAsImage(new File(filename), event.getSubject());//返回一个图片对象image
                event.getSubject().sendMessage(image);//发送图片
            }
        });
    }
    public void GroupPicture2(){
        GlobalEventChannel.INSTANCE.subscribeAlways(GroupMessageEvent.class,event->{
           String trigger2 = config.INSTANCE.getTrigger2();
           String content2 = event.getMessage().contentToString();
           String path2 = config.INSTANCE.getPicturePath2();

           if (content2.contains(trigger2)){//发送随机图库文件2
               String filename2 = GetRandomPhotos.getPhotoName(path2);
               Image image2 = ExternalResource.uploadAsImage(new File(filename2), event.getSubject());
               event.getSubject().sendMessage(image2);
           }
        });
    }
    public void GroupPicture3() {
        GlobalEventChannel.INSTANCE.subscribeAlways(GroupMessageEvent.class, event -> {
            String trigger3 = config.INSTANCE.getTrigger3();
            String content3 = event.getMessage().contentToString();
            String path3 = config.INSTANCE.getPicturePath3();

            if (content3.contains(trigger3)) {//发送随机图库文件2
                String filename3 = GetRandomPhotos.getPhotoName(path3);
                Image image3 = ExternalResource.uploadAsImage(new File(filename3), event.getSubject());
                event.getSubject().sendMessage(image3);
            }
        });
    }
}
