package com.alins.Util;


import com.alins.Config.config;
import net.mamoe.mirai.contact.Contact;
import net.mamoe.mirai.event.events.MessageEvent;
import net.mamoe.mirai.message.data.Image;
import net.mamoe.mirai.utils.ExternalResource;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.Random;

public class SendPicUtil {
    /**
     *
     * @param PicPath 图片文件夹路径
     * @return 文件数量
     */
    public static int getFilePathLength(String PicPath){
        File file = new File(PicPath);
        File[] files = file.listFiles();
        int length = 0;
        if (files != null) {
            length = files.length;
        }
        return length;
    }

    /**
     *  无放回采样1
     * @param length 多少张照片
     * @return 对应的长度数组
     */
    public static int[] generateRandomArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = i + 1;
        }
        Random random = new Random();
        for (int i = length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return array;
    }

    /**
     * 无放回采样2
     * @param PicPath 图片路径
     * @return
     */
    public static int[] GetRandomArray(String PicPath){
        File file = new File(PicPath);
        File[] files = file.listFiles();
        int length = 0;
        if (files != null) {
            length = files.length;
        }
        //取一个无重复的length以内所有整数的随机数组
        return generateRandomArray(length);
    }

    public static void SendNoPutBackPic(int[] ints,int number,String PicPath,MessageEvent event){
        File file = new File(PicPath);
        File[] files = file.listFiles();
        File file1 = null;
        if (files != null) {
            file1 = files[ints[number]-1];
        }
        String FileName = String.valueOf(file1);
        Image image = ExternalResource.uploadAsImage(new File(FileName), event.getSubject());
        event.getSubject().sendMessage(image);
    }













    /**
     *  有放回采样
     * @param PicturePath 图库路径
     * @return 图片文件名称
     */
    public static String getPhotoName(String PicturePath) {


        File file = new File(PicturePath);
        File[] array = file.listFiles();
        int NumberOfPhotos = 0;//有多少个文件
        if (array != null) {
            NumberOfPhotos = array.length;
        }

        Random random = new Random();
        int RandomPhotos = random.nextInt(NumberOfPhotos);//[0,NumberOfPhotos)

        return String.valueOf(array[RandomPhotos]);
    }

    /**
     *  发送图片
     * @param path:图片路径
     * @param event:传入MessageEvent
     */
    public static void SendPic(String path,@NotNull MessageEvent event){
        Image image = ExternalResource.uploadAsImage(new File(path), event.getSubject());
        event.getSubject().sendMessage(image);
    }

    /**
     *  获取Image对象
     * @param path  图片路径
     * @param event Event
     * @return image对象
     */
    public static Image getImageObject(String path, @NotNull Contact event){
        return ExternalResource.uploadAsImage(new File(path), event);
    }

    /**
     * 以有放回采样形式发送图片
     * @param path:图片路径
     * @param event:传入MessageEvent
     * @author Alin
     * date:
     */
    public static void SendRandomPic(String path, @NotNull MessageEvent event){
        String filename = SendPicUtil.getPhotoName(path);//取随机图片
        SendPic(filename,event);
    }
}
