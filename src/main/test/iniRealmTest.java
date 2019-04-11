import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

/**
 * @program: myblog3
 * @description: Inirealm测试
 * @author: czg
 * @create: 2019-04-10 16:47
 */
public class iniRealmTest {


    @Test
    public void test(){

        IniRealm iniRealm=new IniRealm("classpath:user.ini");
        //shiro认证测试
        DefaultSecurityManager defaultSecurityManager=new DefaultSecurityManager();
        defaultSecurityManager.setRealm(iniRealm);


        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject=SecurityUtils.getSubject();

        UsernamePasswordToken token=new UsernamePasswordToken("mark","123456");

        subject.login(token);

        //检查角色
        subject.checkRoles("admin");
        //检查权限
        subject.checkPermission("user:update");
        //获得认证结果
        //subject.isAuthenticated();
    }
}
