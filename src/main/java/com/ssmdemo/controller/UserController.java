package com.ssmdemo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.apache.jasper.tagplugins.jstl.core.Out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.bind.annotation.RequestBody;

import com.ssmdemo.dao.UserDao;
import com.ssmdemo.entity.PageModel;
import com.ssmdemo.entity.User;
import com.ssmdemo.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	/**
     * �û���Ϣ�б�
     * @return
     * �������JSON��ֵ����ô��Ҫע�͵��·������еĴ���
     * List<User> userList = userService.findAll();
     * mv.addObject("userList", userList);
     * ֱ�ӷ���һ������ͼ����
     * ҳ���첽�������ݣ���鿴�·�ע�ͷ���
     */
	@RequestMapping(value = "/userList")
	public ModelAndView userList(){
		List<User> userList = userService.findAll();
		ModelAndView mv = new ModelAndView();
		mv.addObject("userList", userList);
		mv.setViewName("userList");
		return mv;
	}
	/**
     * �û���Ϣ�б�   ҳ���첽����
     * @return
     * @ResponseBody ע��������ǽ�Ŀ����������ת����json��ʽ
     * ����ҳ����Ҫ����jquery js
     */
	/*@RequestMapping(value = "/list")
	public @ResponseBody List<User> list(){
		List<User> userList = userService.findAll();
		return userList;
	}
	*/
	
	/**
     * ��ת�������Ϣ��ͼ
     * @return
     */
	@RequestMapping(value = "/addLoad")
	public ModelAndView addLoad(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("add");
		return mv;
	}
	/**
     * �����Ϣ
     * @param user
     * @return
     */
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public String add(User user){
		userService.add(user);
		return "redirect:/user/userList";
	}
	/**
     * �޸���Ϣ��ȡ����ת���޸���Ϣ��ͼ
     * @param id
     * @return
     */
	@RequestMapping(value = "/editLoad")
	public ModelAndView editLoad(@RequestParam(value = "userid") Integer userid){
		User user = userService.findByUserID(userid);
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", user);
		mv.setViewName("users");
		return mv;
	}
	/**
     * �޸���Ϣ
     * @param user
     * @return
     */
	@RequestMapping(value = "/edit",method = RequestMethod.POST)
	public String edit(User user){
		userService.update(user);
		return "redirect:/user/userList";
	}
	
	/**
     * ɾ���û�
     * @param id
     * @return
     */
	@RequestMapping(value = "/delete")
	public String  delete(@RequestParam(value = "userid") Integer userid){
		userService.delete(userid);
		return "redirect:/user/userList";
	}
	

	/*@RequestMapping(value = "/logout")
	public String logout(HttpSession session){
		session.setAttribute("userName",null);
		session.setAttribute("userID",null);
		return "redirect:/index.jsp";
	}*/
	
	@RequestMapping(value = "/checkLoad")
	public ModelAndView checkLoad(@RequestParam(value = "id") Integer userid){
		User user = userService.findByUserID(userid);
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", user);
		mv.setViewName("check");
		return mv;
	}
	
	@RequestMapping(value = "/check")
	public String check(@RequestParam(value = "id")Integer id){
		userService.check(id);
		return "redirect:/user/checklist";
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/index.jsp";
	}
	
	@RequestMapping(value = "/checkdeny")
	public String checkdeny(@RequestParam(value = "id")Integer id){
		userService.checkdeny(id);
		return "redirect:/user/checklist";
	}
	
	@RequestMapping(value = "/update")
	@ResponseBody
	public Integer update(@RequestParam(value="userid") Integer userid,
			@RequestParam(value="gender") Boolean gender,
			@RequestParam(value="password")String password,
			@RequestParam(value="email")String email,
			@RequestParam(value="phone") String phone,
			HttpSession session){
		User user=new User();
		user.setUserid(userid);
		user.setPassword(password);
		user.setGender(gender);
		user.setEmail(email);
		user.setPhone(phone);
		userService.update(user);
		return userid;
	}
	
	@RequestMapping(value = "/login")
	@ResponseBody
	public String login(@RequestParam(value="userid") Integer userid,@RequestParam(value="password")String password,HttpSession session){
		User user = userService.findByUserID(userid);
		if(user!=null && user.getPassword().equals(password)){
			session.setAttribute("userid", userid);
			session.setAttribute("username",user.getUsername());
			session.setAttribute("post",user.getPost());
			Integer check=user.getChecked();
			System.out.print(check);
			if(check!=-1&&check!=0)
				return "login";
			else if(check==-1)
				return "mdzz";
			else if(check==0)
				return "fail";
			else return "fuck";
		}
		session.setAttribute("userid",null);
		session.setAttribute("username",null);
		return "hehe";
	}
	
	@RequestMapping(value = "/register")
	@ResponseBody
	public Integer login(@RequestParam(value="username") String username,
			@RequestParam(value="password")String password,
			@RequestParam(value="email")String email,
			@RequestParam(value="post") Integer post,
			HttpSession session){
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setPost(post);
		user.setEmail(email);
		Integer userid=userService.add(user);
		session.setAttribute("userid",userid);
		session.setAttribute("username",username);
		session.setAttribute("post",post);
		session.setAttribute("checked",user.getChecked());
		return userid;
	}
	
	@RequestMapping(value = "/checklist")
	public ModelAndView checklist(PageModel<Integer>pageModel){
		if (pageModel == null) {
			pageModel = new PageModel<Integer>();
		}
		List<User> checkList = userService.findUnchecked(pageModel);
		pageModel.setTotalrecode(userService.findCount(pageModel));
		ModelAndView mv = new ModelAndView();
		mv.addObject("pageModel", pageModel);
		mv.addObject("checklist", checkList);
		mv.setViewName("checklist");
		
		return mv;
	}
	
	@RequestMapping(value = "/jumphome",method = RequestMethod.GET)
	public String jumpToLogin(HttpSession session){
		//ModelAndView mv = new ModelAndView();
		//mv.addObject("user", user);
		//mv.setViewName("check");
		//return mv;
		return "home";
	}
	
}
