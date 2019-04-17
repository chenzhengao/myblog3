package myblog.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @program: myblog3
 * @description: 定时任务测试
 * @author: czg
 * @create: 2019-04-16 18:27
 */
@Component
public class FlightTrainTask {
    @Scheduled(cron = "0/5 * * * * ? ") // 间隔5秒执行
    public void taskCycle() {
        System.out.println("使用SpringMVC框架配置定时任务");
    }
}
