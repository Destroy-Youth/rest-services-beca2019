package mx.com.axity.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users", schema = "public")
public class UserDO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UsersSeq")
    @SequenceGenerator(name = "UsersSeq",
            sequenceName = "users_id_seq",
            allocationSize = 1)
    @Column(name = "id")
    private Long id;
    @Column(name = "ds_name")
    private String name;
    @Column(name = "ds_lastname")
    private String lastName;
    @Column(name = "age")
    private int age;
    @OneToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "login",
            referencedColumnName = "id")
    private
    LoginDO loginDO;


    protected UserDO() {
    }

    public UserDO(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LoginDO getLoginDO() {
        return loginDO;
    }

    public void setLoginDO(LoginDO loginDO) {
        this.loginDO = loginDO;
    }
}
