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
	
//     @WebMethod ����webservise���� ����jboss����wsdl��
	public String login(String name1, String pass1){
		 
		  Query query=manager.createQuery("select pass from plejb.RLJpa where name='"+name1+
				  "' and pass='"+pass1+"'"); 
	       List list = query.getResultList(); 
	       if(list.size()>0){
	       System.out.println(list.get(0));   
	       System.out.println("��¼�ɹ���");
	       return "yes";
	       }
	       else{
	    	   System.out.println("��¼ʧ�ܣ�");
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
		       System.out.println("ע��ɹ���");
		       return "yes";
		
		}else {
			    return "no";
		}
		
	}

	public String records(String name) {
		  
		try {
			 InitialContext ict = new InitialContext();
			 //��ȡconnectionFactory����  
			 QueueConnectionFactory factory = (QueueConnectionFactory)ict.lookup("ConnectionFactory");  
			 //��ȡConnection����  
			 QueueConnection connection = factory.createQueueConnection();  
			 //��ȡSession���󣬵�һ��������ʾ�����Զ��ύ���ڶ���������ʾһ����Ϣ����ȷ���ͣ����Զ�������Ӧ  
			 QueueSession session = connection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);       
			 //��ȡdestination����  
			 Queue queue = (Queue)ict.lookup("queue/queue1");     
			 //������Ϣ 
			
			 TextMessage tm = session.createTextMessage(name);          
			 //��ȡsender����  
			 QueueSender sender = session.createSender(queue);     
			 //������Ϣ  
			 sender.send(tm);               
			 session.close();          
			 System.out.println("��Ϣ�Ѿ����ͣ�");  
			
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
		     return "�ϴε�¼ʱ��"+date1;
	     }else{
	    	 return "���ǵ�һ�ε�¼��";
	     }
	}
}
