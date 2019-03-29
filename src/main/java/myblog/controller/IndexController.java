package myblog.controller;

import lombok.Data;
import myblog.Enum.ResultEnum;
import myblog.exception.BusinessMessageException;
import myblog.pojo.BloggerEntity;
import myblog.pojo.request.ResultDTO;
import myblog.service.BloggerService;

import myblog.util.ResultDTOUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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



    @RequestMapping("/test")
    public ModelAndView test(){
        ModelAndView m=new ModelAndView();
        m.addObject("test1","Hello SpringMvc");
        m.setViewName("demo");
        return m;
    }

    @RequestMapping("/save")
    public BloggerEntity save(){
//        BloggerEntity bloggerEntity=new BloggerEntity();
//        bloggerEntity.setName("666");
//        bloggerEntity.setNickname("陈振高");
//        bloggerEntity.setPsw("123");
//        bloggerEntity.setCreatetime(new Timestamp(System.currentTimeMillis()));

        //bloggerService.save(bloggerEntity);

        List<BloggerEntity> list=bloggerService.findAll();
        //throw new NullPointerException();

        //System.out.println(list.size());
        return list.get(100);
        //bloggerService.delete(bloggerService.findByOne(1));
    }
}
