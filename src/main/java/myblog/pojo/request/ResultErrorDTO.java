package myblog.pojo.request;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 系统发生异常时，错误信息封装类
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultErrorDTO {
    //响应状态码
    private Integer status;
    //异常主要信息
    private String errMsg;
    //全部异常信息
    private String allInfo;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getAllInfo() {
        return allInfo;
    }

    public void setAllInfo(String allInfo) {
        this.allInfo = allInfo;
    }
}