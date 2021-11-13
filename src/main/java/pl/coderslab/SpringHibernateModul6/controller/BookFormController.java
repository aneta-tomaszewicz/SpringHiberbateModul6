package pl.coderslab.SpringHibernateModul6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.SpringHibernateModul6.dao.AuthorDao;
import pl.coderslab.SpringHibernateModul6.dao.PublisherDao;
import pl.coderslab.SpringHibernateModul6.entity.Author;
import pl.coderslab.SpringHibernateModul6.entity.Book;
import pl.coderslab.SpringHibernateModul6.entity.Publisher;
import pl.coderslab.SpringHibernateModul6.repository.BookRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("book/form")
public class BookFormController {

    private PublisherDao publisherDao;
    private final BookRepository bookRepository;
    private AuthorDao authorDao;

    public BookFormController(PublisherDao publisherDao, BookRepository bookRepository, AuthorDao authorDao) {
        this.publisherDao = publisherDao;
        this.bookRepository = bookRepository;

        this.authorDao = authorDao;
    }

    @GetMapping("/all")
    public String showAllBooks(Model model){
        model.addAttribute("books", bookRepository.findAll());
        return "/book/listOfBook";
    }

    @GetMapping("/add")
    public String showBookForm(Model model){
        model.addAttribute("book", new Book());
        return "/book/bookForm";
    }
    @PostMapping("/add")
    public String saveBook(@ModelAttribute("book") @Valid Book book, BindingResult result){
        if(result.hasErrors()){
            return "/book/bookForm";
        }
        bookRepository.save(book);
        return "redirect:/book/form/all";
    }

    @GetMapping("/edit")
    public String prepareEdit(@RequestParam long idToEdit, Model model) {
        model.addAttribute("book", bookRepository.getById(idToEdit));
        return "book/bookForm";
    }

    @PostMapping("/edit")
    public String merge(@ModelAttribute("book") @Valid Book book, BindingResult result) {
        if(result.hasErrors()) {
            return "/book/bookForm";
        }
        bookRepository.save(book);
        return "redirect:/book/form/all";
    }

     @GetMapping("/remove")
    public String prepareRemove(@RequestParam long idToRemove, Model model){
        model.addAttribute("book", bookRepository.getById(idToRemove));
        return "book/removeBook";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam String confirmed,@RequestParam long idToRemove) {
        if ("yes".equals(confirmed)) {
            bookRepository.deleteById(idToRemove);
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
