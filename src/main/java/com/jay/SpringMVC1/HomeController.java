package com.jay.SpringMVC1;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @ModelAttribute("course")
    public String course(){
        return "Java";
    }

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @RequestMapping("add")
    //public String add(HttpServletRequest req, Model model){ Using model
    public ModelAndView add(HttpServletRequest req, ModelAndView mv){ //Using ModelAndView Object
        int num1 = Integer.parseInt(req.getParameter("num1"));
        int num2 = Integer.parseInt(req.getParameter("num2"));
        int result = num1 + num2;
       // session.setAttribute("result",result); //Discarding the usage of session Object (if you want to use it , in the parameters , pass the parameter :"(HttpSession session)"
        //model.addAttribute("result",result); using model object
        mv.addObject("result",result);
        mv.setViewName("result");
        //return "result";
        return mv;
    }

    @RequestMapping("addAlien")
    public String addAlien(Alien alien){
        //Alien alien = new Alien();
        //alien.setAid(aid);
        //alien.setAname(aname);
       // mv.addObject("alien",alien);
       // mv.setViewName("result");
        return "result";
    }
}
