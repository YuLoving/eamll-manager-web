
package cn.e3mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.pojo.EasyUITreeNode;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.content.service.ContentCategoryService;

/**  

* <p>Title: ContentCategoryController</p>  

* <p>Description: </p>  

* @author zty  

* @date 2018年10月10日  

*/
@Controller
public class ContentCategoryController {

	@Autowired
	private ContentCategoryService contentCategoryService;
	
	@RequestMapping("/content/category/list")
	@ResponseBody
	public List<EasyUITreeNode>  contentcatelist(@RequestParam(name="id",defaultValue="0") long parentId){
		List<EasyUITreeNode> list = contentCategoryService.getContentcategorylist(parentId);
		return list;
	}
	
	@RequestMapping(value="/content/category/create",method =RequestMethod.POST)
	@ResponseBody
	public E3Result addcontentcategory(long parentId,String name){
		E3Result result = contentCategoryService.addContentcategroy(parentId, name);
		return result;
		
	}
	
	@RequestMapping(value="/content/category/update",method =RequestMethod.POST)
	@ResponseBody
	public E3Result edit(long id,String name){
		E3Result result = contentCategoryService.editContentcategory(id, name);
		return result;
	}
	
	@RequestMapping(value="/content/category/delete/",method =RequestMethod.POST)
	@ResponseBody
	public E3Result dele(long id){
		E3Result result = contentCategoryService.deleContentcategory(id);
		return result;
	}
	
}
