package com.alins.Command;

import com.alins.Config.Ascii2dConfig;
import com.alins.SimpleSendPhoto;
import com.alins.Util.HttpUtils.HttpHandleUtil;
import com.alins.Util.HttpUtils.HttpsUtil;
import com.alins.Util.SendPicUtil;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.console.command.CommandSender;
import net.mamoe.mirai.console.command.java.JSimpleCommand;
import net.mamoe.mirai.contact.Contact;
import net.mamoe.mirai.message.data.*;

import java.util.*;


public class SearchMapCommand extends JSimpleCommand {
    public static final SearchMapCommand INSTANCE = new SearchMapCommand();
    private SearchMapCommand() {
        super(SimpleSendPhoto.INSTANCE, "搜图");
        // 可选设置如下属性
        setDescription("Ascii2d");
        setPrefixOptional(true);
    }
    @Handler
    public void onCommand(CommandSender sender, Image image1) throws Exception {
        final String WinParentDirectory = Ascii2dConfig.INSTANCE.getWinParentDirectory();
        final String linuxParentDirectory = Ascii2dConfig.INSTANCE.getLinuxParentDirectory();
        final int searchNumber = Ascii2dConfig.INSTANCE.getSearchNumber();

        Contact group = sender.getSubject();
        Bot bot = sender.getBot();

        String ToBeFoundPicUrl = Image.queryUrl(image1);

        /*
          图片保存路径
         */

        //判断系统是Windows or Linux
        String os = System.getProperty("os.name");
        char c = os.charAt(0);
        String t = String.valueOf(c);
        boolean w = t.equals("W");
        String savePicture;
        if (w){
            savePicture = WinParentDirectory;
        }else {
            savePicture = linuxParentDirectory;
        }

        ArrayList<String> PicSaveArray = new ArrayList<>();
        for (int j = 0 ; j< searchNumber;j++){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(savePicture)
                    .append("pic")
                    .append(j)
                    .append(".jpg");
            String LocalPicPath = String.valueOf(stringBuilder);
            PicSaveArray.add(LocalPicPath);
        }

        /*
          图片具体信息
         */
        ArrayList<String> arrayList = new HttpHandleUtil(ToBeFoundPicUrl).SearchMapHandlePic();
        for (int i = 0 ; i < searchNumber;i++){
            HttpsUtil.downloadFile(arrayList.get(i),PicSaveArray.get(i),PicSaveArray.get(i));
        }

        /*
          装有Image类型图片的集合
         */
        ArrayList<Image> WillSendPic = new ArrayList<>();
        for (int j = 0 ; j < searchNumber;j++){
            WillSendPic.add(SendPicUtil.getImageObject(PicSaveArray.get(j),group));
        }
        /*
           装有作者原图信息的ArrayList集合
         */
        ArrayList<String> authorInformation = new HttpHandleUtil(ToBeFoundPicUrl).SearchMapHandleAuthor();







        /*
          构建转发消息链
         */
        ForwardMessageBuilder builder = new ForwardMessageBuilder(group);
        builder.add(bot, new PlainText("查询结果如下：" + "\n" + "原图为："));
        builder.add(bot, image1);
        builder.add(bot, new PlainText("搜索结果如下："));

        for (int j = 0;j<searchNumber;j++){
            /*
              构建单条消息链
             */
            MessageChainBuilder singleMessages = new MessageChainBuilder();
            singleMessages.add("图片来源：" + authorInformation.get(j*2) + "\n");
            singleMessages.add("图片作者：" + authorInformation.get(j*2+1) + "\n");
            singleMessages.add(WillSendPic.get(j));

            builder.add(bot, singleMessages.build());
        }

        builder.setDisplayStrategy(new ForwardMessage.DisplayStrategy() {
        });
        ForwardMessage forward = builder.build();
        group.sendMessage(forward);
    }
}
