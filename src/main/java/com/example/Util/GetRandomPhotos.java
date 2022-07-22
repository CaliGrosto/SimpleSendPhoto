package com.example.Util;

import com.example.Config.config;

import java.io.File;

public class GetRandomPhotos {

    public static String getPhotoName(String PicturePath) {//随机获取文件夹内图片路径

        //String picturePath = config.INSTANCE.getPicturePath();//文件夹路径

        File file = new File(PicturePath);
        File[] array = file.listFiles();
        int NumberOfPhotos = array.length;//有多少个文件
        double RandomPhotos = Math.random() * (NumberOfPhotos - 1);
        //System.out.println(array[(int)RandomPhotos]);
        String randomName = String.valueOf(array[(int) RandomPhotos]);
        return randomName;
    }

//    @Test
//    public void test(){
//        getPhotoName();
//    }
}
