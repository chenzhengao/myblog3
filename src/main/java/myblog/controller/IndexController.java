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
import java.util.List;
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
        bloggerEntity.setName("666");
        bloggerEntity.setNickname("陈振高");
        bloggerEntity.setPsw("123");
        bloggerEntity.setCreatetime(new Date(System.currentTimeMillis()));
        bloggerService.save(bloggerEntity);

        List<BloggerEntity> list=bloggerService.findAll();
        System.out.println(list.size());

        //bloggerService.delete(bloggerService.findByOne(1));
    }
}
