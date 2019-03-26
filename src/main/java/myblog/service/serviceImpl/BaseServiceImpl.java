package myblog.service.serviceImpl;

import myblog.dao.BaseDao;
import myblog.service.BaseService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

@Transactional
public class BaseServiceImpl<T,PK extends Serializable> implements BaseService<T,PK> {

    private BaseDao<T,PK> baseDao;

    @Resource
    public void setDao(BaseDao<T,PK> dao){
        this.baseDao=dao;
    }

    @Override
    public PK save(T t) {
        return baseDao.save(t);
    }

    @Override
    public void saveAll(List<T> list) {
        baseDao.saveAll(list);

    }

    @Override
    public T update(T t) {
        return baseDao.update(t);
    }

    @Override
    public void delete(T t) {
        baseDao.delete(t);

    }

    @Override
    public void deleteAll(List<T> list) {
        baseDao.deleteAll(list);
    }

    @Override
    public T findByOne(PK id) {
        return baseDao.findByOne(id);
    }

    @Override
    public List<T> findAll() {
        return baseDao.findAll();
    }

    @Override
    public T saveOrUpdate(T t) {
        return baseDao.saveOrUpdate(t);
    }

    @Override
    public boolean deleteById(PK id) {
        return baseDao.deleteById(id);
    }
}
