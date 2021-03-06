package myblog.util;

import myblog.Enum.ResultEnum;
import myblog.exception.BusinessMessageException;
import myblog.pojo.request.ResultDTO;
import myblog.pojo.request.ResultErrorDTO;

import java.sql.Timestamp;

/**
*   构造返回模型的工具类
* @Author:         chenzhengao
* @CreateDate:     2019/3/29 11:31
*/
public class ResultDTOUtil {

    //请求异常标志
    private  static final Boolean SUCCESSFLAG=false;


    /**
     * 一般成功情况下：无返回值
     * @return
     */
    public static ResultDTO successResult(){
        return  successResult(null);
    }
    /**
     * 一般成功情况下
     * @param object
     * @return
     */
    public static ResultDTO successResult(Object object){
        ResultDTO resultDTO=new ResultDTO();
        resultDTO.setCode(ResultEnum.SUCCESS.getCode());
        resultDTO.setMsg(ResultEnum.SUCCESS.getMsg());
        resultDTO.setData(object);
        return  resultDTO;
    }

    /**
     * 自定义异常情况：自定义code,msg,用于校验提示语 -无返回数据
     * @return
     */
    public static ResultDTO customExceptionResult(BusinessMessageException e){
        return  customExceptionResult(e,null);
    }

    /**
     * 自定义异常情况：自定义code,msg,用于校验提示语
     * @param object
     * @return
     */
    public static ResultDTO customExceptionResult(BusinessMessageException e, Object object){
        ResultDTO resultDTO=new ResultDTO();
        resultDTO.setCode(e.getCode());
        resultDTO.setMsg(e.getMsg());
        resultDTO.setData(object);
        return  resultDTO;
    }


    /**
     * 程序发生异常情况：程序发生异常，用于抛出异常
     * @param errCode
     * @param errmsg
     * @param allMsg
     * @return
     */
    public static ResultDTO errResult(Integer errCode,String errmsg,String allMsg,String url){
        ResultDTO resultDTO=new ResultDTO();
        //请求成功标志为false
        resultDTO.setSuccessFlag(SUCCESSFLAG);
        //填写系统异常时，异常信息
        ResultErrorDTO err=new ResultErrorDTO();
        err.setStatus(errCode);
        err.setErrMsg(errmsg);
        err.setAllInfo(allMsg);
        err.setCurrentTime(new Timestamp(System.currentTimeMillis()));
        err.setURL(url);

        resultDTO.setErr(err);
        return  resultDTO;
    }
}
