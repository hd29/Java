package coursetest;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class UncharFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		String username=req.getParameter("username");
		try{ 
				
			if(username.indexOf("-")>=0||username.indexOf("'")>=0
			||username.indexOf("*")>=0||username.indexOf("=")>=0||username.indexOf(" ")>=0){
				    resp.setContentType("text/html");
					PrintWriter out=resp.getWriter();
					out.print("<p>你的输入含有非法字符！</p>");
					out.close();
				}
//			else{
//		    	chain.doFilter(req, resp);
//		        }
			}catch(Exception e){ 
				e.printStackTrace(); 
		} 
		        
		chain.doFilter(req, resp);
	
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	@Override
	public void destroy() {
		
	}

}
