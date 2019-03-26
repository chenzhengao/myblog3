package myblog.controller;

import lombok.Data;
import myblog.pojo.BloggerEntity;
import myblog.service.BloggerService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

@Data
@RestController
public class IndexController {

    @Resource(name = "bloggerService")
    private BloggerService bloggerService;

    @RequestMapping("/test")
    public ModelAndView test(){
        ModelAndView m=new ModelAndView();
        m.addObject("test1","Hello SpringMvc");
        m.setViewName("demo");
        return m;
    }

    @RequestMapping("/save")
    public void save(){
        BloggerEntity bloggerEntity=new BloggerEntity();
        bloggerEntity.setName("czg");
        bloggerEntity.setNickname("czg");
        bloggerEntity.setPsw("123");
        bloggerService.save(bloggerEntity);
        System.out.println("=============新增");
    }
}
