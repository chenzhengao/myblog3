package myblog.controller;

import lombok.Data;
import myblog.Enum.ResultEnum;
import myblog.exception.BusinessMessageException;
import myblog.pojo.BloggerEntity;
import myblog.pojo.Page;
import myblog.pojo.request.ResultDTO;
import myblog.service.BloggerService;

import myblog.util.ResultDTOUtil;
import myblog.util.UserUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@RestController
public class IndexController {

    @Resource(name = "bloggerService")
    private BloggerService bloggerService;



    //具备admin角色才可以访问
    @RequiresRoles("admin")
    //具备user:select权限才可以访问,一般使用这种方式
    @RequiresPermissions("user:select")
    @RequestMapping("/test")
    public ModelAndView test(){
        ModelAndView m=new ModelAndView();
        m.addObject("test1","Hello SpringMvc");
        m.setViewName("imagedemo");
        return m;
    }

    /**
     * 图片转为二进制保存到数据库
     * @return
     * @throws Exception
     */
    @RequestMapping("/save")
    public BloggerEntity save() throws Exception{
        /*FileInputStream is = new FileInputStream("C:\\Users\\97948\\Desktop\\demo.jpg");
        // 得到文件大小
        int i = is.available();
        byte data[] = new byte[i];
        is.read(data);

       BloggerEntity bloggerEntity=new BloggerEntity();
       bloggerEntity.setName("hhhh");
       bloggerEntity.setNickname("czg");
       bloggerEntity.setPsw("123");
       bloggerEntity.setCreatetime(new Timestamp(System.currentTimeMillis()));
       bloggerEntity.setImage(data);

       bloggerService.save(bloggerEntity);
        is.close();*/

        List<BloggerEntity> list=bloggerService.findAll();
        //throw new NullPointerException();

        //System.out.println(list.size());
        return list.get(0);
        //bloggerService.delete(bloggerService.findByOne(1));
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResultDTO login(BloggerEntity bloggerEntity,HttpSession session){

        Subject subject=SecurityUtils.getSubject();

        UsernamePasswordToken token=new UsernamePasswordToken(bloggerEntity.getName(),bloggerEntity.getPsw());

        subject.login(token);
        //如果登录成功
        if(subject.isAuthenticated()){
            System.out.println("登录成功！");
            session.setAttribute(UserUtil.SESSION_USER,bloggerEntity);
        }
        return null;
    }

    @RequestMapping("/demo")
    public ResultDTO demo(HttpSession session){
        BloggerEntity bloggerEntity=new BloggerEntity();
        bloggerEntity.setName("czg");

        Page page=new Page();
        page.setCurrentPage(1);
        bloggerService.getBloggersByPage(page,bloggerEntity);
        return null;
    }
}
