package myblog.util;

import myblog.Enum.ResultEnum;
import myblog.pojo.request.ResultDTO;

/**
 * 构造返回模型的工具类
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
     * 自定义异常情况：自定义code,msg,用于校验提示语
     * @param object
     * @return
     */
    public static ResultDTO customExceptionResult(ResultEnum resultEnum,Object object){
        ResultDTO resultDTO=new ResultDTO();
        resultDTO.setCode(resultEnum.getCode());
        resultDTO.setMsg(resultEnum.getMsg());
        resultDTO.setData(object);
        return  resultDTO;
    }


    /**
     * 程序发生异常情况：程序发生异常，用于抛出异常
     * @param object
     * @return
     */
    public static ResultDTO errResult(ResultEnum resultEnum,Object object){
        ResultDTO resultDTO=new ResultDTO();
        resultDTO.setCode(resultEnum.getCode());
        resultDTO.setMsg(resultEnum.getMsg());
        resultDTO.setData(object);
        //请求成功标志为false
        resultDTO.setSuccessFlag(SUCCESSFLAG);
        return  resultDTO;
    }
}
