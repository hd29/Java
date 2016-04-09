package coursetest;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class UnusersFilter implements Filter {
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
		FilterChain chain) throws IOException, ServletException {
		String username=req.getParameter("username");
		try{ 
			File f=new File("workspace/coursetest/unusers.xml"); 
			DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance(); 
			DocumentBuilder builder=factory.newDocumentBuilder(); 
		    Document doc = builder.parse(f); 
			NodeList nl = doc.getElementsByTagName("user"); 
			for(int i=0;i<nl.getLength();i++){ 
			String name=doc.getElementsByTagName("username").item(i).getFirstChild().getNodeValue();
				
//			if(username.equals(name)){
//				    resp.setContentType("text/html");
//					PrintWriter out=resp.getWriter();
//					out.print("<p>你属于非法用户，无法登陆！</p>");
//					out.close();
//					break;		
//				}
//		    if(i==nl.getLength()-1){
//		    	chain.doFilter(req, resp);
//		       }
			}
				
			}catch(Exception e){ 
				e.printStackTrace(); 
			 } 
		chain.doFilter(req, resp);
	}
     @Override
    public void destroy() {
    	// TODO Auto-generated method stub
    	
    }
     @Override
    public void init(FilterConfig arg0) throws ServletException {
    	// TODO Auto-generated method stub
    	
    }
     
}
