package pl.coderslab.SpringHibernateModul6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.SpringHibernateModul6.dao.PublisherDao;
import pl.coderslab.SpringHibernateModul6.entity.Publisher;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/publisher")
public class PublisherController {
    private final PublisherDao publisherDao;

    public PublisherController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }
    @RequestMapping("/create")
    @ResponseBody
    public String persist(){
        Publisher publisher = new Publisher();
        publisher.setName("PWN");
        publisherDao.persist(publisher);
        return publisher.toString();
    }
    @RequestMapping("find/{id}")
    @ResponseBody
    public String findPublisherById(@PathVariable long id){
        Publisher publisher =publisherDao.findById(id);
        return publisher.toString();
    }
    @RequestMapping("/update/{id}/{name}")
    @ResponseBody
    public String update(@PathVariable long id, @PathVariable String name){
        Publisher publisher = publisherDao.findById(id);
        publisher.setName("Ppp");
        publisherDao.update(publisher);
        return publisher.toString();
    }
    @RequestMapping("/remove/{id}")
    @ResponseBody
    public String remove(@PathVariable long id){
        publisherDao.remove(id);
        return "Wydawca o id: " +id+" usunięty";
    }

    @RequestMapping("/all")
    @ResponseBody
    public String findAll(){
        List<Publisher>publishers = publisherDao.findAll();
        return publishers.stream()
                .map(Publisher::getName)
                .collect(Collectors.joining("<br/>"));
    }


}
