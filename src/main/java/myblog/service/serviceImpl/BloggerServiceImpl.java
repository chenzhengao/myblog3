package myblog.service.serviceImpl;

import lombok.Data;
import myblog.dao.BaseDao;
import myblog.dao.BloggerDao;
import myblog.pojo.BloggerEntity;
import myblog.pojo.Page;
import myblog.pojo.RolePomission;
import myblog.pojo.UserRole;
import myblog.service.BloggerService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service("bloggerService")
@Data
@Transactional
public class BloggerServiceImpl extends BaseServiceImpl<BloggerEntity,Integer> implements BloggerService {


    private BloggerDao bloggerDao;
    {
        bloggerDao=(BloggerDao)getBaseDao();
    }

    //注入dao
    @Override
    @Resource(name = "BloggerDao")
    public void setDao(BaseDao<BloggerEntity,Integer> dao){
        super.setDao(dao);
    }


    @Override
    public Page getBloggersByPage(Page page, BloggerEntity bloggerEntity) {
        bloggerDao.getBloggersByPage(page,bloggerEntity);
        return null;
    }

    @Override
    public List<BloggerEntity> getBloggers(BloggerEntity bloggerEntity) {
        return bloggerDao.getBloggers(bloggerEntity);
    }

    @Override
    public List<String> getRolesByName(String name) {
        return bloggerDao.getRolesByName(name);
    }

    @Override
    public List<String> getPermissoinsByName(String name) {
        return bloggerDao.getPermissoinsByName(name);
    }
}
