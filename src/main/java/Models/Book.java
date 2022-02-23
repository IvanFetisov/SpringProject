package Models;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Data
@Entity
@EntityScan
public class Book{
    @Id
    private String name;
    @ManyToOne
    @JoinColumn(name = "personName")
    private Person person;

    public void removePerson(){
        this.person = null;
    }
    public Book(){

    }
}