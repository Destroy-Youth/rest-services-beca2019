package mx.com.axity.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "login", schema = "public")
public class LoginDO implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "LoginSeq")
    @SequenceGenerator(name = "LoginSeq",
            sequenceName = "login_id_seq",
            allocationSize = 1)
    @Column(name = "id")
    private
    Long id;
    @Column(name = "username")
    private
    String username;
    @Column(name = "password")
    private
    String password;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
