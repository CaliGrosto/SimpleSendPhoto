package com.example;

import com.example.Config.PhotoPath;
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
        reloadPluginConfig(PhotoPath.INSTANCE);
        new Listener().GroupPicture();
        getLogger().info("Plugin loaded!");
    }
}