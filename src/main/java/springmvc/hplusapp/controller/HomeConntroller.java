package springmvc.hplusapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeConntroller {

    @GetMapping("/home")
    public String goHome(){
        System.out.println("This is Home Controller");

        return "index";
    }

    @GetMapping("/goToSearch")
    public String goToSearch(){
        System.out.println("Going to search page");
        return "search";
    }
    @GetMapping("/goToLogin")
    public String goToLogin(){
        System.out.println("Going to Login Page");
        return "login";
    }
    @GetMapping("/goToRegistration")
    public String goToRegistration(){
        System.out.println("Going to Registration Page");
        return "register";
    }

//    @ModelAttribute("newuser")
//    public User getdefaultUser(){
//        return new User();
//    }
//    @ModelAttribute("genderItems")
//    public List<String> getGenderItem(){
//        return Arrays.asList(new String[]{"Male","Female","Other"});
//    }
//    @ModelAttribute("login")
//    public Login getdefaultLogin(){
//        return new Login();
//    }
}
