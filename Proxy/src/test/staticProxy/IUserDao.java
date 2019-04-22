package test.staticProxy;
// �ӿ�
public interface IUserDao {
  void save();
  void find();
}
//Ŀ�����
class UserDao implements IUserDao{
  @Override
  public void save() {
    System.out.println("ģ�⣺�����û���");
  }
  @Override
  public void find() {
    System.out.println("ģ�⣺��ѯ�û�");
  }
}
/**
    ��̬����
          �ص㣺
  1. Ŀ��������Ҫʵ�ֽӿ�
  2. �������Ҫʵ����Ŀ�����һ���Ľӿ�
 */
class UserDaoProxy implements IUserDao{
  // ���������Ҫά��һ��Ŀ�����
  private IUserDao target = new UserDao();
  @Override
  public void save() {
    System.out.println("��������� ��������...");
    target.save();   // ִ��Ŀ�����ķ���
    System.out.println("����������ύ����...");
  }
  @Override
  public void find() {
    target.find();
  }
}