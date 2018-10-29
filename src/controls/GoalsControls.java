package controls;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import modals.Goal;
import modals.User;
import modals.UserBox;

@Controller
@RequestMapping(value = "/goal", produces = "application/json; charset=utf-8")
public class GoalsControls {
	@RequestMapping(value = "/test")
	@ResponseBody
	public String test() {
		System.out.println("test");
		return "test";
	}

	@RequestMapping(value = "/test2")
	@ResponseBody
	public String test2() {
		System.out.println("test");
		return "test";
	}

	// produces = "application/json; charset=utf-8"
	@RequestMapping(value = "/code")
	@ResponseBody // 乱码
	public String testCoding(String username) {
		System.out.println("test+" + username);
		return username;
	}

	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	// return "redirect:/login" 重定向 转发和重定向需要写全路径@PathVariable
	public String remove(String id, boolean login, @RequestHeader("Accept-Encoding") String encoding,
			@RequestHeader("Keep-Alive") long keepAlive, @CookieValue("JSESSIONID") String cookie) {
		System.out.println("remove");
		if (login) {
			System.out.println("redirect:/goals/user/login");
			return "redirect:/goals/user/login.jsp";
		}
		System.out.println(
				"remove--id:" + id + "encoding--" + encoding + "keepAlive--" + keepAlive + "cookie--" + cookie);
		// remove function goes to here
		return "forward:/goals/admin/index.jsp";// 转发
	}

	@RequestMapping(value = "/remov", method = RequestMethod.GET)
	public String remov(Model m, HttpServletRequest request, HttpSession session) {

		session.setAttribute("sessionname1", "sessionvalue1");
		session.setAttribute("sessionname2", "sessionvalue2");
		request.setAttribute("requestP1", "requestP1V1");
		request.setAttribute("requestP2", "requestP2V1");

		System.out.println("remov");
		Map<String, String> map = new HashMap<String, String>();
		map.put("email", "232@ASC.COM");

		Goal aGoal = new Goal();
		aGoal.setDescript("I am going to sing TM");
		Goal bGoal = new Goal();
		bGoal.setDescript("I am going to sing TM");
		List<Goal> list = new ArrayList<Goal>();
		list.add(aGoal);
		list.add(bGoal);

		m.addAttribute("username", "yangyang");
		m.addAttribute("password123");
		m.addAllAttributes(list);
		m.addAllAttributes(map);
		return "forward:/goals/admin/index.jsp";
	}

	@RequestMapping(value = "/toAdd")
	public String toAdd() {

		System.out.println("test toAdd+");
		return "forward:/goals/admin/add.jsp";
	}

	@RequestMapping(value = "/add")
	public String add(List<User> aUser) {
		for (User user : aUser) {
			System.out.println("test add+" + user.toString());
		}
		System.out.println("test add+" + aUser.toString());
		return "forward:/goals/admin/index.jsp";
	}

	@RequestMapping(value = "/error")
	public String error() {

		int errror = 1 / 0;
		return "forward:/goals/admin/index.jsp";
	}
    @RequestMapping(value = "/upload1")
	public String Upload1(@RequestParam("file") CommonsMultipartFile file) throws IOException{
    	//用来检测程序运行时间
        long  startTime=System.currentTimeMillis();
        System.out.println("fileName："+file.getOriginalFilename());
         
        try {
            //获取输出流
            OutputStream os=new FileOutputStream("D:\tmp"+"upload"+new Date().getTime()+file.getOriginalFilename());
            //获取输入流 CommonsMultipartFile 中可以直接得到文件的流
            InputStream is=file.getInputStream();
            int temp;
            //一个一个字节的读取并写入
            while((temp=is.read())!=(-1))
            {
                os.write(temp);
            }
           os.flush();
           os.close();
           is.close();
         
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        long  endTime=System.currentTimeMillis();
        System.out.println("方法一的运行时间："+String.valueOf(endTime-startTime)+"ms");
		return "upload";
	}
    @RequestMapping(value = "/upload2")
	public String Upload2(){
		
		return "upload";
	}
    @RequestMapping(value = "/upload3")
	public String Upload3(){
		
		return "upload";
	}
	
	@ExceptionHandler(Exception.class)
	public String exception(Exception ex) {
		System.out.println(ex);
		return "forward:/goals/admin/index.jsp";
	}

	@RequestMapping(value = "/add2")
	public String add2(String[] nickname, String[] password, String[] email) {
		for (int i = 0; i <= 2; i++) {
			System.out.println(nickname[i] + password[i] + email[i]);
		}
		return "forward:/goals/admin/index.jsp";
	}

	@RequestMapping(value = "/add3")
	public String add3(UserBox uBox) {
		System.out.println(uBox.getUsers().size());
		List<User> users = uBox.getUsers();
		for (User user : users) {
			System.out.println(user.toString());
		}
		return "forward:/goals/admin/index.jsp";
	}

	@RequestMapping(value = "/add4")
	@ResponseBody
	public String add4(@RequestBody List<User> users) {
		System.out.println(users.size());

		for (User user : users) {
			System.out.println(user.toString());
		}
		return "forward:/goals/admin/index.jsp";
	}

	@RequestMapping(value = "/all")
	@ResponseBody
	public List<Goal> all() {
		System.out.println("test");
		List<Goal> goals = new ArrayList<Goal>();

		Goal aGoal = new Goal();
		aGoal.setDescript("I am going to sing TM");
		Goal bGoal = new Goal();
		bGoal.setDescript("I am going to sing TM");
		Goal cGoal = new Goal();
		cGoal.setDescript("I am going to sing TM");
		Goal dGoal = new Goal();
		dGoal.setDescript("I am going to sing TM");

		goals.add(aGoal);
		goals.add(bGoal);
		goals.add(cGoal);
		goals.add(dGoal);

		return goals;
	}
}
