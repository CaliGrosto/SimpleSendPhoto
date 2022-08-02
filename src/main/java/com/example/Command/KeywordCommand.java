package com.example.Command;

import com.example.Config.config;
import com.example.SimpleSendPhoto;
import com.example.Util.Https;
import com.example.Util.SaveJson;
import net.mamoe.mirai.console.command.CommandSender;
import net.mamoe.mirai.console.command.java.JSimpleCommand;
import net.mamoe.mirai.message.data.Image;
import net.mamoe.mirai.message.data.MessageChain;
import net.mamoe.mirai.message.data.MessageChainBuilder;
import net.mamoe.mirai.utils.ExternalResource;

import java.io.File;


public final class KeywordCommand extends JSimpleCommand {
    public static final KeywordCommand INSTANCE = new KeywordCommand();
    private KeywordCommand() {
        super(SimpleSendPhoto.INSTANCE, "来点");
        // 可选设置如下属性
        setDescription("搜索图片");
        setPrefixOptional(true);
    }

    @Handler
    public void onCommand(CommandSender sender, String message) throws Exception {
        StringBuilder sbr = new StringBuilder(message);
        StringBuilder name1 = sbr.delete((sbr.length() - 2), sbr.length());//获取关键字
        SaveJson saveJson = Https.GetJavaBean(String.valueOf(name1));
        //判断获取的json中有无图片相关数据
        if (saveJson.getData().size() == 0){
            sender.sendMessage("未查询到相关图片！");
        }else{
            SaveJson.DataDTO dataDTO = saveJson.getData().get(0);

            String author = dataDTO.getAuthor();
            String Urls = dataDTO.getUrls().getOriginal();
            String title = dataDTO.getTitle();


            Https.downloadFile(Urls);//下载图片
            //判断系统是Windows还是Linux
            String os = System.getProperty("os.name");
            char c = os.charAt(0);
            String t = String.valueOf(c);
            boolean w = t.equals("W");
            String savePicture;
            if (w){
                savePicture = config.INSTANCE.getWindowsSavePicture();
            }else {
                savePicture = config.INSTANCE.getLinuxSavePicture();
            }
            Image image = ExternalResource.uploadAsImage(new File(savePicture), sender.getSubject());//返回一个图片对象image

            MessageChain singleMessages = new MessageChainBuilder()
                    //.append(image + "\n")
                    .append("标题："+title+"\n")
                    .append("作者："+author+"\n")
                    .append("图片链接："+Urls)
                    .append(image)
                    .build();
            sender.sendMessage(singleMessages);
        }
    }
}
