package pl.coderslab.SpringHibernateModul6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.SpringHibernateModul6.dao.AuthorDao;
import pl.coderslab.SpringHibernateModul6.entity.Author;

import javax.validation.Valid;

@Controller
@RequestMapping("author/form")
public class AuthorFormController {

    private final AuthorDao authorDao;

    public AuthorFormController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @GetMapping("/all")
    public String showAllAuthors(Model model){
        model.addAttribute("authors", authorDao.findAll());
        return "/author/listOfAuthors";
    }
    @GetMapping("/add")
    public String showAuthorForm(Model model){
        model.addAttribute("author", new Author());
        return "/author/authorForm";
    }
    @PostMapping("/add")
    public String saveAuthor(@ModelAttribute("author") @Valid Author author, BindingResult result){
        if(result.hasErrors()){
            return "/author/authorForm";
        }
        authorDao.persist(author);
        return "redirect:/author/form/all";
    }
    @GetMapping("/edit")
    public String prepareEdit(@RequestParam int idToEdit, Model model){
     model.addAttribute("author", authorDao.findById(idToEdit));
     return "author/authorForm";
    }
    @PostMapping("/edit")
    public String merge(@ModelAttribute("author")@Valid Author author, BindingResult result){
        if(result.hasErrors()) {
            return "/author/authorForm";
        }
        authorDao.update(author);
        return "redirect:/author/form/all";
    }
    @GetMapping("/remove")
    public String prepareRemove(@RequestParam int idToRemove, Model model){
        model.addAttribute("author", authorDao.findById(idToRemove));
        return "author/removeAuthor";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam String confirmed, @RequestParam int idToRemove){
        if ("yes".equals(confirmed)) {
            authorDao.remove(idToRemove);
        }
        return "redirect:/author/form/all";
    }























}
