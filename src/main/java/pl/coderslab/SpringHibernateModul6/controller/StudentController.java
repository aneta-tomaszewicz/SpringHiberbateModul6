package pl.coderslab.SpringHibernateModul6.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.SpringHibernateModul6.model.Student;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/new")
    public String showStudentForm(Model model){
        model.addAttribute("student", new Student());
        return "student/studentForm";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student){
        return "student/savedStudent";
    }



    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }

    @ModelAttribute("programmingSkills")
    public List<String> programmingSkills() {
        return Arrays.asList("Java", "PHP", "C++", "Phyton", ".NET");
    }
    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        return Arrays.asList("football", "basketball", "chess", "reading books", "dancing");
    }




}
