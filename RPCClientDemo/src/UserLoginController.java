import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

/**
 * RPC调用过程
 * @author apple
 *
 */
public class UserLoginController {

	public static void main(String[] args) throws IOException {
		// 根据接口来取得服务测的代理对象实例
		UserLoginServiceProtocol userloginService 
		// 指明需要哪个接口的代理对象
		= RPC.getProxy(UserLoginServiceProtocol.class
				// 指明调用接口的哪个rpc版本（基本上无用处，版本已经在接口文件中指明了）
				, 1L
				// 设定服务器的链接地址
				, new InetSocketAddress("applexf.local", 1234)
				, new Configuration());
		// 调用远程服务犹如在本地调用一样，这就是所谓的远程过程调用
		String resp = userloginService.login("xufeng", "password");
		
		// 输出结果值
		System.out.println(resp);
	}

}
