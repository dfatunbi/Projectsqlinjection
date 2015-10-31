package sql;

import org.springframework.orm.hibernate4.HibernateOperations;

import java.util.List;

/**
 * Created by h on 15-10-25.
 */
public interface IHibernateTemplate extends HibernateOperations {

    public <T> List<T> nativeFind(final String queryString, final Object[] paramValues, final Class<T> entityClass);
}
