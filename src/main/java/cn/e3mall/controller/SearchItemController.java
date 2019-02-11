
package cn.e3mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.utils.E3Result;
import cn.e3mall.search.service.SearchItemService;

/**  

* <p>Title: SearchItemController</p>  

* <p>Description:导入商品数据到索引库 </p>  

* @author zty  

* @date 2018年11月21日  

*/
@Controller
public class SearchItemController {
	
	@Autowired
	private SearchItemService searchItemService;
	
	@RequestMapping(value="/index/item/import",method=RequestMethod.POST)
	@ResponseBody
	public E3Result importall(){
		E3Result result = searchItemService.importall();
		return result;
	}

}
