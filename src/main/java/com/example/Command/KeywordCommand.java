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
        SaveJson.DataDTO dataDTO = saveJson.getData().get(0);

        String author = dataDTO.getAuthor();
        String Urls = dataDTO.getUrls().getOriginal();
        String title = dataDTO.getTitle();


        Https.downloadFile(Urls);//下载图片
        String savePicture = config.INSTANCE.getSavePicture();//
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
