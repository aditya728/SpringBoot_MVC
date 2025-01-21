package com.aditya.SpringBootMVC;

import com.aditya.SpringBootMVC.model.Alien;
import com.aditya.SpringBootMVC.model.AlienRepo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller //This is springBoot annotation which tells that this is a controller class
public class HomeContoller {

    @Autowired
    AlienRepo repo;

    @RequestMapping("/") //told that this is a default page
    public String home(){
//        System.out.println("Home page requested");
        return "index2";
    }


    //We can use this (recommended)
    @RequestMapping("add")
    public ModelAndView add(@RequestParam("num1") int i, @RequestParam("num2") int j){
        ModelAndView mv = new ModelAndView("result");

        int sum = i + j;
        mv.addObject("sum", sum);
        return mv;
    }

    //Or this as well
//    @RequestMapping("add")
//    public String add(@RequestParam("num1") int i, @RequestParam("num2") int j, HttpSession session){
//
//        int num3 = i + j;
//        session.setAttribute("num3", num3);
//        return "result.jsp";
//    }

    @RequestMapping("addAlien")
    public String addAlien(@ModelAttribute("a") Alien a){
        repo.save(a);
        return "result";
    }

    @RequestMapping("getAliens")
    public String getAliens(Model m){
        m.addAttribute("a",repo.findAll());
        return "result";
    }

    @RequestMapping("getAlien")
    public String getAlien(@RequestParam("aid")int aid, Model m){
        m.addAttribute("a",repo.getOne(aid));
        return "result";
    }

    @RequestMapping("removeAlien")
    public String removeAlien(@RequestParam("aid") int aid){
        repo.deleteById(aid);
        return "result";
    }

    @RequestMapping("getAlienByAname")
    public String getAlienByAname(@RequestParam("aname")String aname, Model m){
        m.addAttribute("a",repo.findUsingName(aname));
        return "result";
    }
}
