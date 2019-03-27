package myblog.pojo.request;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 返回模型：返回前台数据格式统一
 */
//注解作用：字段为null时，不返回前台
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultDTO<T> {
    //编号:枚举中定义的编号
    private Integer code;
    //提示信息:枚举中定义的提示信息
    private String msg;
    //接口调用成功标志 用于区分自定义异常及程序异常标志，默认为true，程序异常时为false
    private Boolean successFlag=true;
    //成功返回数据
    private T data;
    //系统发生异常时，需要收集的数据，默认为null
    private ResultErrorDTO err=null;

    public ResultErrorDTO getErr() {
        return err;
    }

    public void setErr(ResultErrorDTO err) {
        this.err = err;
    }

    public Boolean getSuccessFlag() {
        return successFlag;
    }

    public void setSuccessFlag(Boolean successFlag) {
        this.successFlag = successFlag;
    }

    public Integer getCode() {

        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return "ResultDTO{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", successFlag=" + successFlag +
                ", data=" + data +
                '}';
    }

    public void setData(T data) {
        this.data = data;
    }


}
