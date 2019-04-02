package myblog.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
*   图片控制类
* @Author:         chenzhengao
* @CreateDate:     2019/4/2 15:42
*/
@RestController
@RequestMapping("/image")
public class ImageController {

    @RequestMapping(value="/geticons",method = RequestMethod.GET)
    public void getIcons(HttpServletRequest request, HttpServletResponse response) {
        try {
            FileInputStream is = new FileInputStream("C:\\Users\\chenzhengao\\Desktop\\demo.jpg");
            // 得到文件大小
            int i = is.available();
            byte data[] = new byte[i];
            is.read(data);
            is.close();
            // 设置返回的文件类型
            response.setContentType("image/*");
            // 得到向客户端输出二进制数据的对象
            OutputStream toClient = response.getOutputStream();
            // 输出数据
            toClient.write(data);
            toClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value="/getimages",method = RequestMethod.GET)
    public void getImages(byte[] contents,HttpServletRequest request, HttpServletResponse response){
        ServletOutputStream out = null;
            try {
                System.out.println("内容是:"+contents.length);
                InputStream is = new ByteArrayInputStream(contents);
                response.setContentType("image/*");
                out = response.getOutputStream();
                int len=0;
                byte[] buf=new byte[1024];
                while((len=is.read(buf,0,1024))!=-1){
                    out.write(buf, 0, len);
                }

                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

    }
}
