package test.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
// �ӿ�
public interface IUserDao {
  void save();
  void find();
}
//Ŀ�����
class UserDao implements IUserDao{
  @Override
  public void save() {
    System.out.println("ģ�⣺ �����û���");
  }
  @Override
  public void find() {
    System.out.println("��ѯ");
  }
}
/**
 * ��̬����
 *    �������������Ŀ��������ɴ������
 *
 */
class ProxyFactory {
  // ����һ��Ŀ�����
  private Object target;
  public ProxyFactory(Object target) {
    this.target = target;
  }
  // ���ض�Ŀ�����(target)�����Ķ���(proxy)
  public Object getProxyInstance() {
    Object proxy = Proxy.newProxyInstance(
      target.getClass().getClassLoader(),  // Ŀ�����ʹ�õ��������
      target.getClass().getInterfaces(),   // Ŀ�����ʵ�ֵ����нӿ�
      new InvocationHandler() {      // ִ�д�����󷽷�ʱ�򴥷�
        @Override
        public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
          
          // ��ȡ��ǰִ�еķ����ķ�����
          String methodName = method.getName();
          // ��������ֵ
          Object result = null;
          if ("find".equals(methodName)) {
            // ֱ�ӵ���Ŀ����󷽷�
            result = method.invoke(target, args);
          } else {
            System.out.println("��������...");
            // ִ��Ŀ����󷽷�
            result = method.invoke(target, args);
            System.out.println("�ύ����...");
          }
          return result;
        }
      }
    );
    return proxy;
  }
}
