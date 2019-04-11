package myblog.service;

import myblog.pojo.BloggerEntity;
import myblog.pojo.Page;
import myblog.pojo.RolePomission;
import myblog.pojo.UserRole;

import java.util.List;

public interface BloggerService extends  BaseService<BloggerEntity,Integer>{

    public Page getBloggersByPage(Page page, BloggerEntity bloggerEntity);

    public List<BloggerEntity> getBloggers(BloggerEntity bloggerEntity);

    public  List<String> getRolesByName(String name);

    public List<String> getPermissoinsByName(String name);

}
