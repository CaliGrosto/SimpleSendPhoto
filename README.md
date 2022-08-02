# SimpleSendPhoto

## 一个简单的自定义随机发图插件(Mirai)
## JDK需求：jdk17
### 每在群中检测到一次触发语句，就会随机从图库文件夹中抽取一张图片发送回QQ群中
#### 可在配置文件中修改图片路径以及触发语句


第一次使用请先修改配置文件  
初次运行会生成配置文件：config/com.example.SimpleSendPhoto/config.yml
```
PicturePath: ''      #存放图片文件夹路径
Trigger: ''          #触发语句
PicturePath2: ''     #存放图片文件夹路径2
Trigger2: ''         #触发语句2
PicturePath3: ''     #存放图片文件夹路径3
Trigger3: ''         #触发语句3

Trigger4: ''         #随机发送群内添加的图片触发词
PicturePath4: ''     #在群内使用添加指令添加的图片存放路径
#用法：/添加图片 （图片名称） （图片）

SavePicture: 'data/Picture/SavePicture.jpg'     #默认不要修改(这是存放lolicon api获取到的图片的文件路径)

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
