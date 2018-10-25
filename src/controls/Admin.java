package controls;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import common.ControlResponse;
import myutils.JackJsonTools;
import modals.User;

@Controller
public class Admin {
	@ResponseBody
	@RequestMapping(value="getall", method = RequestMethod.POST, params={"username=admin","role=admin"})
	public ControlResponse  getalluser(){
		//check all the authoritations
		List<User> listuser=new ArrayList<User>();
		User aUser=new User();
		User bUser=new User();
		User cUser=new User();
		User dUser=new User();
		
		aUser.setEmail("email1");
		bUser.setEmail("email2");
		cUser.setEmail("email3");
		dUser.setEmail("email4");
		
		listuser.add(aUser);
		listuser.add(bUser);
		listuser.add(cUser);
		listuser.add(dUser);
		
		
		return ControlResponse.createBySuccess("success", listuser);
	}
	
	@RequestMapping(value = "toadmin", method = RequestMethod.GET)
	public String waytoAdmin(Model model, String something) {
		User aUser = new User();
		aUser.setEmail("55@qq.com");
		aUser.setId(123456);
		aUser.setPassword("123456");
		aUser.setNickname("robbie");
		model.addAttribute("user", aUser);
		return "admin/index";
	}
	
	@RequestMapping(value = "admin_get", method = RequestMethod.GET)
	@ResponseBody
	public User getAuser(Model model, String something) {
		User aUser = new User();
		aUser.setEmail("55@qq.com");
		aUser.setId(123456);
		aUser.setPassword("123456");
		aUser.setNickname("robbie");
		model.addAttribute("user", aUser);
		return aUser;
	}
	
	@RequestMapping(value="adduser")
	public String addUser(User aUser){
		System.out.println("adduser--"+JackJsonTools.toJson(aUser));
		return "admin/added";
	}
	@RequestMapping(value="toadduser")
	public ModelAndView toAddUser(User aUser, ModelMap modal){
		System.out.println("toadduser--"+JackJsonTools.toJson(aUser));
		return new ModelAndView("admin/user", "command", new User());
	}
}
