package myblog.service.serviceImpl;

import lombok.Data;
import myblog.dao.BaseDao;
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
public class BloggerServiceImpl extends BaseServiceImpl<BloggerEntity,Integer> implements BloggerService {

    //注入dao
    @Override
    @Resource(name = "BloggerDao")
    public void setDao(BaseDao<BloggerEntity,Integer> dao){
        super.setDao(dao);
    }


}
