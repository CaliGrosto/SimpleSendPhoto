package com.alins.Command;

import com.alins.Config.config;
import com.alins.SimpleSendPhoto;
import net.mamoe.mirai.console.command.CommandSender;
import net.mamoe.mirai.console.command.java.JSimpleCommand;
import net.mamoe.mirai.message.data.Image;
import net.mamoe.mirai.utils.ExternalResource;

import java.io.File;
import java.util.Random;

public final class LotteryCommand extends JSimpleCommand {
    public static final LotteryCommand INSTANCE = new LotteryCommand();
    private LotteryCommand() {
        super(SimpleSendPhoto.INSTANCE, config.INSTANCE.getRangeTrigger());
        // 可选设置如下属性
        setDescription("抽奖指令");
        setPrefixOptional(true);
    }

    @Handler
    public void onCommand(CommandSender sender,String Head,String Last) {
        String rangePicturePath = config.INSTANCE.getRangePicturePath();
        int head = Integer.parseInt(Head);
        int last = Integer.parseInt(Last);
        File file = new File(rangePicturePath);
        File[] array = file.listFiles();
        int NumberOfPhotos = array.length;//有多少个文件
        if (head < 0 || last > NumberOfPhotos){
            sender.sendMessage("超出范围！");
        }else{
            StringBuilder stringBuilder = new StringBuilder();
            Random random = new Random();
            int pc = random.nextInt(last+1-head+1)+head;
            String pcs = String.valueOf(pc);

            StringBuilder append = stringBuilder.append(rangePicturePath)
                    .append("\\")
                    .append(pcs)
                    .append(".png");


            Image image = ExternalResource.uploadAsImage(new File(String.valueOf(append)), sender.getSubject());//返回一个图片对象image
            sender.sendMessage(image);
        }
    }
}
