package coursetest;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.axiom.om.OMElement;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;
import org.w3c.dom.*; 

@SuppressWarnings("serial")
public class Loginservlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException  {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		try{ 
			File f=new File("workspace/coursetest/users.xml"); 
			DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance(); 
			DocumentBuilder builder=factory.newDocumentBuilder(); 
		    Document doc = builder.parse(f); 
			NodeList nl = doc.getElementsByTagName("user"); 
			for(int i=0;i<nl.getLength();i++){ 
			String name=doc.getElementsByTagName("username").item(i).getFirstChild().getNodeValue();
			String pass=doc.getElementsByTagName("password").item(i).getFirstChild().getNodeValue();
			
			if(username.equals(name)&& password.equals(pass)){
				   resp.setContentType("text/html");
					PrintWriter out=resp.getWriter();
					out.print("<p>登陆成功！</p>");
					out.print("<p>你的用户名为："+username+"</p>");
					out.print("<p>你的密码为："+password+"</p>");
					out.close();
					break;		
				}
				if( i==nl.getLength()-1){
					resp.setContentType("text/html");
					PrintWriter out=resp.getWriter();
					out.print("登陆失败，请重新");
					out.println("<a href=\"login.jsp\">登陆</a>");
					out.close();
				}	
			}
				
			}catch(Exception e){ 
				e.printStackTrace(); 
			 } 
		
		
	
		
		
		}	
	}
	
	


