package org.apply.methods.webdemodiary.controller;

import lombok.RequiredArgsConstructor;
import org.apply.methods.webdemodiary.model.City;
import org.apply.methods.webdemodiary.model.Person;
import org.apply.methods.webdemodiary.repository.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("persons")
public class PersonController {

    private final PersonRepository personRepository;

    @GetMapping
    public String getPerson(Model model) {
        model.addAttribute("persons", personRepository.findAll());
        return "person";
    }

    @PostMapping("add_person")
    public String addCity(@RequestParam("person") String personName) {
        if (StringUtils.hasText(personName)) {
            Person person = new Person();
            person.setFirstName(personName); // Удаляем лишние пробелы
            person.setLastName(personName);
            person.setCity(new City(1L));// Удаляем лишние пробелы
            personRepository.save(person);
        }
        return "redirect:/persons"; // Перенаправляем на главную страницу или другую страницу после добавления
    }
}
