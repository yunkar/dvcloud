package foo;

import java.io.IOException;
import java.net.Inet4Address;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
    name = "HelloAppEngine",
    urlPatterns = {"/hello"}
)
public class HelloAppEngine extends HttpServlet {
	int i=0,l=0;
	static int j=0;
	
  @Override
  synchronized public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {

    response.setContentType("text/plain");
    response.setCharacterEncoding("UTF-8");

    response.getWriter().print("Hello App Enginev 20 janvier !\r\n");
    response.getWriter().println("x:"+this.hashCode());
    response.getWriter().println("ip:"+Inet4Address.getLocalHost().getHostName());
    response.getWriter().println("y:"+Thread.currentThread());
    response.getWriter().println("i:"+i++);
    
    for (int k=0;k<1000000000;k++) {
    	l=l+1;
    }
    response.getWriter().println("j:"+j++);
    response.getWriter().println("l:"+l);
  }
}