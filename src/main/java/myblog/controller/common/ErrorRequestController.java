package myblog.controller.common;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import myblog.pojo.request.ResultDTO;
import myblog.util.HttpUtil;
import myblog.util.ResultDTOUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
*   无效链接返回控制器
* @Author:         chenzhengao
* @CreateDate:     2019/3/29 14:32
*/
@Data
@RestController
@Slf4j
public class ErrorRequestController {

    //private static final Logger logger= LoggerFactory.getLogger(ErrorRequestController.class);

    /**
     * 声明错误返回状态码
     */
    public static final Integer ERR_STATUS=404;
    public static final String ERR_MESSAGE="请求不存在";
    /**
     * 利用springmvc的精确匹配，达到当访问不存在的链接时，统一返回固定数据
     * 精确匹配：存在对应链接时，就调用对应的链接，不然就调用'*'匹配的
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("*")
    public ResultDTO errPage(HttpServletRequest request, HttpServletResponse response){

        log.warn("请求不存在，请求链接：{}",HttpUtil.getFullURL(request));
        return ResultDTOUtil.errResult(ERR_STATUS,ERR_MESSAGE,ERR_MESSAGE, HttpUtil.getFullURL(request));
    }
}
