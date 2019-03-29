package myblog.util;

import javax.servlet.http.HttpServletRequest;

/**
*   Http工具类：获得Http相关信息
* @Author:         chenzhengao
* @CreateDate:     2019/3/29 11:55
*/
public class HttpUtil {

    /**
     * 获得完整访问路径
     * @param request
     * @return
     */
    public static String getFullURL(HttpServletRequest request){
        String url=request.getScheme() +"://" + request.getServerName()
                + ":" +request.getServerPort()+ request.getServletPath();

        if (request.getQueryString() != null){
            url += "?" + request.getQueryString();
        }
        return url;
    }
}
