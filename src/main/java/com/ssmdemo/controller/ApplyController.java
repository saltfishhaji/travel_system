package com.ssmdemo.controller;

import java.util.List;
import java.util.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssmdemo.entity.Apply;
import com.ssmdemo.entity.Ticket;
import com.ssmdemo.entity.PageModel;
import com.ssmdemo.service.ApplyService;
import com.ssmdemo.service.HotelService;

@RequestMapping(value="/apply")
@Controller
public class ApplyController {
	
	@Autowired
	private ApplyService applyService;
	@Autowired
	private HotelService hotelService;
	
	
	@RequestMapping(value = "/add")
	@ResponseBody
	public String addapply(@RequestParam(value="start") String start,
			@RequestParam(value="destiny")String destiny,
			@RequestParam(value="tovehicle")String tovehicle,
			@RequestParam(value="backvehicle")String backvehicle,
			@RequestParam(value="startdate")String startdate,
			@RequestParam(value="days")Integer days,
			@RequestParam(value="meal")Float meal,
			@RequestParam(value="hotel")Integer hotel,
			@RequestParam(value="budget")Float budget,
			HttpSession session){
		Apply apply=new Apply();
		apply.setUserid((Integer)session.getAttribute("userid"));
		apply.setUsername((String)session.getAttribute("username"));
		apply.setPost((Integer)session.getAttribute("post"));
		apply.setStart(start);
		apply.setDestiny(destiny);
		apply.setTovehicle(tovehicle);
		apply.setBackvehicle(backvehicle);
		apply.setDays(days);
		apply.setMeal(meal);
		apply.setHotel(hotel);
		float compute=hotelService.gethotel(hotel)*(days-1);
		compute+=meal*days;
		Ticket t1=new Ticket();
		t1.setFromcity(start);
		t1.setTocity(destiny);
		t1.setVehicle(tovehicle);
		compute+=hotelService.getprice(t1);
		Ticket t2=new Ticket();
		t2.setFromcity(destiny);
		t2.setTocity(start);
		t2.setVehicle(backvehicle);
		compute+=hotelService.getprice(t2);
		System.out.println(compute);
		apply.setComputebudget(compute);
		apply.setBudget(budget);
		Date date = new Date();       
		Timestamp fulldate = new Timestamp(date.getTime());
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		Date dat;
		try {
			dat = sim.parse(startdate);
			apply.setStartdate(dat);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		apply.setApplytime(fulldate);
		if(apply.getPost()==2)
			apply.setEmployercheck(1);
		else apply.setEmployercheck(0);
		applyService.add(apply);
		return "mdzz";
	}


	@RequestMapping(value = "/findAll")
	@ResponseBody
	public ModelAndView findAll(PageModel<Integer>pageModel,HttpSession session){
		if (pageModel == null) {
			pageModel = new PageModel<Integer>();
			
		}
		else	
			pageModel.setQuery("&username="+pageModel.getUsername());
		pageModel.setData((Integer)session.getAttribute("post"));
		List<Apply> applyList=applyService.findAll(pageModel);
		pageModel.setTotalrecode(applyService.findAllCount(pageModel));
		ModelAndView mv = new ModelAndView();
		mv.addObject("pageModel", pageModel);
		mv.addObject("applyList", applyList);
		mv.setViewName("query");
		return mv;
	}
	
	@RequestMapping(value = "/findbyid")
	@ResponseBody
	public ModelAndView findbyid(PageModel<Integer>pageModel,HttpSession session){
		if (pageModel == null) {
			pageModel = new PageModel<Integer>();
		}
		pageModel.setData((Integer)session.getAttribute("userid"));
		List<Apply> applyList=applyService.findbyid(pageModel);
		pageModel.setTotalrecode(applyService.findMyCount(pageModel));
		ModelAndView mv = new ModelAndView();
		mv.addObject("pageModel", pageModel);
		mv.addObject("applyList", applyList);
		mv.setViewName("query2");
		return mv;
	}
	
	
	@RequestMapping(value = "/findEuncheck")
	@ResponseBody
	public ModelAndView findEmployerUncheck(PageModel<Integer>pageModel,HttpSession session){
		if (pageModel == null) {
			pageModel = new PageModel<Integer>();
		}
		List<Apply> applyList=applyService.findEmployerUncheck(pageModel);
		pageModel.setTotalrecode(applyService.findECount(pageModel));
		ModelAndView mv = new ModelAndView();
		mv.addObject("pageModel", pageModel);
		mv.addObject("applyList", applyList);
		mv.setViewName("check");
		return mv;
	}
	
	@RequestMapping(value = "/updateemployercheck")
	public String updateE(@RequestParam(value="employercheck") Integer employercheck,
			@RequestParam(value="applyid") Integer applyid,
			HttpSession session){
		Apply apply=new Apply();
		apply.setApplyid(applyid);
		apply.setEmployercheck(employercheck);
		applyService.updateE(apply);
		return "redirect:/apply/findEuncheck";
	}
	
	@RequestMapping(value = "/findBuncheck")
	@ResponseBody
	public ModelAndView findBossUncheck(PageModel<Integer>pageModel,HttpSession session){
		if (pageModel == null) {
			pageModel = new PageModel<Integer>();
		}
		List<Apply> applyList=applyService.findBossUncheck(pageModel);
		pageModel.setTotalrecode(applyService.findBCount(pageModel));
		ModelAndView mv = new ModelAndView();
		mv.addObject("pageModel", pageModel);
		mv.addObject("applyList", applyList);
		mv.setViewName("check2");
		return mv;
	}
	
	@RequestMapping(value = "/updatebosscheck")
	public String updateB(@RequestParam(value="bosscheck") Integer bosscheck,
			@RequestParam(value="applyid") Integer applyid,
			HttpSession session){
		Apply apply=new Apply();
		apply.setApplyid(applyid);
		apply.setBosscheck(bosscheck);
		applyService.updateB(apply);
		return "redirect:/apply/findBuncheck";
	}
	
	@RequestMapping(value = "/findunAccount")
	@ResponseBody
	public ModelAndView findunAccount(PageModel<Integer>pageModel){
		if (pageModel == null) {
			pageModel = new PageModel<Integer>();
		}
		else	
			pageModel.setQuery("&username="+pageModel.getUsername());
		List<Apply> applyList=applyService.findunAccount(pageModel);
		pageModel.setTotalrecode(applyService.findUACount(pageModel));
		ModelAndView mv = new ModelAndView();
		mv.addObject("applyList", applyList);
		mv.addObject("pageModel", pageModel);
		mv.setViewName("account");
		return mv;
	}
	
	@RequestMapping(value = "/jumptoadd")
	@ResponseBody
	public ModelAndView jumptoadd(@RequestParam(value="applyid") Integer applyid,
			@RequestParam(value="applyname") String applyname,
			@RequestParam(value="userid") Integer userid,
			@RequestParam(value="applypost") Integer applypost,
			@RequestParam(value="budget") float budget,
			HttpSession session){
		ModelAndView mv = new ModelAndView();
		mv.addObject("applyid", applyid);
		mv.addObject("applyname",applyname);
		mv.addObject("userid",userid);
		mv.addObject("applypost",applypost);
		mv.addObject("budget",budget);
		mv.setViewName("input");
		return mv;
	}
}

