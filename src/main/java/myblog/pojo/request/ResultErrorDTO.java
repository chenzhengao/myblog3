package myblog.pojo.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.sql.Date;
import java.sql.Timestamp;

/**
*   系统发生异常时，错误信息封装类
* @Author:         chenzhengao
* @CreateDate:     2019/3/29 10:39
*/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultErrorDTO {
    /**
     * 响应状态码
     */
    private Integer status;
    /**
     * 异常主要信息
     */
    private String errMsg;
    /**
     * 全部异常信息
     */
    private String allInfo;

    /**
     * 当前时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT-8")
    private Timestamp currentTime;
    /**
     * 发生错误的URL
     */
    private String URL;

    public Timestamp getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Timestamp currentTime) {
        this.currentTime = currentTime;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
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

    @Override
    public String toString() {
        return "ResultErrorDTO{" +
                "status=" + status +
                ", errMsg='" + errMsg + '\'' +
                ", allInfo='" + allInfo + '\'' +
                ", currentTime=" + currentTime +
                ", URL='" + URL + '\'' +
                '}';
    }
}