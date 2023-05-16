package main.market.Entity;



import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "marketUser")
public class MarketUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    @Column(unique = true,nullable = false)
    private String login;

    public String getLogin(){
        return this.login;
    }
    public void setLogin(String login){
        this.login = login;
    }

    @NotNull
    @Size(min = 5, max = 100)
    @Column(name = "password", length = 100)
    private String password;

    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }


    @Column(nullable = false)
    private String name;

    public String getName(){
        return  this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Column(nullable = false)
    private String surname;

    public String getSurname(){
        return this.surname;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    @Column(nullable = false, unique = true)
    @Email
    private String email;

    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    @Column(name = "active")
    private Boolean active=false;
    public Boolean getActive(){
        return this.active;
    }
    public void setActive(Boolean active){
        this.active = active;
    }


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "JointRoles",
            joinColumns = {@JoinColumn(name = "marketUser", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_name", referencedColumnName = "name")}
    )
    private Set<Role> role = new HashSet<>();

    public void setRole(Set<Role> role) {
        this.role = role;
    }

    public Set<Role> getRole() {
        return role;
    }
}
