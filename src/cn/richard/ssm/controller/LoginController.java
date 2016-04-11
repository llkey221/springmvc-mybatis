package cn.richard.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.richard.ssm.controller.exception.CustomException;
import cn.richard.ssm.po.User;
import cn.richard.ssm.po.UserCustom;
import cn.richard.ssm.service.UserService;

@Controller
public class LoginController {
		@Autowired
		private UserService userService;
		
		@RequestMapping(value="/login")
		public String login(String name,String password)throws Exception{
			
			return "/login";
		}
		
		@RequestMapping(value="/loginSubmit")
		public String loginSubmit(HttpSession session,String username,String password) throws Exception{
		/*	UserCustom userByName = userService.getUserByName(name, password);
			if(userByName==null||userByName.getName()==null){
				throw new CustomException("用户名或密码不存在");
			}*/
			
			session.setAttribute("username", username);
			
			return "redirect:/queryItems";
			
		}
		@RequestMapping(value="/logout")
		public String logout(HttpSession session) {
			
			session.invalidate();
			
			return "redirect:/queryItems";
		}
		
		@RequestMapping(value="/register")
		public String register(UserCustom userCustom){
			
			return "/register";
		}
		
		@RequestMapping(value="/registerSubmit")
		public String registerSubmit(Model model,@Validated UserCustom userCustom,BindingResult bindingResult) throws Exception{
			
			if(bindingResult.hasErrors()){
				System.out.println("输入数据不合法");
				
				model.addAttribute("errors", bindingResult.getAllErrors());
				
				return "/register";
			}
			
			int result=userService.registerUser(userCustom);
			
			return "redirect:/login";
		}
	
}
