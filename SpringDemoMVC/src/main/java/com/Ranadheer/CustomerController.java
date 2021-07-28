package com.Ranadheer;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @RequestMapping("/showForm")
    public String showForm(Model theModel){
        theModel.addAttribute("customer",new Customer());
        return "customer_form";
    }
    @RequestMapping("processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult){
        System.out.println("|"+customer.getLastName()+"| "+bindingResult.hasErrors());
        if(bindingResult.hasErrors())
            return "customer_form";
        return "customer-confirmation";

    }
}
