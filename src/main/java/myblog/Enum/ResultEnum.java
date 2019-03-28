package myblog.Enum;

public enum ResultEnum {
    SUCCESS(0,"请求成功"),
    TEST(501,"测试使用")
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
