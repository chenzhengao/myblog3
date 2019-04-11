import myblog.shiro.realm.CustomRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

/**
 * @program: myblog3
 * @description: 自定义Realm测试
 * @author: czg
 * @create: 2019-04-10 17:53
 */
public class CustomRealmTest {

    @Test
    public void test(){

        CustomRealm customRealm=new CustomRealm();


        //shiro认证测试
        DefaultSecurityManager defaultSecurityManager=new DefaultSecurityManager();
        defaultSecurityManager.setRealm(customRealm);

        HashedCredentialsMatcher hashedCredentialsMatcher=new HashedCredentialsMatcher();

        //密码加密
        //设置加密算法名称
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        //设置加密次数
        hashedCredentialsMatcher.setHashIterations(1);
        //设置加密
        customRealm.setCredentialsMatcher(hashedCredentialsMatcher);

        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject=SecurityUtils.getSubject();

        UsernamePasswordToken token=new UsernamePasswordToken("czg","123");

        subject.login(token);

       /* //检查角色
        subject.checkRoles("test");
        //检查权限
        subject.checkPermission("user:select");*/
        //获得认证结果
        System.out.println("结果："+subject.isAuthenticated());
    }
}
