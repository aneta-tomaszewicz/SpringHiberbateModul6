package pl.coderslab.SpringHibernateModul6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.SpringHibernateModul6.dao.PublisherDao;
import pl.coderslab.SpringHibernateModul6.entity.Publisher;

@Controller
@RequestMapping("/publisher/form")
public class PublisherFormController {

    private final PublisherDao publisherDao;

    public PublisherFormController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @GetMapping("/all")
    public String showAllPublishers(Model model){
        model.addAttribute("publishers", publisherDao.findAll());
        return "/publisher/listOfPublishers";
    }
     @GetMapping("/add")
    public String showPublisherForm(Model model){
        model.addAttribute("publisher", new Publisher());
         return "/publisher/publisherForm";
     }

    @PostMapping("/add")
    public String savePublisher(@ModelAttribute("publisher")Publisher publisher){
        publisherDao.persist(publisher);
        return "redirect:/publisher/form/all";
    }

    @GetMapping("/edit")
    public String prepareEdit(@RequestParam int idToEdit, Model model){
        model.addAttribute("publisher", publisherDao.findById(idToEdit));
        return "publisher/publisherForm";
    }
    @PostMapping("/edit")
    public String merge(@ModelAttribute("publisher") Publisher publisher){
        publisherDao.update(publisher);
        return "redirect:/publisher/form/all";
    }

    @GetMapping("/remove")
    public String prepareRemove(@RequestParam int idToRemove, Model model){
        model.addAttribute("publisher", publisherDao.findById(idToRemove));
        return "publisher/removPublisher";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam String confirmed, @RequestParam int idToRemove){
        if("yes".equals(confirmed)){
            publisherDao.remove(idToRemove);
        }
        return "redirect:/publisher/form/all";
    }


}
