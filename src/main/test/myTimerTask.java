import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimerTask;

/**
 * @program: myblog3
 * @description: mytimerTask定时任务
 * @author: czg
 * @create: 2019-04-17 13:50
 */
public class myTimerTask extends TimerTask {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar=Calendar.getInstance();
        System.out.println("myTimerTask run 当前时间："+sf.format(calendar.getTime()));
    }
}
