
package cn.e3mall.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.e3mall.common.utils.FastDFSClient;
import cn.e3mall.common.utils.JsonUtils;

/**  

* <p>Title: PictureController</p>  

* <p>Description:图片上传 </p>  

* @author zty  

* @date 2018年10月8日  

*/
@Controller
public class PictureController {
	
	@Value("${IMAGE_SERVER_URL}")
	private String IMAGE_SERVER_URL;
	

	@RequestMapping(value="/pic/upload",produces=MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
	@ResponseBody
	public String uploadfile(MultipartFile uploadFile){
		try {
			//把图片上传到FastDFS图片服务器中（使用工具类）
			FastDFSClient fastDFSClient = new FastDFSClient("classpath:conf/Client.conf");
			//获取扩展名
			String originalFilename = uploadFile.getOriginalFilename();//得到文件名字
			String extName = originalFilename.substring(originalFilename.lastIndexOf(".")+1);//截取小数点后面的字符
			//得到一个图片的地址和文件名
							//uploadFile.getBytes()得到一个字节数组
			String url = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);
			//补充为完整的URL
			url= IMAGE_SERVER_URL +url;
			//封装到map中返回
			Map result = new HashMap<>();
			result.put("error", 0);
			result.put("url", url);
			return JsonUtils.objectToJson(result);
		} catch (Exception e) {
			e.printStackTrace();
			Map result = new HashMap<>();
			result.put("error", 1);
			result.put("message", "图片上传失败");
			return JsonUtils.objectToJson(result);
		}
		
		
	}
}
