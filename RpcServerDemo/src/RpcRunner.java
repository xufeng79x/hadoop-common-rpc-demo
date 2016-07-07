import java.io.IOException;

import org.apache.hadoop.HadoopIllegalArgumentException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.RPC.Builder;
import org.apache.hadoop.ipc.RPC.Server;

/**
 * 服务端RPC服务器启动
 * 
 * 需要指定当前服务器的ip（hostname）和端口信息
 * 后续客户端会和此地址进行通信
 * @author apple
 *
 */
public class RpcRunner {

	public static void main(String[] args) throws HadoopIllegalArgumentException, IOException {
		// 1. 创建Rpc服务端构造器
		Builder builder = new RPC.Builder(new Configuration());
		
		// 2. 设定服务器信息
		// 指定地址
		builder.setBindAddress("applexf.local")
		// 指定端口
		.setPort(1234)
		// 指定接口实现类
		.setInstance(new UserLoginServiceImple())
		// 指定接口
		.setProtocol(UserLoginServiceProtocol.class);
		
		// 3. 构造服务
		Server server = builder.build();
		// 4. 启动服务
		server.start();
		
	}
}
