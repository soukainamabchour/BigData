package org.mabchour.cities.Controllers;

import org.mabchour.cities.Models.City;
import org.mabchour.cities.Repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @RequestMapping(value = "/cities", method = RequestMethod.GET)
    public String cities(Model model,
                         @RequestParam(name = "page", defaultValue = "0") int page,
                         @RequestParam(name = "size", defaultValue = "100") int size,
                         @RequestParam(name = "name", defaultValue = "") String name) {
        Page<City> cityPage = cityRepository.findByNameContainsIgnoreCase(name, PageRequest.of(page,size));
        model.addAttribute("result", cityPage.getTotalElements());
        model.addAttribute("cityList", cityPage.getContent());
        model.addAttribute("pages", new int[cityPage.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("name", name);
        model.addAttribute("size", size);
        return "cities";
    }

    @RequestMapping(value = "/deleteCity", method = RequestMethod.POST)
    public String deleteCity(String id, int page, int size, String name) {
        cityRepository.deleteById(id);
        return "redirect:/cities?page=" + page + "&size=" + size + "&name=" + name + "";
    }

    @RequestMapping(value = "/formCity", method = RequestMethod.GET)
    public String formCity(Model model) {
        model.addAttribute("city", new City());
        return "formCity";
    }

    @RequestMapping(value = "editCity", method = RequestMethod.GET)
    public String editCity(Model model, String id) {
        City city = cityRepository.findById(id).get();
        System.out.println(id);
        model.addAttribute("city", city);
        return "formCity";
    }

    @PostMapping(value = "saveCity")
    public String saveCity(City city, BindingResult bindingResult, Model model) {
        model.addAttribute("saved", city);
        if (bindingResult.hasErrors()) return "formCity";
        cityRepository.save(city);
        return "confirmationCity";

    }
}
