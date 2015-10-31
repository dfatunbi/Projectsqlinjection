package sql;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import java.util.List;

/**
 * Created by h on 15-10-25.
 */
public class HibernateTemplateExt extends HibernateTemplate implements IHibernateTemplate {

    public HibernateTemplateExt() {
        super();
    }

    public HibernateTemplateExt(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public <T> List<T> nativeFind(final String queryString,
                                  final Object[] paramValues, final Class<T> entityClass) {
        return (List<T>) execute(new HibernateCallback() {
            public Object doInHibernate(Session session)
                    throws HibernateException {
                Query queryObject = session.createSQLQuery(queryString);
                QueryHelper.setResultTransformer(entityClass, queryObject);
                QueryHelper.setQueryParams(paramValues, queryObject);
                return queryObject.list();
            }
        });
    }

}
