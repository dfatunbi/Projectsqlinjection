package sql;

import java.util.List;

/**
 * Created by h on 15-10-21.
 */
public interface TestDao {

    List findByName(String name);

    List nativeFindByName(String name);

    void init();
}
