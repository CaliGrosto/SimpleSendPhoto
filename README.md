# SimpleSendPhoto

## 一个简单的自定义随机发图插件(Mirai)
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
SavePicture: 'data/Picture/SavePicture.jpg'     #默认不要修改
```

  在群聊中发送   
"来点 XX涩图"   
就可以获得相应图片的标题作者和图片链接(通过loliconapi获取)
