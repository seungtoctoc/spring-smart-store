package smartstore.order;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@AllArgsConstructor
public class MyInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj)
      throws Exception {
    System.out.println("MyInterceptor - preHandle");
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj,
      ModelAndView mav) throws Exception {
    System.out.println("MyInterceptor - postHandle");
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj,
      Exception e) throws Exception {
    System.out.println("MyInterceptor - afterCompletion");
  }
}