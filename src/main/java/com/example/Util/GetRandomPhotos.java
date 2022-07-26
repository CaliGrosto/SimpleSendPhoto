package com.example.Util;

import com.example.Config.config;

import java.io.File;
import java.util.Random;

public class GetRandomPhotos {

    public static String getPhotoName(String PicturePath) {//随机获取文件夹内图片路径

        //String picturePath = config.INSTANCE.getPicturePath();//文件夹路径

        File file = new File(PicturePath);
        File[] array = file.listFiles();
        int NumberOfPhotos = array.length;//有多少个文件

        Random random = new Random();
        int RandomPhotos = random.nextInt(0, NumberOfPhotos);//[0,NumberOfPhotos)

        String randomName = String.valueOf(array[RandomPhotos]);
        return randomName;
    }

//    @Test
//    public void test(){
//        getPhotoName();
//    }
}
