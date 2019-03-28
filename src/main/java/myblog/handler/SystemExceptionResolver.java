package myblog.handler;




import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.handler.HandlerResolver;
import java.io.IOException;
import java.io.PrintWriter;

/**
*  基于xml配置：全局异常处理
* @Author:         chenzhengao
* @CreateDate:     2019/3/28 11:54
*/
public class SystemExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object handler, Exception ex) {
        ex.printStackTrace();
        //向前台返回错误信息
        try {
            PrintWriter writer=response.getWriter();
            writer.println(ex.getMessage());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
