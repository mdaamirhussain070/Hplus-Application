package springmvc.hplusapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import springmvc.hplusapp.bean.User;
import springmvc.hplusapp.repository.UserRepository;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class RegistrationController {

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class,"dateOfBirth",new CustomDateEditor(new SimpleDateFormat("yyyy-mm-dd"),true));
    }
    @Autowired
    private UserRepository userRepository;
    @PostMapping("/registeruser")
    public String registerUser(@Valid @ModelAttribute("newuser") User user, BindingResult result, Model model) {

        System.out.println("Inside Registration Controller");
        System.out.println(user.getDateOfBirth());
        System.out.println(user.getUserName());
        if(result.hasErrors()){
            return "register";
        }
        userRepository.save(user);



        model.addAttribute("dataSaved","Registration Successfull");
        return "login";
    }
}
