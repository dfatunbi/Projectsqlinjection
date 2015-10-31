package sql;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * Created by h on 15-10-21.
 */
@Repository
public class TestDaoImpl implements TestDao {

    private IHibernateTemplate hibernateTemplate;

    @Resource
    public void setHibernateTemplate(IHibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    private SessionFactory sessionFactory;

    @Resource
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List findByName(String name) {
        if (name == null) {
            return hibernateTemplate.find("from TestEntity");
        } else {
            return hibernateTemplate.find("from TestEntity where name = '" + name + "'");
        }
    }

    public List nativeFindByName(String name) {
        if (name == null) {
            return hibernateTemplate.nativeFind("select * from TEST_ENTITY", null, TestEntity.class);
        } else {
            return hibernateTemplate.nativeFind("select * from TEST_ENTITY  where name = '" + name + "'", null, TestEntity.class);
        }
    }


    public void init() {
        TestEntity entity = new TestEntity();
        entity.setId(UUID.randomUUID().toString());
        entity.setName("test");
        hibernateTemplate.save(entity);
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setUser("admin");
        user.setPassword("5f4dcc3b5aa765d61d8327deb882cf99");
        hibernateTemplate.save(user);
        user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setUser("gordonb");
        user.setPassword("e99a18c428cb38d5f260853678922e03");
        hibernateTemplate.save(user);
    }
}
