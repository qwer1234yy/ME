package controls;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import modals.User;

@Controller
@RequestMapping(value = "/user")
public class UserControls {
	@RequestMapping(value = "/test")
    public void test(){
  	  System.out.println("test");
    }
	@RequestMapping(value = "/regi")
    public void register(User auser){
  	  System.out.println("register--"+auser.getEmail());
    }
	@RequestMapping(value = "/toRegister")
    public String toRegister(){
  	  System.out.println("register--");
  	  return "goals/user/register";
    }
	@RequestMapping(value = "/register")
    public String Register(User aUser){
  	  System.out.println("register--"+aUser.toString());
  	  return "redirect:/goals/user/index.jsp";
    }
}
