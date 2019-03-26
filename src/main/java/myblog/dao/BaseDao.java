package myblog.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T ,PK extends Serializable> {
    public PK save(T t);
    public void saveAll(List<T> ts);
    public T update(T t);
    public void delete(T t);
    public void deleteAll(List<T> ts);
    public  T findByOne(PK id);
    public List<T> findAll();
    public T saveOrUpdate(T t);
    public boolean deleteById(PK id);
}
