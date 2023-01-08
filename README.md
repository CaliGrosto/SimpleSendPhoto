# SimpleSendPhoto

## 一个简单的自定义随机发图插件(Mirai)
## JDK需求：jdk17
### 每在群中检测到一次触发语句，就会随机从图库文件夹中抽取一张图片发送回QQ群中
#### 可在配置文件中修改图片路径以及触发语句


第一次使用请先修改配置文件  
初次运行会生成配置文件：config/com.alins.SimpleSendPhoto/config.yml
```
# 图库路径
PicturePath: （路径必须带上单引号）
  - 'C:\Users\90899\Desktop\pictest'    图库1
  - 'C:\Users\90899\Desktop\pictest'    图库2（如若需要更多图库以及触发词可以照此格式自行添加）
# 触发词
Trigger: 
  - 测试1                               触发词1
  - 测试2                               触发词2（如若需要更多图库以及触发词可以照此格式自行添加）
# 可控范围图库路径
RangePicturePath: 请修改
# 可控范围图库触发语句
RangeTrigger: 请修改
# 存放群内通过指令添加的图片路径
PicturePath4: 请修改
# 图片缓存路径，默认不要修改
LinuxSavePicture: 'data/sspPic/SavePicture.jpg'
WindowsSavePicture: data\SSPpic\SavePicture.jpg
# 0为不开启r18模式，1为只开启r18模式，2为混合模式
r18: 0

```



（该功能需要插件chat-command支持）
[chat-command](https://github.com/project-mirai/chat-command)

  在群聊中发送   
"来点 XX涩图"   
就可以获得相应图片的标题作者和图片链接(通过loliconapi获取)
默认是没有权限的（除bot主人外）
下面附上Mirai权限管理相关指令：
```
/permission cancel <被许可人 ID> <权限 ID>   取消授权一个权限
/permission cancelall <被许可人 ID> <权限 ID>   取消授权一个权限及其所有子权限
/permission listpermissions    查看所有权限列表
/permission permit <被许可人 ID> <权限 ID>   授权一个权限
/permission permittedpermissions <被许可人 ID>   查看被授权权限列表
```
