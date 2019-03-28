package myblog.exception;

import lombok.Data;
import myblog.Enum.ResultEnum;
/**
* 自定义异常类：用于业务提示需要，一般只对RuntimeException进行事务回滚，所以这里继承RuntimeException
* @Author:         chenzhengao
* @CreateDate:     2019/3/28 10:51
*/
@Data
public class BusinessMessageException extends RuntimeException {

    private Integer code;

    private String msg;

    public BusinessMessageException(Integer code,String msg){
        super(msg);
        this.code=code;
        this.msg=msg;
    }
    public BusinessMessageException(ResultEnum resultEnum){
        this(resultEnum.getCode(),resultEnum.getMsg());
    }
}
