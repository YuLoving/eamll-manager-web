
package cn.e3mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.pojo.EasyUlSDataGridResult;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.service.ItemService;

/**  

* <p>Title: ItemController</p>  

* <p>Description: </p>  

* @author zty  

* @date 2018年7月27日  

*/

@Controller
public class ItemController {
		@Autowired
		private ItemService itemService;
		
		@RequestMapping("Item/{itemid}")
		@ResponseBody
		public TbItem getItembyid(@PathVariable long itemid){
			TbItem item = itemService.getItemById(itemid);
			return item;
		}
		
		@RequestMapping("/item/list")
		@ResponseBody
		public EasyUlSDataGridResult getlist(Integer page,Integer rows){
			EasyUlSDataGridResult list = itemService.getList(page, rows);
			return list;
			
		}
	
		/**
		 * 商品添加功能
		 * */
		@RequestMapping(value="/item/save",method =RequestMethod.POST)
		@ResponseBody
		public E3Result additem(TbItem item,String desc){
			E3Result result = itemService.addItem(item, desc);
			return result;
			
		}
		
		/**
		 * 商品编辑功能
		 * */
		@RequestMapping(value="/rest/item/update",method =RequestMethod.POST)
		@ResponseBody
		public E3Result edititem(TbItem item,String desc){
			E3Result result = itemService.editItem(item, desc);
			return result;
		}
		
		/*
		 * 商品删除功能
		 * */
		@RequestMapping(value="/rest/item/delete",method =RequestMethod.POST)
		@ResponseBody
		public E3Result deleitem(long ids){
			E3Result result = itemService.deleItem(ids);
			return result;
		}
		
		/*
		 * 商品上架功能
		 * */
		@RequestMapping(value="/rest/item/reshelf",method =RequestMethod.POST)
		@ResponseBody
		public E3Result upjia(long ids){
			E3Result result = itemService.upjiaItem(ids);
			return result;
		}
		
		/*
		 * 商品下架功能
		 * */
		@RequestMapping(value="/rest/item/instock",method =RequestMethod.POST)
		@ResponseBody
		public E3Result downjia(long ids){
			E3Result result = itemService.downjiaItem(ids);
			return result;
		}
}
