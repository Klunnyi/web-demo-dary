package org.apply.methods.webdemodiary.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apply.methods.webdemodiary.model.City;
import org.apply.methods.webdemodiary.service.CityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("cities")
public class CityController {

    private final CityService cityService;

    @GetMapping
    public String getCities(Model model) {
        model.addAttribute("cities", cityService.findAll());
        return "cities";
    }

    @PostMapping("add_city")
    public String addCity(@RequestParam("city") String cityName) {
        if (StringUtils.hasText(cityName)) {
            City city = new City();
            city.setName(cityName.trim()); // Удаляем лишние пробелы
            cityService.save(city);
        }
        return "redirect:/cities"; // Перенаправляем на главную страницу или другую страницу после добавления
    }
}
