package hello.core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PrototypeTest {

  @Test
  void prototypeBeanFind() {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
    PrototypeBean pro1 = ac.getBean(PrototypeBean.class);
    PrototypeBean pro2 = ac.getBean(PrototypeBean.class);
    System.out.println("pro1 " + pro1);
    System.out.println("pro2 " + pro2);
    pro1.destroy();
  }

  @Scope("prototype")
  static class PrototypeBean {
    @PostConstruct
    public void init() {
      System.out.println("PrototypeBean.init");
    }
    @PreDestroy
    public void destroy() {
      System.out.println("PrototypeBean.destroy");
    }
  }

}
