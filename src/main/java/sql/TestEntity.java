package sql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by h on 15-10-21.
 */
@Entity
@Table(name = "TEST_ENTITY")
public class TestEntity {

    @Id
    @Column(name = "id", length = 40)
    private String id;

    @Column(name = "name", length = 255)
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
