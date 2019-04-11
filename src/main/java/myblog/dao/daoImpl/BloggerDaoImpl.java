package myblog.dao.daoImpl;

import myblog.dao.BloggerDao;
import myblog.pojo.BloggerEntity;
import myblog.pojo.Page;
import myblog.pojo.RolePomission;
import myblog.pojo.UserRole;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

//用于将数据访问层 (DAO 层 ) 的类标识为 Spring Bean
@Repository("BloggerDao")
@Transactional
public class BloggerDaoImpl extends BaseDaoImpl<BloggerEntity,Integer> implements BloggerDao {


    @Override
    public Page getBloggersByPage(Page page, BloggerEntity bloggerEntity) {
        Session session=getSession();
        DetachedCriteria criteria=DetachedCriteria.forClass(BloggerEntity.class);

        if(bloggerEntity!=null&&bloggerEntity.getName()!=null){
            //姓名使用模糊匹配
            criteria.add(Restrictions.like("name",bloggerEntity.getName()));
        }

        List<BloggerEntity> list= criteria.getExecutableCriteria(session).setFirstResult(page.getStartNum()).setMaxResults(page.getEndNum()).list();

        Query query= session.createSQLQuery("select count(1) from blogger ");
        BigInteger count=(BigInteger)query.uniqueResult();
        return null;
    }

    @Override
    public List<BloggerEntity> getBloggers(BloggerEntity bloggerEntity) {
        Session session=getSession();
        DetachedCriteria criteria=DetachedCriteria.forClass(BloggerEntity.class);

        if(bloggerEntity!=null&&bloggerEntity.getName()!=null){
            //姓名使用模糊匹配
            criteria.add(Restrictions.like("name",bloggerEntity.getName()));
        }

        return criteria.getExecutableCriteria(session).list();
    }

    /**
     * 获得用户存在角色
     * @param name
     * @return
     */
    @Override
    public List<String> getRolesByName(String name) {
        Session session=getSession();
        String sql="select role_name from user_role where user_name=?";
        return session.createSQLQuery(sql).setParameter(0,name).list();
    }

    /**
     * 获得用户存在角色
     * @param name
     * @return
     */
    @Override
    public List<String> getPermissoinsByName(String name) {
        Session session=getSession();
        String sql="select permission_name FROM role_pomission t left join  user_role d on t.role_name=d.role_name where d.user_name=?";
        return session.createSQLQuery(sql).setParameter(0,name).list();
    }
}
