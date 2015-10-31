package sql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by h on 15-10-21.
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_id", length = 40)
    private String id;

    @Column(name = "user", length = 100)
    private String user;


    @Column(name = "password", length = 100)
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
