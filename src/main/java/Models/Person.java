package Models;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@EntityScan
public class Person {
@Id
private String name;
private int age;

@OneToMany
    private List<Book> rentedBooks;
public Person(){
    rentedBooks = new ArrayList<>();
}
public void addBook(Book book){
    this.rentedBooks.add(book);
}
public void removeBook(Book book){
    this.rentedBooks.remove(book);
}

}
