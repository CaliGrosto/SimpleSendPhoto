package com.example.Config

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
    var LinuxSavePicture : String by value("data/Picture/SavePicture.jpg")
    var WindowsSavePicture : String by value("data\\picture\\SavePicture.jpg")
    @ValueDescription("关键词搜图是否开启R18（0为关闭，1为开启，2为混合模式）")
    var R18 : String by value("0")
}