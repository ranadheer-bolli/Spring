package com.Ranadheer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
@RequestMapping("/showForm")
public String showForm(){
    return "helloworld-form";
}

@RequestMapping("/processForm")
public String processForm(){
    return "helloworld";
}
@RequestMapping("processFormVersionTwo")
public String letsShoutDude(HttpServletRequest request, Model model){

    String theName = request.getParameter("studentName");
    System.out.println(theName);
    theName = theName.toUpperCase();

    String result= "YO!" +  theName;

    model.addAttribute("message",result);

    return "helloworld";
}
    @RequestMapping("processFormVersionThree")
    public String letsShoutDude(@RequestParam("studentName") String theName, Model model){

        theName = theName.toUpperCase();

        String result= "YO!" +  theName;

        model.addAttribute("message",result);

        return "helloworld";
    }
}
