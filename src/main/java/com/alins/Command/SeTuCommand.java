package com.alins.Command;

import com.alins.Config.config;
import com.alins.SimpleSendPhoto;
import com.alins.Util.HttpUtils.HttpsUtil;
import com.alins.pojo.SaveJson;
import com.alins.Util.TimeUtils.TimeMeterUtil;
import net.mamoe.mirai.console.command.CommandSender;
import net.mamoe.mirai.console.command.java.JSimpleCommand;
import net.mamoe.mirai.message.data.Image;
import net.mamoe.mirai.message.data.MessageChain;
import net.mamoe.mirai.message.data.MessageChainBuilder;
import net.mamoe.mirai.utils.ExternalResource;

import java.io.File;


public final class SeTuCommand extends JSimpleCommand {
    public static final SeTuCommand INSTANCE = new SeTuCommand();
    private SeTuCommand() {
        super(SimpleSendPhoto.INSTANCE, "来点");
        // 可选设置如下属性
        setDescription("搜索图片");
        setPrefixOptional(true);
    }

    @Handler
    public void onCommand(CommandSender sender, String message) throws Exception {
        StringBuilder sbr = new StringBuilder(message);
        StringBuilder name1 = sbr.delete((sbr.length() - 2), sbr.length());//获取关键字
        SaveJson saveJson = HttpsUtil.GetJavaBean(String.valueOf(name1));
        //判断获取的json中有无图片相关数据
        if (saveJson.getData().size() == 0){
            sender.sendMessage("未查询到相关图片！");
        }else {

            TimeMeterUtil timeMeterUtil = new TimeMeterUtil();
            timeMeterUtil.SeTuSecond(config.INSTANCE.getSearchCD());
            //判断该功能是否处于冷却期

            if (timeMeterUtil.getSeTuSeconds() == 0) {
                SaveJson.DataDTO dataDTO = saveJson.getData().get(0);

                String author = dataDTO.getAuthor();
                String Urls = dataDTO.getUrls().getOriginal();
                String title = dataDTO.getTitle();

                String linuxSavePicture = config.INSTANCE.getLinuxSavePicture();
                String windowsSavePicture = config.INSTANCE.getWindowsSavePicture();

                HttpsUtil.downloadFile(Urls, windowsSavePicture, linuxSavePicture);//下载图片

                //判断系统是Windows还是Linux
                String os = System.getProperty("os.name");
                char c = os.charAt(0);
                String t = String.valueOf(c);
                boolean w = t.equals("W");
                String savePicture;
                if (w) {
                    savePicture = config.INSTANCE.getWindowsSavePicture();
                } else {
                    savePicture = config.INSTANCE.getLinuxSavePicture();
                }

                Image image = ExternalResource.uploadAsImage(new File(savePicture), sender.getSubject());//返回一个图片对象image

                MessageChain singleMessages = new MessageChainBuilder()
                        .append("标题：" + title + "\n")
                        .append("作者：" + author + "\n")
                        .append("图片链接：" + Urls)
                        .append(image)
                        .build();
                sender.sendMessage(singleMessages);
            }else{
                sender.sendMessage("该功能冷却中,剩余时间"+(config.INSTANCE.getSearchCD()-timeMeterUtil.getSeTuSeconds()));
            }
        }
    }
}
