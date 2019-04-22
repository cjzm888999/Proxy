package test.staticProxy;

public class Main {
	public static void main(String[] args) {
		//代理对象
		IUserDao userDao=new UserDaoProxy();
		//执行代理方法
		userDao.save();
	}

}
