import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @program: myblog3
 * @description: jdbcRealm测试
 * @author: czg
 * @create: 2019-04-10 17:04
 */
public class jdbcRealmTest {


    @Test
    public void test(){

        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        DataSource dataSource=(DataSource)context.getBean("dataSource");

        JdbcRealm jdbcRealm=new JdbcRealm();
        jdbcRealm.setDataSource(dataSource);
        //设置权限查询开关，默认为FALSE
        jdbcRealm.setPermissionsLookupEnabled(true);

        String sql=" select psw from blogger where name=?";
        //设置校验密码sql
        jdbcRealm.setAuthenticationQuery(sql);

        String roleSQL="select role_name from user_role where user_name=?";
        //设置用户角色查询语句
        jdbcRealm.setUserRolesQuery(roleSQL);

        //设置权限查询语句
        String permissionSql="select permission_name from role_pomission where role_name=?";
        jdbcRealm.setPermissionsQuery(permissionSql);


        //shiro认证测试
        DefaultSecurityManager defaultSecurityManager=new DefaultSecurityManager();
        defaultSecurityManager.setRealm(jdbcRealm);


        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject=SecurityUtils.getSubject();

        UsernamePasswordToken token=new UsernamePasswordToken("hhhh","123");

        subject.login(token);

       //检查角色
        subject.checkRoles("test");
        //检查权限
        subject.checkPermission("user:select");
        //获得认证结果
        System.out.println("结果："+subject.isAuthenticated());
    }
}
