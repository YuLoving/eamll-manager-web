
package cn.e3mall.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.pojo.EasyUITreeNode;
import cn.e3mall.service.ItemcatService;

/**  

* <p>Title: ItemcatController</p>  

* <p>Description: 商品类目</p>  

* @author zty  

* @date 2018年9月29日  

*/
@Controller
public class ItemcatController {
	@Autowired
	private ItemcatService itemcatService;
	
	@RequestMapping("/item/cat/list")
	@ResponseBody
	public List<EasyUITreeNode> getitemcatlist(@RequestParam(name="id",defaultValue="0") long parentId){
		//调用服务节点列表
		List<EasyUITreeNode> list = itemcatService.getIteamcatlist(parentId);
		return list;
		
	}

	

}
