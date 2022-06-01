package com.example.Config

import net.mamoe.mirai.console.data.AutoSavePluginConfig
import net.mamoe.mirai.console.data.value

object PhotoPath : AutoSavePluginConfig("config"){
    var PicturePath : String by value("");
}