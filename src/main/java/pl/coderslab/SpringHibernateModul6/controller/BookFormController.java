package pl.coderslab.SpringHibernateModul6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.SpringHibernateModul6.dao.AuthorDao;
import pl.coderslab.SpringHibernateModul6.dao.BookDao;
import pl.coderslab.SpringHibernateModul6.dao.PublisherDao;
import pl.coderslab.SpringHibernateModul6.entity.Author;
import pl.coderslab.SpringHibernateModul6.entity.Book;
import pl.coderslab.SpringHibernateModul6.entity.Publisher;

import java.util.List;

@Controller
@RequestMapping("book/form")
public class BookFormController {

    private PublisherDao publisherDao;
    private BookDao bookDao;
    private AuthorDao authorDao;

    public BookFormController(PublisherDao publisherDao, BookDao bookDao, AuthorDao authorDao) {
        this.publisherDao = publisherDao;
        this.bookDao = bookDao;
        this.authorDao = authorDao;
    }

    @GetMapping("/all")
    public String showAllBooks(Model model){
        model.addAttribute("books", bookDao.findAll());
        return "/book/listOfBook";
    }

    @GetMapping("/add")
    public String showBookForm(Model model){
        model.addAttribute("book", new Book());
        return "/book/bookForm";
    }
    @PostMapping("/add")
    public String saveBook(@ModelAttribute("book")Book book){
        bookDao.persist(book);
        return "redirect:/book/form/all";
    }

    @GetMapping("/edit")
    public String prepareEdit(@RequestParam int idToEdit, Model model) {
        model.addAttribute("book", bookDao.findById(idToEdit));
        return "book/bookForm";
    }

    @PostMapping("/edit")
    public String merge(@ModelAttribute("book") Book book) {
        bookDao.update(book);
        return "redirect:/book/form/all";
    }

     @GetMapping("/remove")
    public String prepareRemove(@RequestParam int idToRemove, Model model){
        model.addAttribute("book", bookDao.findById(idToRemove));
        return "book/removeBook";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam String confirmed,@RequestParam int idToRemove) {
        if ("yes".equals(confirmed)) {
            bookDao.remove(idToRemove);
        }
            return "redirect:/book/form/all";
    }

    @ModelAttribute("publishers")
    public List<Publisher> publishers(){
        return publisherDao.findAll();
    }
    @ModelAttribute("authors")
    public List<Author>authors(){
        return authorDao.findAll();
    }



}
