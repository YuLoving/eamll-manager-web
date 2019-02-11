package cn.e3mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**  

* <p>Title: Pagecontroller</p>  

* <p>Description: </p>  

* @author zty  

* @date 2018年8月6日  

*/
@Controller
public class Pagecontroller {
	
	@RequestMapping("/")
	public String showindex(){
		return "index";
	}

	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page){
		
		return page;
		
	}
	
}
