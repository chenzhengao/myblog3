package myblog.util;

import lombok.extern.slf4j.Slf4j;
import myblog.pojo.BloggerEntity;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @description: User工具类
 * @author: czg
 * @create: 2019-04-04 15:30
 */
@Slf4j
public class UserUtil {
    //session中的用户标志
    public static final String SESSION_USER="BLOGGER";
    //图片大小
    public static final Integer IMAGE_MAX_SIZE=1024;

    /**
     * 获得当前用户
     * @param session
     * @return
     */
    public static BloggerEntity getActiveUser(HttpSession session){
        return (BloggerEntity)session.getAttribute(SESSION_USER);
    }

    /**
     * 输出当前用户图片
     * @param response
     */
    public static void showUserImage(HttpServletResponse response,HttpSession httpSession) throws IOException {
        BloggerEntity user=getActiveUser(httpSession);
        log.info("-----当前用户为"+user.toString());
        if(user!=null&&user.getImage()!=null){
            log.info("------开始输出当前用户图片----");

            ServletOutputStream out = null;
            byte[] contents=user.getImage();

            InputStream is = new ByteArrayInputStream(contents);
            response.setContentType("image/*");
            out = response.getOutputStream();
            int len=0;
            byte[] buf=new byte[IMAGE_MAX_SIZE];
            while((len=is.read(buf,0,IMAGE_MAX_SIZE))!=-1){
                out.write(buf, 0, len);
            }
            out.flush();
            out.close();
        }else{
            log.info("------当前用户图片为空----");
        }
    }
}
