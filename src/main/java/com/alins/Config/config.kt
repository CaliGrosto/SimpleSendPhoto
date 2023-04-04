package com.alins.Config

import net.mamoe.mirai.console.data.AutoSavePluginConfig
import net.mamoe.mirai.console.data.ValueDescription
import net.mamoe.mirai.console.data.value

object config : AutoSavePluginConfig("config"){
    @ValueDescription("图片路径")
    var PicturePath : List<String> by value()
    @ValueDescription("触发词")
    var Trigger : List<String> by value()
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
    @ValueDescription("搜索涩图功能冷却时间，默认为30秒")
    var SearchCD : Int by value(30)
    @ValueDescription("自定义图库发图冷却时间，默认10秒")
    var selfPicCD : Int by value(10);
    @ValueDescription("冷却期提示语句")
    var cdPointOut : String by value("太快啦┻┳|･ω･)")
}