package com.example.Config

import net.mamoe.mirai.console.data.AutoSavePluginConfig
import net.mamoe.mirai.console.data.value

object config : AutoSavePluginConfig("config"){
    var PicturePath : String by value("")
    var Trigger : String by value("")
    var PicturePath2 : String by value("")
    var Trigger2 : String by value("")
    var PicturePath3 : String by value("")
    var Trigger3 : String by value("")
    var Trigger4 : String by value("")//群内添加图库
    var PicturePath4 : String by value("")//群内添加
    var SavePicture : String by value("data/Picture/SavePicture.jpg")
}