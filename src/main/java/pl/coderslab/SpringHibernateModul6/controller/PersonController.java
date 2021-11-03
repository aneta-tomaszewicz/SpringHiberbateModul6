package pl.coderslab.SpringHibernateModul6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.SpringHibernateModul6.dao.PersonDao;
import pl.coderslab.SpringHibernateModul6.entity.Person;
import pl.coderslab.SpringHibernateModul6.entity.PersonDetails;

@Controller
@RequestMapping("/person")
public class PersonController {
    private final PersonDao personDao;


    public PersonController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping("/form")
    public String showForm(Model model){
        model.addAttribute("person", new Person());
        return "person/personForm";
    }
    @PostMapping("/form")
    @ResponseBody
    public String saveForm(@ModelAttribute("person") Person testPerson){
        personDao.persist(testPerson);
        return "Dane zostaly zapisane";
    }



//Metody poniżej do obsługi @RequestParam
    /*@GetMapping("/form")
    public String showForm(){
        return "person/personForm";
    }

    @PostMapping("/form")
    @ResponseBody
    public  String saveForm(@RequestParam String login, @RequestParam String password, @RequestParam String email){
        Person person = new Person();
        person.setLogin(login);
        person.setPassword(password);
        person.setEmail(email);
        personDao.persist(person);
        return "Dane zostaly zapisane";}*/


    @RequestMapping("/add")
    @ResponseBody
    public String persist(){
    PersonDetails personDetails = new PersonDetails();
    personDetails.setFirstName("Jan");
    personDetails.setLastName("Nowak");
    personDetails.setStreetNumber("22e");
    personDetails.setStreet("Aluzyjna");
    personDetails.setCity("Warszawa");

    Person person = new Person();
    person.setLogin("Janek");
    person.setPassword("hasło");
    person.setEmail("janek@wp.pl");
    person.setPersonDetails(personDetails);
    personDao.persist(person);

    return "Dodano użytkownika ";
    }

    @GetMapping ("/find/{id}")
    @ResponseBody
    public String findById(@PathVariable("id") long id){
        Person person = personDao.findById(id);
        return person.toString();
    }

    @GetMapping("/update/{id}")
    @ResponseBody
    public String update(@PathVariable("id") long id){
        Person person = personDao.findById(id);
        person.setPassword("nowe hasło");
        person.getPersonDetails().setFirstName("Eugeniusz");
        personDao.update(person);
        return "Zaktualizowano osobę o id " + id;
    }

    @GetMapping("/remove/{id}")
    @ResponseBody
    public String remove(@PathVariable("id")long id){
        Person person = personDao.findById(id);
        personDao.remove(person);
        return "Usunieto osobę o id "+id;
    }


}
