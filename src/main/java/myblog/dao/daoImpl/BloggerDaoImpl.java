package myblog.dao.daoImpl;

import myblog.dao.BloggerDao;
import myblog.pojo.BloggerEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;

//用于将数据访问层 (DAO 层 ) 的类标识为 Spring Bean
@Repository("BloggerDao")
@Transactional
public class BloggerDaoImpl implements BloggerDao {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public void save(BloggerEntity bloggerEntity) {
        Session session= sessionFactory.getCurrentSession();
        session.save(bloggerEntity);
    }
}
