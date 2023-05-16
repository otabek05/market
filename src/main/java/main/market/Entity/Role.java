package main.market.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
@Entity
public class Role implements Serializable {

    @Id
    @Column(nullable = false , unique = true)
    private String name;

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name= name;
    }


}