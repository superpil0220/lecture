package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {
  
  @Test
  void statefulServiceSingleton() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
    StatefulService bean1 = ac.getBean(StatefulService.class);
    StatefulService bean2 = ac.getBean(StatefulService.class);
    
    // A: 만원 주문
    bean1.order("A", 10000);
    
    // B: 2만원 주문
    bean2.order("B", 20000);
    
    int price = bean1.order("A", 10000);
    System.out.println("price = " + price);
  }
  
  static class TestConfig{
    @Bean
    public StatefulService statefulService() {
      return new StatefulService();
    }
  }
  
}