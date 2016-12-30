package com.ssmdemo.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssmdemo.entity.Account;
import com.ssmdemo.entity.Apply;
import com.ssmdemo.entity.Ticket;
import com.ssmdemo.entity.Showaccount;
import com.ssmdemo.entity.Graph;
import com.ssmdemo.entity.PageModel;
import com.ssmdemo.entity.Findmymonth;
import com.ssmdemo.service.AccountService;


@RequestMapping(value="/account")
@Controller
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value = "/add")
	@ResponseBody
	public String addaccount(@RequestParam(value="applyid") Integer applyid,
			@RequestParam(value="userid") Integer userid,
			@RequestParam(value="username") String username,
			@RequestParam(value="post") Integer post,
			@RequestParam(value="startdate") String startdate,
			@RequestParam(value="days") Integer days,
			@RequestParam(value="budget") float budget,
			@RequestParam(value="extrapay") float extrapay,
			@RequestParam(value="hotelpay") float hotelpay,
			@RequestParam(value="ticketpay") float ticketpay,
			@RequestParam(value="mealpay") float mealpay,
			@RequestParam(value="adminmsg") String adminmsg,
			HttpSession session){
		//return "apply";
		Account account=new Account();
		account.setApplyid(applyid);
		account.setUserid(userid);
		account.setUsername(username);
		account.setPost(post);
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		Date dat;
		try {
			dat = sim.parse(startdate);
			account.setStartdate(dat);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		account.setDays(days);
		account.setExtrapay(extrapay);
		float totalbudget=extrapay+hotelpay+ticketpay+mealpay;
		account.setTotalbudget(totalbudget);
		account.setBudget(budget);
		account.setHotelpay(hotelpay);
		account.setTicketpay(ticketpay);
		account.setMealpay(mealpay);
		account.setAdminmsg(adminmsg);
		float temp=budget-totalbudget;
		if(temp<0)	temp=0;
		account.setSavings(temp);
		accountService.addAccount(account);
		return "mdzz";
	}
	

	@RequestMapping(value = "/findAll", method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ModelAndView findAll(PageModel<Integer>pageModel,HttpSession session){
		//System.out.println(session.getAttribute("post"));
		if (pageModel == null) {
			pageModel = new PageModel<Integer>();
		}
		pageModel.setData((Integer)session.getAttribute("post"));
		List<Showaccount> showaccountList=accountService.findAll(pageModel);
		pageModel.setTotalrecode(accountService.findAllCount(pageModel));
		ModelAndView mv = new ModelAndView();
		mv.addObject("showaccountList", showaccountList);
		mv.addObject("pageModel", pageModel);
		mv.setViewName("lookreport");
		return mv;
	}
	
	@RequestMapping(value = "/findbyid")
	@ResponseBody
	public ModelAndView findbyid(PageModel<Integer>pageModel,HttpSession session){
		//System.out.println(session.getAttribute("post"));
		if (pageModel == null) {
			pageModel = new PageModel<Integer>();
		}
		pageModel.setData((Integer)session.getAttribute("userid"));
		List<Showaccount> showaccountList=accountService.findbyid(pageModel);
		pageModel.setTotalrecode(accountService.findMyCount(pageModel));
		ModelAndView mv = new ModelAndView();
		mv.addObject("showaccountList", showaccountList);
		mv.addObject("pageModel", pageModel);
		mv.setViewName("lookreport2");
		return mv;
	}
	
	@RequestMapping(value = "/findAllmonth")
	@ResponseBody
	public ModelAndView findAllmonth(HttpSession session){
		//System.out.println(session.getAttribute("post"));
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");   
		String str=sdf.format(date);  
		str=str.substring(0,7);
		System.out.println("Contrller:"+str);
		List<Graph> graph=accountService.findAllmonth(str);
		ModelAndView mv = new ModelAndView();
		mv.addObject("graph", graph);
		mv.setViewName("graph");
		return mv;
	}
	
	@RequestMapping(value = "/findMymonth")
	@ResponseBody
	public ModelAndView findMymonth(HttpSession session){
		//System.out.println(session.getAttribute("post"));
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");   
		String str=sdf.format(date);  
		str=str.substring(0,7);
		System.out.println("Contrller:"+str);
		Findmymonth temp=new Findmymonth();
		temp.setMonth(str);
		temp.setUserid((Integer)session.getAttribute("userid"));
		List<Graph> graph=accountService.findMymonth(temp);
		ModelAndView mv = new ModelAndView();
		mv.addObject("graph", graph);
		mv.setViewName("graph");
		return mv;
	}
}
