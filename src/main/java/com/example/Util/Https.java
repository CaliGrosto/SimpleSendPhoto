package com.example.Util;

import com.example.Config.config;
import com.google.gson.Gson;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Https {
    public static void downloadFile(String URL) throws  Exception {
            URL url = new URL(URL);
            //打开连接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("referer",""); //这是破解防盗链添加的参数
            conn.addRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36 Edg/91.0.864.67");
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(10 * 1000);
            InputStream is = conn.getInputStream();
            byte[] data = readInputStream(is);
            //创建一个文件对象用来保存图片，默认保存当前工程根目录，默认为data/Picture/SavePicture.jpg
            String savePicture = config.INSTANCE.getSavePicture();
            File imageFile = new File(savePicture);
            FileOutputStream outStream = new FileOutputStream(imageFile);
            outStream.write(data);
            outStream.close();
    }

    public static byte[] readInputStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[6024];
        int len;
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        inStream.close();
        return outStream.toByteArray();
    }
    public static String GetJson(String Keyword) {//获取Json
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://api.lolicon.app/setu/v2?tag=" + Keyword);
        CloseableHttpResponse execute = null;
        try {
            execute = httpClient.execute(httpGet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String s = null;
        if (execute.getStatusLine().getStatusCode() == 200) {
            try {
                s = EntityUtils.toString(execute.getEntity(), "utf-8");
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    if (httpClient != null) {
                        httpClient.close();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return s;
    }

    public static String GetPictureURL(String KeyWord) {//获取照片的URL
        String s = Https.GetJson(KeyWord);
        SaveJson saveJson = new Gson().fromJson(s, SaveJson.class);
        String urls = saveJson.getData().get(0).getUrls().getOriginal();
        return urls;
    }

    public static SaveJson GetJavaBean(String KeyWord){//获取SaveJson对象
        String s = Https.GetJson(KeyWord);
        SaveJson bean = new Gson().fromJson(s, SaveJson.class);
        return bean;
    }
}


