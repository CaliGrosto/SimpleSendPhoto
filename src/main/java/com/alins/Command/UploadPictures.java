package com.alins.Command;

import com.alins.SimpleSendPhoto;
import com.alins.Util.HttpUtils.savePictures;
import net.mamoe.mirai.console.command.CommandSender;
import net.mamoe.mirai.console.command.java.JSimpleCommand;
import net.mamoe.mirai.message.data.Image;


public final class UploadPictures extends JSimpleCommand {
    public static final UploadPictures INSTANCE = new UploadPictures();
    private UploadPictures() {
        super(SimpleSendPhoto.INSTANCE, "添加图片");

        setDescription("添加图片到指定图库");
        setPrefixOptional(true);
    }

    @Handler
    public void onCommand(CommandSender sender, String name, Image image1) throws Exception {
        savePictures.SavePicture(image1,name);
    }
}
