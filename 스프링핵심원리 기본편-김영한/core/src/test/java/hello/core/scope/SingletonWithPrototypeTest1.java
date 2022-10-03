package hello.core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SingletonWithPrototypeTest1 {

  @Test
  void prototypeFind() {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
    PrototypeBean pro1 = ac.getBean(PrototypeBean.class);
    pro1.addCount();
    assertThat(pro1.getCount()).isEqualTo(1);

    PrototypeBean pro2 = ac.getBean(PrototypeBean.class);
    pro2.addCount();
    assertThat(pro2.getCount()).isEqualTo(1);
  }

  @Test
  void singletoneClientUsePrototype() {

  }

  @Scope("prototype")
  static class PrototypeBean {

    private int count = 0;

    public void addCount() {
      count++;
    }

    public int getCount() {
      return count;
    }

    @PostConstruct
    public void init() {
      System.out.println("init " + this);
    }

    @PreDestroy
    public void destroy() {
      System.out.println("destroy");
    }

  }

}
