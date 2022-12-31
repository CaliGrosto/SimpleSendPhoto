package com.alins.Config

import net.mamoe.mirai.console.data.AutoSavePluginConfig
import net.mamoe.mirai.console.data.ValueDescription
import net.mamoe.mirai.console.data.value

object config : AutoSavePluginConfig("config"){
    @ValueDescription("PicturePath1,2,3,4依次为图库1,2,3,4对应的触发词(Trigger)")
    var PicturePath : String by value("请修改")
    var Trigger : String by value("请修改")
    var PicturePath2 : String by value("请修改")
    var Trigger2 : String by value("请修改")
    var PicturePath3 : String by value("请修改")
    var Trigger3 : String by value("请修改")
    var Trigger4 : String by value("请修改")//群内添加图库
    @ValueDescription("可控范围图库路径")
    var RangePicturePath : String by value("请修改")
    @ValueDescription("可控范围图库触发语句")
    var RangeTrigger : String by value("请修改")
    @ValueDescription("存放群内通过指令添加的图片路径")
    var PicturePath4 : String by value("请修改")//群内添加
    @ValueDescription("图片缓存路径，默认不要修改")
    var LinuxSavePicture : String by value("data/sspPic/SavePicture.jpg")
    var WindowsSavePicture : String by value("data\\SSPpic\\SavePicture.jpg")
    @ValueDescription("0为不开启r18模式，1为只开启r18模式，2为混合模式")
    var r18 :String by value("0")
}