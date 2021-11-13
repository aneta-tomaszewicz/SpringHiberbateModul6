package pl.coderslab.SpringHibernateModul6.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.SpringHibernateModul6.entity.Author;
import pl.coderslab.SpringHibernateModul6.entity.Book;
import pl.coderslab.SpringHibernateModul6.entity.Publisher;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
public class ValidationController {

    private final Validator validator;


    public ValidationController(Validator validator) {
        this.validator = validator;
    }

    @GetMapping("/validate")
    @ResponseBody
    public String validate(){
        Book book = new Book();
        book.setTitle("aaa");
        book.setRating(15);
        book.setPages(0);

        Set<ConstraintViolation<Book>> validationResult = validator.validate(book);
        if(!validationResult.isEmpty()){
            for (ConstraintViolation<Book>singleError : validationResult){
                System.out.println("Błąd !!!  " + singleError.getPropertyPath()+ ": " + singleError.getMessage());
            }
            return "Encja nie jest poprawna";
        } else {
            return "Encja jest poprawna ";
        }

    }
    @GetMapping("/validate/author")
    @ResponseBody
    public String validateAuthor(){
        Author author = new Author();
  /*      author.setFirstName("");
        author.setLastName("");*/
        author.setPesel("87025545");
        author.setEmail("aneta");

        Set<ConstraintViolation<Author>> validationResult = validator.validate(author);
        if(!validationResult.isEmpty()){
            for (ConstraintViolation<Author>singleError : validationResult){
                System.out.println("Błąd !!!  " + singleError.getPropertyPath()+ ": " + singleError.getMessage());
            }
            return "Encja nie jest poprawna";
        } else {
            return "Encja jest poprawna ";
        }

    }

    @GetMapping("/validate/publisher")
    @ResponseBody
    public String validatePublisher(){
        Publisher publisher = new Publisher();

        publisher.setNip("5486");
        publisher.setRegon("88888");

        Set<ConstraintViolation<Publisher>> validationResult = validator.validate(publisher);
        if(!validationResult.isEmpty()){
            for (ConstraintViolation<Publisher>singleError : validationResult){
                System.out.println("Błąd !!!  " + singleError.getPropertyPath()+ ": " + singleError.getMessage());
            }
            return "Encja nie jest poprawna";
        } else {
            return "Encja jest poprawna ";
        }

    }
}
