
/**
 * 接口实现
 * 客户端会使用接口来取得代理对象，服务端需要将接口实现。
 * @author apple
 *
 */
public class UserLoginServiceImple implements UserLoginServiceProtocol {

	/**
	 * 接口实现
	 */
	@Override
	public String login(String username, String password) {
		return username + " is logged in!";
	}

}
