package com.alins;

import com.alins.Command.LotteryCommand;
import com.alins.Command.SeTuCommand;
import com.alins.Command.SearchMapCommand;
import com.alins.Command.UploadPictures;
import com.alins.Config.Ascii2dConfig;
import com.alins.Config.config;
import com.alins.Util.GroupEventListener;
import jdk.jpackage.internal.Log;
import net.mamoe.mirai.console.command.CommandManager;
import net.mamoe.mirai.console.plugin.jvm.JavaPlugin;
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescriptionBuilder;
import net.mamoe.mirai.event.GlobalEventChannel;

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
        reloadPluginConfig(Ascii2dConfig.INSTANCE);
        CommandManager.INSTANCE.registerCommand(SeTuCommand.INSTANCE, false);
        CommandManager.INSTANCE.registerCommand(UploadPictures.INSTANCE,false);
        CommandManager.INSTANCE.registerCommand(LotteryCommand.INSTANCE,false);
        CommandManager.INSTANCE.registerCommand(SearchMapCommand.INSTANCE,false);

        //群事件监听
        GlobalEventChannel.INSTANCE.registerListenerHost(new GroupEventListener());
        getLogger().info("群消息监听已启动");

        getLogger().info("SimpleSendPhotos插件加载完毕！");
    }
}