package io.levvel.example.spring.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import io.levvel.example.struts.form.HelloWorldForm;
 
@Controller
@RequestMapping("/")
public class HelloWorldController {
 
    @RequestMapping(method = RequestMethod.GET)
    public String sayHello(ModelMap model) {
        model.addAttribute("greeting", "Hello World from Spring 4 MVC");
        return "welcome";
    }
 
    @RequestMapping(value = "/helloagain", method = RequestMethod.GET)
    public String sayHelloAgain(ModelMap model) {
        model.addAttribute("greeting", "Hello World Again, from Spring 4 MVC");
        return "welcome";
    }
    
    @RequestMapping(value="helloWorld.do", method=RequestMethod.GET)   
    public ModelAndView helloWorld(HttpServletRequest request,
    		  HttpServletResponse response,
    		  @Valid @ModelAttribute("helloWorldForm") HelloWorldForm helloWorldForm,
    		   BindingResult bindingResult) {
    	
    	helloWorldForm.setMessage("Hello World! Spring");
    	return new ModelAndView("HelloWorld");
    }
 
}
