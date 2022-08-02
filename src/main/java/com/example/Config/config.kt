package com.example.Config

import net.mamoe.mirai.console.data.AutoSavePluginConfig
import net.mamoe.mirai.console.data.ValueDescription
import net.mamoe.mirai.console.data.value

object config : AutoSavePluginConfig("config"){
    var PicturePath : String by value("请修改")
    var Trigger : String by value("请修改")
    var PicturePath2 : String by value("请修改")
    var Trigger2 : String by value("请修改")
    var PicturePath3 : String by value("请修改")
    var Trigger3 : String by value("请修改")
    var Trigger4 : String by value("请修改")//群内添加图库
    @ValueDescription("存放群内通过指令添加的图片路径")
    var PicturePath4 : String by value("请修改")//群内添加
    @ValueDescription("图片缓存路径，默认不要修改")
    var SavePicture : String by value("data/Picture/SavePicture.jpg")
}