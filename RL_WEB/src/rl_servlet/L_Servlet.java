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
public class L_Servlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
        String name1=req.getParameter("username"); 
        String pass1=req.getParameter("password");
      
       
		try {
			InitialContext con = new InitialContext();
			RLRemoteInfo lr=(RLRemoteInfo) con.lookup("RLSessionBean/remote");
			
			String s = lr.login(name1,pass1);
			System.out.println(s);
			if(s.equals("no")) {
				resp.sendRedirect("D:\\abc\\eclipse\\workspace\\RL_WEB\\WebContent\\error.jsp"); 
				System.out.println("用户不存在！");
			}
			if(s.equals("yes")){
				try {
					String s3 = lr.records(name1);
					System.out.println(s3);
					req.getSession().setAttribute("time", s3);
					req.getSession().setAttribute("name", name1);
					resp.sendRedirect("success.jsp"); 
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
//			else if(pass1.equals("no")){
//				resp.sendRedirect("error.jsp");
//			}

		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("服务器异常");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库异常！");
		}
   
}
}

