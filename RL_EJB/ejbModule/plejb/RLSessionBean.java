package plejb;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@Remote
//@WebService
public class RLSessionBean implements RLRemoteInfo{

	@PersistenceContext(unitName="RLJPA")
	private EntityManager manager;
	
//     @WebMethod 发布webservise方法 运行jboss生成wsdl。
	public String login(String name1, String pass1){
		 
		  Query query=manager.createQuery("select pass from plejb.RLJpa where name='"+name1+
				  "' and pass='"+pass1+"'"); 
	       List list = query.getResultList(); 
	       if(list.size()>0){
	       System.out.println(list.get(0));   
	       System.out.println("登录成功！");
	       return "yes";
	       }
	       else{
	    	   System.out.println("登录失败！");
	    	   return "no";
	       }
	}

	public String register(String name, String pass, String pass1){
		
		if(pass.equals(pass1)){
			
		       RLJpa p = new RLJpa();  
		       p.setName(name);
		       p.setPass(pass);
		       p.setid((int) (Math.random() * 1000));
		       manager.persist(p); 
		       System.out.println("注册成功！");
		       return "yes";
		
		}else {
			    return "no";
		}
		
	}

	public String records(String name) {
		  
		try {
			 InitialContext ict = new InitialContext();
			 //获取connectionFactory对象  
			 QueueConnectionFactory factory = (QueueConnectionFactory)ict.lookup("ConnectionFactory");  
			 //获取Connection对象  
			 QueueConnection connection = factory.createQueueConnection();  
			 //获取Session对象，第一个参数表示事务自动提交，第二个参数表示一旦消息被正确发送，将自动发回响应  
			 QueueSession session = connection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);       
			 //获取destination对象  
			 Queue queue = (Queue)ict.lookup("queue/queue1");     
			 //设置消息 
			
			 TextMessage tm = session.createTextMessage(name);          
			 //获取sender对象  
			 QueueSender sender = session.createSender(queue);     
			 //发送消息  
			 sender.send(tm);               
			 session.close();          
			 System.out.println("消息已经发送！");  
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		 Query query=manager.createQuery("select date from rlmdb.MDBEntity where name='"+name+"'"); 
	     List list = query.getResultList(); 
	     if(list.size()>0){
	         String date1 =list.get(list.size()-1).toString();
		     return "上次登录时间"+date1;
	     }else{
	    	 return "你是第一次登录！";
	     }
	}
}
