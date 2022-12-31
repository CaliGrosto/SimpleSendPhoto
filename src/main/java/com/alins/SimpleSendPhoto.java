package com.alins;

import com.alins.Command.LotteryCommand;
import com.alins.Command.SeTuCommand;
import com.alins.Command.UploadPictures;
import com.alins.Config.config;
import com.alins.Util.Listener;
import net.mamoe.mirai.console.command.CommandManager;
import net.mamoe.mirai.console.plugin.jvm.JavaPlugin;
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescriptionBuilder;

public final class SimpleSendPhoto extends JavaPlugin {
    public static final SimpleSendPhoto INSTANCE = new SimpleSendPhoto();

    private SimpleSendPhoto() {
        super(new JvmPluginDescriptionBuilder("com.alins.SimpleSendPhoto", "2.0")
                .name("SimpleSendPhoto")
                .author("Alin")
                .build());
    }

    @Override
    public void onEnable() {
        reloadPluginConfig(config.INSTANCE);
        Listener.AllStart();
        CommandManager.INSTANCE.registerCommand(SeTuCommand.INSTANCE, false);
        CommandManager.INSTANCE.registerCommand(UploadPictures.INSTANCE,false);
        CommandManager.INSTANCE.registerCommand(LotteryCommand.INSTANCE,false);
        getLogger().info("SimpleSendPhotos插件加载完毕！");
    }
}