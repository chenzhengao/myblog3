package myblog.service.serviceImpl;

import lombok.Data;
import myblog.dao.BloggerDao;
import myblog.pojo.BloggerEntity;
import myblog.service.BloggerService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service("bloggerService")
@Data
@Transactional
public class BloggerServiceImpl implements BloggerService {

    @Resource(name = "BloggerDao")
    private BloggerDao bloggerDao;

    @Override
    public void save(BloggerEntity bloggerEntity) {
         bloggerDao.save(bloggerEntity);
    }
}
