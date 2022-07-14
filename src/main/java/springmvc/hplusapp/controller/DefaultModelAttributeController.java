package springmvc.hplusapp.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import springmvc.hplusapp.bean.Login;
import springmvc.hplusapp.bean.User;

import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class DefaultModelAttributeController {

    @ModelAttribute("newuser")
    public User getdefaultUser(){
        return new User();
    }
    @ModelAttribute("genderItems")
    public List<String> getGenderItem(){
        return Arrays.asList(new String[]{"Male","Female","Other"});
    }
    @ModelAttribute("login")
    public Login getdefaultLogin(){
        return new Login();
    }
}
