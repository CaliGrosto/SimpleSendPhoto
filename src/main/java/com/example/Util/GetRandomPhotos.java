package com.example.Util;


import java.io.File;
import java.util.Random;

public class GetRandomPhotos {
    //随机获取文件夹内图片路径
    public static String getPhotoName(String PicturePath) {

        //String picturePath = config.INSTANCE.getPicturePath();//文件夹路径

        File file = new File(PicturePath);
        File[] array = file.listFiles();
        int NumberOfPhotos = array.length;//有多少个文件

        Random random = new Random();
        int RandomPhotos = random.nextInt(NumberOfPhotos);//[0,NumberOfPhotos)

        String randomName = String.valueOf(array[RandomPhotos]);
        return randomName;
    }

    //随机获取有范围限制的图片路径
    public static String getRangePicture(int head,int last,String PicturePath){
        File file = new File(PicturePath);
        File[] array = file.listFiles();
        int NumberOfPhotos = array.length;//有多少个文件
        if (NumberOfPhotos < last){
            return "no";
        }else {
            Random random = new Random();
            int RandomPhotos = random.nextInt(last-(head-1)+1)+(head-1);

            String randomName = String.valueOf(array[RandomPhotos]);
            StringBuilder stringBuilder = new StringBuilder();

            return randomName;
        }
    }

//    @Test
//    public void test(){
//        getPhotoName();
//    }
}
