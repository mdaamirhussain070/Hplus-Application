package springmvc.hplusapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import springmvc.hplusapp.bean.Login;
import springmvc.hplusapp.bean.User;
import springmvc.hplusapp.exceptions.ApplicationException;
import springmvc.hplusapp.repository.UserRepository;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;
    @PostMapping("/login")
    public String login(@ModelAttribute("login")Login login){
        User user=userRepository.searchByName(login.getUsername());
        if(user==null){
            throw new ApplicationException("User not found");
        }
        return "search";
    }
//    @ExceptionHandler(ApplicationException.class)
//    public String exceptionHandler(){
//        System.out.println("We are in ExceptionHandler of Login Controller");
//        return "error";
//    }
}
