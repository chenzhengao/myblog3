package myblog.util;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @program: myblog3
 * @description: 图片处理工具类
 * @author: czg
 * @create: 2019-04-07 15:42
 */
public class ImageUtil {

    /**
     * 原图保存地址
     * @param file
     * @param uploadPath 相对路径
     * @param realPath  绝对路径
     * @return
     */
    public static String uploadImage(CommonsMultipartFile file,String uploadPath,String realPath){
        InputStream inp=null;
        OutputStream out=null;

        try {
            inp=file.getInputStream();
            out=new FileOutputStream(realPath+"/"+file.getOriginalFilename());

            byte[] buff=new byte[1024];
            int len=0;
            while ((len=inp.read(buff))>0){
                out.write(buff);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return uploadPath+"/"+file.getOriginalFilename();
    }

    /**
     * 缩略图地址
     * @param file
     * @param uploadPath
     * @param realPath
     * @return
     */
    public static String thumbnailImage(CommonsMultipartFile file,String uploadPath,String realPath){

        String thunmName=realPath+"/"+"thum_"+file.getOriginalFilename();

        try {
            Thumbnails.of(file.getInputStream()).size(100, 100).toFile(thunmName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return uploadPath+"/"+"thum_"+file.getOriginalFilename();
    }
}
