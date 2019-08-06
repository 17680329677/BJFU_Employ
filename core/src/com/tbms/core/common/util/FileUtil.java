package com.tbms.core.common.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.UUID;

public class FileUtil {
    public static boolean upload(MultipartFile file, String path){
        if (file.isEmpty()) {
            return false;
        }
        File dest = new File(path);
        //判断文件父目录是否存在
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdirs();
        }
        try {
            //保存文件
            file.transferTo(dest);
            return true;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String getFileName(String userName,String fileName){
       String filepath =  Calendar.getInstance().get(Calendar.YEAR)+"/"+userName;
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 生成新的文件名
        String realPath = filepath+ "/" +userName+"_"+ UUID.randomUUID().toString().substring(0,8)+suffixName;
        return realPath;
    }

    public static boolean deleteFile(String fileName){
        File file = new File(fileName);
        if(!file.exists()){
            return false;
        }
        try{
            file.delete();
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean checkSuffix(String suffixName) {
        Boolean flag =false;
        //图片格式
        String[] FILETYPES = new String[]{
                ".jpg", ".bmp", ".jpeg", ".png", ".gif","pdf",
                ".JPG", ".BMP", ".JPEG", ".PNG", ".GIF","PDF"
        };
        if(suffixName!=null){
            for (int i = 0; i < FILETYPES.length; i++) {
                String fileType = FILETYPES[i];
                if (suffixName.endsWith(fileType)) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }
}
