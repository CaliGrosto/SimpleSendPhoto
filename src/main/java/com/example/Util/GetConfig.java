package com.example.Util;

import com.example.Config.config;

public class GetConfig {
    public static String GetPicturePath(String picturePath){//修正路径格式
        String c = String.valueOf(picturePath.charAt(picturePath.length()-1));
        if (c.equals("/") || c.equals("\\")){
            return picturePath.substring(0,picturePath.length()-1);
        }else{
            return picturePath;
        }
    }
}
