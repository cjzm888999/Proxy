package test.staticProxy;

public class Main {
	public static void main(String[] args) {
		//�������
		IUserDao userDao=new UserDaoProxy();
		//ִ�д�����
		userDao.save();
	}

}
