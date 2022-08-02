package com.example.Util;

import com.example.Config.config;
import net.mamoe.mirai.message.data.Image;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.example.Util.Https.readInputStream;

public class savePictures {
    public static void SavePicture(Image image,String name) throws Exception {
        String ImageURL = Image.queryUrl(image);
        URL url = new URL(ImageURL);
        //打开连接
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestProperty("referer",""); //这是破解防盗链添加的参数
        conn.addRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36 Edg/91.0.864.67");
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(10 * 1000);
        InputStream is = conn.getInputStream();
        byte[] data = readInputStream(is);

        String savePicture = config.INSTANCE.getPicturePath4();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(savePicture)
                .append("/")
                .append(name)
                .append(".jpg");
        String news = String.valueOf(stringBuilder);//构建路径

        File imageFile = new File(news);
        FileOutputStream outStream = new FileOutputStream(imageFile);
        outStream.write(data);
        outStream.close();
    }

    public static boolean FileExists(String FilePath){//文件是否存在
        File file = new File(FilePath);
        if (file.exists()){
            return true;
        }else {
            return false;
        }
    }
}
