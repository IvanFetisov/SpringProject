package Controllers;
import Models.Book;
import Models.Person;
import Repositories.BookRepository;
import Repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@Controller
@ComponentScan
@RequiredArgsConstructor
@RequestMapping("/Book")
public class BookController {
    private final BookRepository bookRepo;
    private final PersonRepository personRepo;

    @GetMapping()
    public String main(Map<String,Object> map){
        map.put("books",bookRepo.findAll());
        return "book/rentedBook";
    }
    @GetMapping("/newBook")
    public String newBook (Map<String, Object> map){
        map.put("book",new Book());
        return "book/newBook";
    }
    @PostMapping("/newBook")
    public String create(@ModelAttribute("book")Book book){
        bookRepo.save(book);
        return "redirect:/book";
    }
  @DeleteMapping("/delete/{name}")
    public String delete(@PathVariable("name") String name){
        Person person = bookRepo.findByName(name).getPerson();
        person.removeBook(bookRepo.findByName(name));
        bookRepo.delete(bookRepo.findByName(name));
      return "redirect:/book";
    }

}

