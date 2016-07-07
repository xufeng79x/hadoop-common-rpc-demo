/**
 * rpc接口
 * @author apple
 *
 */
public interface UserLoginServiceProtocol {
	// 版本号确定，一次确定客户端和服务端是否版本相同，对于不同的版本间的调用做限制
	public static final long versionID = 1L;
	
	// 接口定义
	public String login(String username,String password);
	
}
