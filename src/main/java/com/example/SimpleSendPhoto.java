package com.example;

import com.example.Command.KeywordCommand;
import com.example.Config.config;
import net.mamoe.mirai.console.command.CommandManager;
import net.mamoe.mirai.console.plugin.jvm.JavaPlugin;
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescriptionBuilder;

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
        new Listener().GroupPicture();
        new Listener().GroupPicture2();
        new Listener().GroupPicture3();
        CommandManager.INSTANCE.registerCommand(KeywordCommand.INSTANCE, false);
        getLogger().info("SimpleSendPhoto loaded!");
    }
}