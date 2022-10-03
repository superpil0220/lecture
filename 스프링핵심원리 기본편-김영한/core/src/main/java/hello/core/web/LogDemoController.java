package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

  private final LogDemoService logDemoService;
  private final ObjectProvider<MyLogger> myLoggerPro;

  @RequestMapping("log-demo")
  @ResponseBody
  public String logDemo(HttpServletRequest req) {
    String reqURL = req.getRequestURL().toString();

    MyLogger myLogger = myLoggerPro.getObject();
    myLogger.setRequestURL(reqURL);
    myLogger.log("Controller Test");
    logDemoService.logic("testId");
    return "OK";
  }

}
