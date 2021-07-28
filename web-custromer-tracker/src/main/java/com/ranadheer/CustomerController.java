package com.ranadheer;

import com.ranadheer.entity.Customer;
import com.ranadheer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {


    // need to inject customerService
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model){
        // get customers from DAO
        List<Customer> customerList = customerService.getCustomers();
        // add customers to model
        model.addAttribute("customers",customerList);
        return "customer-list";
    }

    @GetMapping("/customerForm")
    public String addCustomer(Model model){
        model.addAttribute("customer",new Customer());
        return "customerForm";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){
        customerService.saveCustomer(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/showFormUpdate")
    public String updateForm(@RequestParam("customerId") int id,Model model){

        Customer customer1 = customerService.getCustomer(id);

        model.addAttribute("customer", customer1);
        return "customerForm";
    }

    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam("customerId") int id){

     customerService.deleteCustomer(id);
        return "redirect:/customer/list";
    }
}
