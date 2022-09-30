package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
  
  public static void main(String[] args) {
    // spring 컨테이너에 주입한다.
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    
    // appConfig에서 memberService를 불러온다.
    MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
  
    Member member = new Member(1L, "memberA", Grade.VIP);
    memberService.join(member);
    
    Member findmember = memberService.findMember(1L);
    System.out.println("findmember === " + findmember.getName());
  }
  
}
