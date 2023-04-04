package com.alins.Config

import net.mamoe.mirai.console.data.AutoSavePluginConfig
import net.mamoe.mirai.console.data.ValueDescription
import net.mamoe.mirai.console.data.value

/**
 *@author Alin
 *@date 2023/1/23
 */
object Ascii2dConfig : AutoSavePluginConfig("Ascii2dConfig"){
    @ValueDescription("ͼƬ����·��")
    var WinParentDirectory : String by value("data\\SSPpic\\")
    var LinuxParentDirectory : String by value("data/SSPpic/")
    @ValueDescription("������������")
    var SearchNumber : Int by value(3)
}