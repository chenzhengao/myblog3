package myblog.controller;

import myblog.service.serviceImpl.UploadService;
import myblog.util.ImageUtil;
import myblog.util.UserUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

/**
*   图片控制类
* @Author:         chenzhengao
* @CreateDate:     2019/4/2 15:42
*/
@RestController
@RequestMapping("/image")
public class ImageController {

    @Resource(name="uploadService")
    private UploadService uploadService;

    @RequestMapping(value="/geticons",method = RequestMethod.GET)
    public void getIcons(HttpServletRequest request, HttpServletResponse response) {
        try {
            FileInputStream is = new FileInputStream("C:\\Users\\97948\\Desktop\\demo.jpg");
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
    public void getImages(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException{
        UserUtil.showUserImage(response,session);
    }

    @RequestMapping(value = "/getImageFile",method = RequestMethod.POST)
    public void getImageFile(@RequestParam("imgFile") MultipartFile image)throws IOException{
        InputStream is=image.getInputStream();
        int i = is.available();
        byte data[] = new byte[i];
        is.read(data);
        is.close();

        System.out.println(image.getName());

    }

    /**
     * 图片保存在服务器形式
     * @param file
     * @param session
     * @return
     */
    @RequestMapping(value = "/getThumbnial",method = RequestMethod.POST)
    public ModelAndView getYhumbnial(@RequestParam("imgFile")CommonsMultipartFile file,HttpSession session){
        //相对路径
        String uploadPath="/image";
        //绝对路径
        String realPath=session.getServletContext().getRealPath(uploadPath);

        //原图路径
        String imgPath=ImageUtil.uploadImage(file,uploadPath,realPath);
        //缩略图路径
        String thumbImgPath=ImageUtil.thumbnailImage(file,uploadPath,realPath);;


        ModelAndView result=new ModelAndView();
        result.addObject("imgPath",imgPath);
        result.addObject("thumbImgPath",thumbImgPath);
        result.setViewName("thunmbImg");
        return result;
    }

    @RequestMapping(value = "/test")
    public void test(HttpSession session){

        File file=new File("C:\\Users\\97948\\Desktop\\demo.jpg");
        //相对路径
        String uploadPath="/image";
        //绝对路径
        String realPath=session.getServletContext().getRealPath(uploadPath);
        System.out.println("真实路径："+realPath);
        uploadService.imagemark(file,file.getName(),uploadPath,realPath);
    }



}
