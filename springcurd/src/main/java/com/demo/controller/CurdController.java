/**
 * 
 */
package com.demo.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.demo.domain.UserDetails;
import com.demo.service.UserServices;
import com.mysql.cj.x.json.JsonArray;

/**
 * @author kalaiselvan.a
 *
 */
@Controller
public class CurdController {

	@Autowired
	UserServices userservice;

	@RequestMapping(value = { "/", "/home" })
	public ModelAndView homepage(ModelMap map) {
		map.addAttribute("message", "Spring CRUD using java config");
		return new ModelAndView("home", map);
	}

	@RequestMapping(value = "/Userlist")
	@ResponseBody
	public String userlist() {
		JSONArray arr = new JSONArray();
		JSONObject jsonobj = new JSONObject();
		List<UserDetails> userlist = userservice.findAll();
		for (UserDetails ud : userlist) {
			JSONObject obj = new JSONObject();
			obj.put("id", ud.getId());
			obj.put("firstname", ud.getFirstname());
			obj.put("lastname", ud.getLastname());
			arr.add(obj);
		}
		jsonobj.put("userlist", arr);
		return jsonobj.toJSONString();
	}

	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	@ResponseBody
	public String adduser(HttpServletRequest req) {
		JSONObject obj = new JSONObject();
		UserDetails ud = new UserDetails();
		ud.setFirstname(req.getParameter("firstname"));
		ud.setLastname(req.getParameter("lastname"));
		ud.setCDate(new Date());
		ud.setCreatedBy("admin");
		ud.setIsActive("Active");
		userservice.addUser(ud);
		obj.put("message", "Successfully Stored!...");
		return obj.toString();
	}

	@RequestMapping(value = "/Updateuser", method = RequestMethod.POST)
	@ResponseBody
	public String updateuser(HttpServletRequest req) {
		JSONObject obj = new JSONObject();
		System.out.println("req--------------------------" + req.getParameter("id"));
		long id = Long.parseLong(req.getParameter("id"));
		UserDetails ud = userservice.findById(id);
		ud.setFirstname(req.getParameter("firstname"));
		ud.setLastname(req.getParameter("lastname"));
		userservice.addUser(ud);
		obj.put("message", "Successfully Stored!...");
		return obj.toString();
	}

	@RequestMapping(value = "/Deleteuser", method = RequestMethod.POST)
	@ResponseBody
	public String Deleteuser(HttpServletRequest req) {
		JSONObject obj = new JSONObject();
		System.out.println("req--------------------------" + req.getParameter("id"));
		long id = Long.parseLong(req.getParameter("id"));
		userservice.deleteuser(id);
		obj.put("message", "Successfully Deleted!...");
		return obj.toString();
	}
}
