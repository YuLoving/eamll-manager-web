
package cn.e3mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.utils.E3Result;
import cn.e3mall.content.service.ContentService;
import cn.e3mall.pojo.TbContent;

/**  

* <p>Title: ContentController</p>  

* <p>Description: </p>  

* @author zty  

* @date 2018年10月11日  

*/
@Controller
public class ContentController {
	
	@Autowired
	private ContentService contentService;
	
	@RequestMapping(value="/content/save",method =RequestMethod.POST)
	@ResponseBody
	public E3Result add(TbContent content){
		E3Result result = contentService.addcontent(content);
		return result;
	}
	

}