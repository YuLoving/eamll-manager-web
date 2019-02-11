
package cn.e3mall.fast;

import java.util.Iterator;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import cn.e3mall.common.utils.FastDFSClient;

/**  

* <p>Title: FastDfstest</p>  

* <p>Description: 图片服务器的测试</p>  

* @author zty  

* @date 2018年10月7日  

*/
public class FastDfstest {
	
	
	//基本的写法，不使用工具类common
	@Test
	public void testupload() throws Exception
	{
		//创建一个配置文件，文件名任意，内容就是tracker服务器地址。
		//使用全局对象加载配置文件
		ClientGlobal.init("D:/workspace/e3-manager-web/src/main/resources/conf/Client.conf");
		//创建一个TrackerClient对象
		TrackerClient trackerClient = new TrackerClient();
		//通过TrackerClient获得一个TrackerServer对象
		TrackerServer trackerServer = trackerClient.getConnection();
		//创建一个storageserver的引用，可以是null
		StorageServer storageServer=null;
		//创建一个storageClient,参数需要TrackerServer和storageserver
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		//通过storageClient上传文件
		/*
		 * local_filename: 本地上传文件的全路径
		 * file_ext_name：该文件的拓展名，不带点.
		 * meta_list:元数据
		 * */
		String[] strings = storageClient.upload_file("G:/tp/6.jpg", "jpg", null);
		//打印一下
		for (String string : strings) {
			System.out.println(string);
		}
		
		
	}
	
	@Test
	//使用工具类common，进行另一种写法
	public void testupload1()throws Exception{
		FastDFSClient client = new FastDFSClient("D:/workspace/e3-manager-web/src/main/resources/conf/Client.conf");
		String string = client.uploadFile("G:/tp/1.jpg");
		System.out.println(string);
		
		
	}

}
