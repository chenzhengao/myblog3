import java.util.Timer;

/**
 * @program: myblog3
 * @description: test
 * @author: czg
 * @create: 2019-04-17 13:48
 */
public class TimerTest {
    public static void main(String[] args){
        Timer timer=new Timer();
        myTimerTask mytimerTask=new myTimerTask();
        //延迟两秒后执行，每三秒重复一次
        //timer.schedule(mytimerTask,2000,3000);
        //存在并发可能
        timer.scheduleAtFixedRate(mytimerTask,2000,3000);
    }
}
