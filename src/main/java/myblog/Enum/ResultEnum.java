package myblog.Enum;
/**
*   返回参数枚举类
* @Author:         chenzhengao
* @CreateDate:     2019/3/29 12:00
*/
public enum ResultEnum {
    SUCCESS(0,"请求成功"),
    LOGINERR(401,"登录权限失效")
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
