package com.example.Config

import net.mamoe.mirai.console.data.AutoSavePluginConfig
import net.mamoe.mirai.console.data.value

object config : AutoSavePluginConfig("config"){
    var PicturePath : String by value("");
    var Trigger : String by value("");
}