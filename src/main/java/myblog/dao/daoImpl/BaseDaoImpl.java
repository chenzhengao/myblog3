package myblog.dao.daoImpl;

import myblog.dao.BaseDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import javax.annotation.Resource;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class BaseDaoImpl<T,PK extends Serializable> implements BaseDao<T,PK> {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    private Class<T> clazz;

    /**
     * 通过构造方法指定DAO的具体实现类
     */
    public BaseDaoImpl() {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        clazz = (Class<T>) type.getActualTypeArguments()[0];
        System.out.println("DAO的真实实现类是：" + this.clazz.getName());
    }

    /**
     * 获得当前Session对象
     * @return
     */
    protected Session getSession(){
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public PK save(T t) {
        return (PK)this.getSession().save(t);
    }

    @Override
    public void saveAll(List<T> list) {
        for (T t:list){
            this.getSession().save(t);
        }
    }

    @Override
    public T update(T t) {
        this.getSession().update(t);
        return t;
    }

    @Override
    public void delete(T t) {
        this.getSession().delete(t);
    }

    @Override
    public void deleteAll(List<T> list) {
        for (T t:list){
            this.getSession().delete(t);
        }
    }

    @Override
    public T findByOne(PK id) {
        return this.getSession().find(clazz,id);
    }

    @Override
    public List<T> findAll() {
        CriteriaBuilder build = this.getSession().getCriteriaBuilder();
        CriteriaQuery<T> criteria = build.createQuery(clazz);
        criteria.from(clazz);
        Query query=this.getSession().createQuery(criteria);
        return (List<T>)query.getResultList();
    }

    @Override
    public T saveOrUpdate(T t) {
        this.getSession().saveOrUpdate(t);
        return t;
    }

    @Override
    public boolean deleteById(PK id) {
        T t=this.getSession().get(clazz,id);
        if(t==null){
            return false;
        }
        this.getSession().delete(t);
        return true;
    }
}
