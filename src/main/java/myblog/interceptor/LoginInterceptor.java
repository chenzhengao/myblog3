package myblog.interceptor;

import myblog.Enum.ResultEnum;
import myblog.exception.BusinessMessageException;
import myblog.pojo.BloggerEntity;
import myblog.util.UserUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: myblog3
 * @description: 登录拦截
 * @author: czg
 * @create: 2019-04-04 17:04
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        BloggerEntity bloggerEntity= (BloggerEntity) httpServletRequest.getSession().getAttribute(UserUtil.SESSION_USER);
        if(bloggerEntity!=null){
            return true;
        }else{
            //抛出登录异常信息
            throw new BusinessMessageException(ResultEnum.LOGINERR);
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
