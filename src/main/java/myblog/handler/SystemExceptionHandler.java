package myblog.handler;

import myblog.exception.BusinessMessageException;
import myblog.pojo.request.ResultDTO;
import myblog.util.ExceptionUtil;
import myblog.util.ResultDTOUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
*   基于注解：全局异常处理
* @Author:         chenzhengao
* @CreateDate:     2019/3/28 11:54
*/
@ControllerAdvice
public class SystemExceptionHandler {

    public static final Logger logger=LoggerFactory.getLogger(SystemExceptionHandler.class);

    /**
     * 可预知的业务需要的异常处理
     * @param request
     * @param response
     * @param e
     * @return
     */
    @ExceptionHandler({BusinessMessageException.class})
    @ResponseBody
    public ResultDTO businessExceptionHandle(HttpServletRequest request, HttpServletResponse response, BusinessMessageException e){
        ResultDTO resultDTO=ResultDTOUtil.customExceptionResult(e);
        return resultDTO;
    }

    /**
     * 无法预知的异常处理
     * @param request
     * @param response
     * @param e
     * @return
     */
    @ExceptionHandler({Exception.class})
    @ResponseBody
    public ResultDTO handle(HttpServletRequest request, HttpServletResponse response, Exception e){

        ResultDTO resultDTO=ResultDTOUtil.errResult(response.getStatus(),e.getMessage(), ExceptionUtil.getExceptionAllInformation(e),request.getRequestURI());
        return resultDTO;
    }
}
