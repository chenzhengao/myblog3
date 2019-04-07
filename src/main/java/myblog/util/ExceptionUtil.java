package myblog.util;

import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

/**
*   异常输出工具类
* @Author:         chenzhengao
* @CreateDate:     2019/3/29 11:30
*/
@Slf4j
public class ExceptionUtil {


    /**
     * 获得异常的错误信息，哪个类几行
     * @param ex
     * @return
     */
    public static String getErrorMessage(Exception ex){
        StackTraceElement[] st = ex.getStackTrace();
        StringBuilder messages=new StringBuilder("");
        for (StackTraceElement stackTraceElement : st) {
            String exclass = stackTraceElement.getClassName();
            String method = stackTraceElement.getMethodName();
            messages.append(new Date() + ":" + "[类:" + exclass + "]调用"
                    + method + "时在第" + stackTraceElement.getLineNumber()
                    + "行代码处发生异常!异常类型:" + ex.getClass().getName()+"\n");
        }
        log.warn(messages.toString());
        return messages.toString();
    }

    /**
     * 获得异常全部信息
     * @param ex
     * @return
     */
    public static String getExceptionAllInformation(Exception ex) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream pout = new PrintStream(out);
        ex.printStackTrace(pout);
        String ret = new String(out.toByteArray());
        pout.close();
        try {
            out.close();
        } catch (Exception e) {
        }
        return ret;
    }


    /**
     * 获得异常全部信息
     * @param e
     * @return
     */
    private static String toString(Throwable e){
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw, true);
        e.printStackTrace(pw);
        pw.flush();
        sw.flush();
        return sw.toString();
    }
}
