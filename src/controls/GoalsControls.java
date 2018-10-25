package controls;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import modals.Goal;
@Controller
@RequestMapping(value = "/goal")
public class GoalsControls {
	  @RequestMapping(value = "/test")
	  @ResponseBody
      public String test(){
    	  System.out.println("test");
    	  return "test";
      }
	  @RequestMapping(value = "/test.jsp")
	  @ResponseBody
      public String test2(){
    	  System.out.println("test");
    	  return "test";
      }
	  @RequestMapping(value = "/remove")
	  //return "redirect:/login" 重定向 转发和重定向需要写全路径
      public String remove(boolean login){
    	  
    	  if (!login) {
    		  System.out.println("redirect:/goals/user/login");
			return "redirect:/goals/user/login.jsp";
		  }
    	  System.out.println("test");
    	  return "forward:/goals/admin/index.jsp";//转发
      }
	  @RequestMapping(value = "/add")
	  @ResponseBody
      public String add(){
    	  System.out.println("test");
    	  return "test";
      }
	  @RequestMapping(value = "/all")
	  @ResponseBody
      public List<Goal> all(){
    	  System.out.println("test");
    	  List<Goal> goals = new ArrayList<Goal>();
    	  
    	  Goal aGoal =  new Goal();
    	  aGoal.setDescript("I am going to sing TM");
    	  Goal bGoal =  new Goal();
    	  bGoal.setDescript("I am going to sing TM");
    	  Goal cGoal =  new Goal();
    	  cGoal.setDescript("I am going to sing TM");
    	  Goal dGoal =  new Goal();
    	  dGoal.setDescript("I am going to sing TM");
    	  
    	  goals.add(aGoal);
    	  goals.add(bGoal);
    	  goals.add(cGoal);
    	  goals.add(dGoal);
    	  
    	  return goals;
      }
}
