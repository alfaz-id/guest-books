package com.alfazid.guestbooks.controller;

import com.alfazid.guestbooks.model.Guest;
import com.alfazid.guestbooks.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;


@Controller
public class GuestController {
    @Autowired
    private GuestRepository guestRepository;

    @GetMapping("/")
    public ModelAndView getList(Model model){
        List<Guest> list = guestRepository.findAll();
        model.addAttribute("list", list);
        return new ModelAndView ("index");
    }

    @GetMapping("/param")
    public ModelAndView getListByName(Model model, @Param("name") String name){
        List<Guest> list;
        if(name.isEmpty()){
            list= guestRepository.findAll();
        }else{
            list= guestRepository.findByName(name);
        }
        model.addAttribute("list", list);
        return new ModelAndView ("index");
    }

    @GetMapping("/create")
    public ModelAndView create(Guest guest){
        return new ModelAndView ("create");
    }

    @PostMapping("/create")
    public ModelAndView insert(Guest guest){
        guestRepository.save(guest);
        return new ModelAndView ("redirect:/");
    }

    @GetMapping("/update/{id}")
    public ModelAndView edit(Model model,@PathVariable("id") Integer id){
        Optional<Guest> guestBooks = guestRepository.findById(id);
        if(guestBooks.isPresent()){
            model.addAttribute("guest",guestBooks.get());
            return new ModelAndView ("update");
        }
        return new ModelAndView ("redirect:/");

    }

    @PostMapping("/update/{id}")
    public ModelAndView update(@PathVariable("id") Integer id, Guest guest){
        guestRepository.save(guest);
        return new ModelAndView ("redirect:/");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Integer id){
        guestRepository.deleteById(id);
        return new ModelAndView ("redirect:/");
    }
}
