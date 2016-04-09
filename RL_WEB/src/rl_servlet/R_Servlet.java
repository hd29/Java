package rl_servlet;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import plejb.RLRemoteInfo;


@SuppressWarnings("serial")
public class R_Servlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
        String name=req.getParameter("username"); 
        String pass=req.getParameter("password1");
        String pass1=req.getParameter("password2");
        
		try {
			InitialContext con = new InitialContext();
			RLRemoteInfo lr=(RLRemoteInfo) con.lookup("RLSessionBean/remote");
			String s = lr.register(name, pass, pass1);
			//String s = lr.register("linhd", "1992", "1992");
			System.out.println(s);
			if(s.equals("yes")){
				resp.sendRedirect("register_sucess.jsp");  
			}
			else {
				resp.sendRedirect("register_failed.jsp");
				System.out.println("输入密码不存在！");
			}
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			System.out.println("服务器异常！");
			resp.sendRedirect("register_failed.jsp");  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
        	System.out.println("用户已存在！");
        	resp.sendRedirect("register_failed.jsp"); 
		}
		
       
}
 
}

