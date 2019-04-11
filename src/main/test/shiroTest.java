import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

/**
 * @program: myblog3
 * @description: shiro测试
 * @author: czg
 * @create: 2019-04-10 16:14
 */
public class shiroTest {

    SimpleAccountRealm simpleAccountRealm=new SimpleAccountRealm();

    @Before
    public void addUser(){
        //admin角色
        simpleAccountRealm.addAccount("123","123","admin","test");
    }

    @Test
    public void test(){
        //shiro认证测试
        DefaultSecurityManager defaultSecurityManager=new DefaultSecurityManager();
        defaultSecurityManager.setRealm(simpleAccountRealm);

        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject=SecurityUtils.getSubject();

        UsernamePasswordToken token=new UsernamePasswordToken("123","123");

        subject.login(token);

        subject.checkRoles("admin1");
        //获得认证结果
        //subject.isAuthenticated();
    }
}
