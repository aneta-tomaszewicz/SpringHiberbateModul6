package pl.coderslab.SpringHibernateModul6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.SpringHibernateModul6.dao.AuthorDao;
import pl.coderslab.SpringHibernateModul6.entity.Author;
import pl.coderslab.SpringHibernateModul6.entity.Book;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/author")
public class AuthorController {
    private final AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @RequestMapping("/create")
    @ResponseBody
    public String persist(){
        Author author = new Author();
        author.setFirstName("Maria");
        author.setLastName("Konopnicka");
        authorDao.persist(author);
        return author.toString();
    }
    @RequestMapping("/find/{id}")
    @ResponseBody
    public String findAuthorById(@PathVariable long id) {
        Author author = authorDao.findById(id);
        return author.toString();
    }

    @RequestMapping("/update/{id}/{firstName}")
    @ResponseBody
    public String update(@PathVariable long id, @PathVariable String firstName) {
        Author author = authorDao.findById(id);
        author.setFirstName("Mariola");
        authorDao.update(author);
        return author.toString();
    }

    @RequestMapping("/remove/{id}")
    @ResponseBody
    public String remove(@PathVariable long id) {
        authorDao.remove(id);
        return "Autor usunięty";
    }

    @RequestMapping("/all")
    @ResponseBody
    public String findAll(){
        List<Author>allAuthors = authorDao.findAll();
        return allAuthors.stream()
                .map(author -> author.getId() + " "+author.getFirstName()+ " "+author.getLastName())
                .collect(Collectors.joining("<br/>"));
    }



}
