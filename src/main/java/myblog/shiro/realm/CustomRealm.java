package myblog.shiro.realm;

import myblog.dao.BloggerDao;
import myblog.pojo.BloggerEntity;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: myblog3
 * @description: 自定义realm
 * @author: czg
 * @create: 2019-04-10 17:54
 */
public class CustomRealm extends AuthorizingRealm {

    @Resource(name = "BloggerDao")
    private BloggerDao bloggerDao;

    private static final String REALM_NAME="CustomRealm";
    {
        //设置默认的REALM name
        super.setName(REALM_NAME);
    }

    /**
     * 授权模块
     * 设置用户角色及权限
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获得用户名
        String userName=(String)principalCollection.getPrimaryPrincipal();
        Set<String> roles=getRolesByUserName(userName);
        Set<String> permissions=getPermissionsByUserName(userName);

        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(roles);
        simpleAuthorizationInfo.setStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

    private Set<String> getPermissionsByUserName(String userName) {
        //查询数据设置进来
        return new HashSet<>(bloggerDao.getPermissoinsByName(userName));
    }

    private Set<String> getRolesByUserName(String userName) {
        //查询数据设置进来
        return  new HashSet<>(bloggerDao.getRolesByName(userName));
    }

    /**
     * 认证模块
     * 处理用户登录验证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username=(String) authenticationToken.getPrincipal();


        String psw=getPswByUserName(username);
        if(psw==null){
            //验证失败 返回null
            return null;
        }
        //验证成功后就返回一个正确的验证信息
        SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(username,psw,REALM_NAME);
        //设置盐
        simpleAuthenticationInfo.setCredentialsSalt(ByteSource.Util.bytes("sjs"));

        return simpleAuthenticationInfo;
    }

    /**
     * 判断密码是否一致
     * @param username
     * @return
     */
    private String getPswByUserName(String username) {
        BloggerEntity bloggerEntity=new BloggerEntity();
        bloggerEntity.setName(username);
        List<BloggerEntity> bloggerEntityList=bloggerDao.getBloggers(bloggerEntity);
        if(bloggerEntityList!=null&&bloggerEntityList.size()>0){
            return bloggerEntityList.get(0).getPsw();
        }
        return null;
    }

    public static void main(String agrs[]){
        //随机数作为盐 这里写死：sjs
        Md5Hash md5Hash=new Md5Hash("123","sjs");
        System.out.println(md5Hash.toString());

    }


}
