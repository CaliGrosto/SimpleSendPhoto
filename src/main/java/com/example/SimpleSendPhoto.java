package com.example;

import com.example.Command.KeywordCommand;
import com.example.Command.LotteryCommand;
import com.example.Command.UploadPictures;
import com.example.Config.config;
import net.mamoe.mirai.console.command.CommandManager;
import net.mamoe.mirai.console.plugin.jvm.JavaPlugin;
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescriptionBuilder;

import java.util.List;

public final class SimpleSendPhoto extends JavaPlugin {
    public static final SimpleSendPhoto INSTANCE = new SimpleSendPhoto();

    private SimpleSendPhoto() {
        super(new JvmPluginDescriptionBuilder("com.example.SimpleSendPhoto", "1.0")
                .name("SimpleSendPhoto")
                .author("Alin")
                .build());
    }

    @Override
    public void onEnable() {
        reloadPluginConfig(config.INSTANCE);
        Listener.AllStart();
        CommandManager.INSTANCE.registerCommand(KeywordCommand.INSTANCE, false);
        CommandManager.INSTANCE.registerCommand(UploadPictures.INSTANCE,false);
        CommandManager.INSTANCE.registerCommand(LotteryCommand.INSTANCE,false);
        getLogger().info("SimpleSendPhoto loaded!");
    }
}