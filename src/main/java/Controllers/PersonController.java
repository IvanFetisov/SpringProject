package Controllers;

import Models.Book;
import Models.Person;
import Repositories.BookRepository;
import Repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import java.util.Map;

@Controller
@ComponentScan
@RequiredArgsConstructor
@RequestMapping("/person")
class PersonController {
    private final BookRepository bookRepo;
    private final PersonRepository personRepo;

    @GetMapping()
    public String main (Map<String,Object> map){
        map.put("persons", personRepo.findAll());
        return "person/mainPerson";
    }
    @GetMapping("/newPerson")
    public String newPerson(Map<String,Object> map){
        map.put("person",new Person());
        map.put("rentedBooks",bookRepo.findAll());
        return "person/newPerson";
    }
    @PostMapping("/newPerson")
    public String newPerson (@ModelAttribute("person") Person person){
        personRepo.save(person);
        return "redirect:/person";
    }
    @GetMapping("/edit/{name}")
    public String edit(@PathVariable("name") String name, Map<String,Object>map){
        map.put("person",personRepo.findByName(name));
        return "person/editPerson";
    }
    @PatchMapping("/book/{name}")
    public String update(@ModelAttribute("person") Person person ){
        personRepo.save(person);
        return "redirect:/person";
    }
    @GetMapping("/book/{name}")
    public String personBook(@PathVariable("name") String name, Map<String,Object> map){
    map.put("person",personRepo.findByName(name));
    map.put("rentedBooks", bookRepo.findAll());
    return "person/personBooks";
    }
    @PatchMapping("/book/{name}")
    public String createPersonPlaner(@PathVariable("name") String name, @RequestParam("book") List<String> book){
        Person person = personRepo.findByName(name);
        for(String el : book) {
            Book book1 = bookRepo.findByName(el);
            person.addBook(book1);
            book1.setPerson(person);
            bookRepo.save(book1);
        }
        personRepo.save(person);
        return "redirect:/person";
    }
    @DeleteMapping("/delete/{name}")
    public String delete(@PathVariable("name") String name){
        Person person = personRepo.findByName(name);
        if (person.getRentedBooks().size()>0)
        for (Book el : person.getRentedBooks()){
            el.removePerson();
        }
        personRepo.delete(person);
        return "redirect:/person";
    }
    @PatchMapping("/deleteBook/{name}")
    public String deleteBook(@PathVariable("name") String name, @RequestParam("rentedBooks")List<String> rentedBooks){
        Person person = personRepo.findByName(name);
        for(String el : rentedBooks){
            Book book = bookRepo.findByName(el);
            person.removeBook(book);
            book.removePerson();
            bookRepo.save(book);
        }
        personRepo.save(person);
        return "redirect:/person";
    }
    @GetMapping("/freePersons")
    public String freePersons(Map<String,Object>map){
        List<Person> list = new ArrayList<>();
        for (Person el : personRepo.findAll())
            if (el.getRentedBooks().size()<1)
                list.add(el);
            map.put("persons", list);
            return "person/mainPerson";
    }
    @GetMapping("/top")
    public String top(Map<String, Object> map){
        List<Person> allPerson = personRepo.findAll();
        List<Person> topPerson = new ArrayList<>();
        allPerson.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        if (allPerson.size()>=10)
            for (int i = 0 ; i < 10; i++){
                topPerson.add(allPerson.get(i));
                map.put("persons", topPerson);}
        else
                map.put("persons", allPerson);

        return"person/mainPerson";
        }

    }
