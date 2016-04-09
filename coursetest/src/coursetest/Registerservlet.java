package coursetest;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

@SuppressWarnings("serial")
public class Registerservlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
        String username=req.getParameter("username"); 
        String password=req.getParameter("password1");
        String spassword=req.getParameter("password2");
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter(); 
        if(password.equals(spassword)){
        	  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
              try {  
            	  
            	  
            	  File f=new File("workspace/coursetest/users.xml"); 
      			DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance(); 
      			DocumentBuilder builder=factory.newDocumentBuilder(); 
      		    Document doc = builder.parse(f); 
      			NodeList nl = doc.getElementsByTagName("user"); 
      			for(int i=0;i<nl.getLength();i++){ 
      			String name=doc.getElementsByTagName("username").item(i).getFirstChild().getNodeValue();
      			String pass=doc.getElementsByTagName("password").item(i).getFirstChild().getNodeValue();
      			
      			if(username.equals(name)){
      				   resp.setContentType("text/html");
      					//PrintWriter out=resp.getWriter();
      					out.print("<p>�û����Ѵ��ڣ�</p>");
      					out.close();
      					break;	
      				}
            	  
      			if(i==nl.getLength()-1)
            	  
      			{	
            	  
                  DocumentBuilder db = dbf.newDocumentBuilder();  
                  Document doc1 = db.parse("workspace/coursetest/users.xml");  
                 Element user=doc1.createElement("user");
                  Element eusername=doc1.createElement("username");
                 Element epassword=doc1.createElement("password");
                 Text tusername=doc1.createTextNode(username);
                Text tpassword=doc1.createTextNode(password);
               user.appendChild(eusername).appendChild(tusername);
                 user.appendChild(epassword).appendChild(tpassword);
                Node nusers=doc1.getDocumentElement().appendChild(user);
                 Element Root= doc1.getDocumentElement();   
                   Root.appendChild(nusers); 
      			
                  doc2XmlFile(doc1, "workspace/coursetest/users.xml");  
                  out.print("ע��ɹ���");
              	  out.print("<a href=\"login.jsp\">�����½</a>");
              	  out.close();
      			}
      		  }
             } catch (ParserConfigurationException e) {  
                   e.printStackTrace();  
             } catch (SAXException e) {  
                   e.printStackTrace();  
               } catch (IOException e) {  
                   e.printStackTrace();  
              }  
              
          }  
        else{
        	  out.print("ע��ʧ�ܣ�������");
        	  out.print("<a href=\"register.jsp\">ע��</a>");
        	  out.close();
        } 
    }

public static boolean doc2XmlFile(Document document, String filename) {  
        boolean flag = true;  
        try {  
            /** ��document�е�����д���ļ��� */  
             TransformerFactory tFactory = TransformerFactory.newInstance();  
             Transformer transformer = tFactory.newTransformer();  
             /** ���� */  
             transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");  
             DOMSource source = new DOMSource(document);  
             StreamResult result = new StreamResult(new File("workspace/coursetest/users.xml"));  
             transformer.transform(source, result);  
        } catch (Exception ex) {  
             flag = false;  
             System.out.println("ע��ʧ�ܣ�");  
             ex.printStackTrace();  
         }  
           return flag;  
   }  
}
