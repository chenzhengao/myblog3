package myblog.handler;

import myblog.pojo.request.ResultDTO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理
 */
@ControllerAdvice
public class SystemExceptionHandler {

    @ExceptionHandler({Exception.class})
    @ResponseBody
    public ResultDTO handle(HttpServletRequest request, HttpServletResponse response,Exception e){
       return null;
    }
}
