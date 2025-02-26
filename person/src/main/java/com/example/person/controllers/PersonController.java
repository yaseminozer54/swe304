package com.example.person.controllers;

import com.example.person.models.Person;
import com.example.person.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    private PersonService personService;

    // Show list of all persons
    @GetMapping
    public String getAllPersons(Model model) {
        model.addAttribute("persons", personService.getAllPeople());
        return "person_list"; // Returns person_list.html
    }

    // Show form to add a new person
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("person", new Person());
        return "person_form"; // Returns person_form.html
    }

    // Save or update person
    @PostMapping("/save")
    public String savePerson(@ModelAttribute Person person) {
        personService.savePerson(person);
        return "redirect:/persons";
    }

    // Show form to update a person
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Integer id, Model model) {
        Person person = personService.getPersonById(id).orElseThrow(() -> new RuntimeException("Person not found"));
        model.addAttribute("person", person);
        return "person_form"; // Returns person_form.html
    }

    // Delete a person
    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable Integer id) {
        personService.deletePerson(id);
        return "redirect:/persons";
    }
}
