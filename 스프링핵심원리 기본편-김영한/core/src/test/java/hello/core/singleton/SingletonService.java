package hello.core.singleton;

public class SingletonService {
  
  // jvm코드가 올라갈때 static영역에 객체 1개를 만들어서 넣어둔다.
  private static final SingletonService instance = new SingletonService();
  
  public static SingletonService getInstance() {
    return instance;
  }
  
  // 외부에서 인스턴스 생성을 막기 위해
  private SingletonService() {}
  
}
