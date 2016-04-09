package rlmdb;

import java.util.Date;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@MessageDriven(  
	  activationConfig = {  
	    @ActivationConfigProperty(propertyName="destinationType",propertyValue="javax.jms.Queue"),
	    @ActivationConfigProperty(propertyName="destination",propertyValue="queue/queue1")  
	       } )  
public class MDBean implements MessageListener {  
	 
	  @PersistenceContext(unitName="RLJPA")
      private EntityManager manager;
	
    public void onMessage(Message msg) {

    try {
 	  TextMessage message = (TextMessage)msg; 
 	      Date date = new Date();
    	  MDBEntity r = new MDBEntity();  
	       r.setName(message.getText());
	       r.setDate(date);
	       r.setId(29);
	       manager.persist(r);  
	    //  System.out.println("µÇÂ¼Ê±¼ä£º"+ message.getText());
		 
      } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  
	}  
     
     
}  
