package plejb;

import javax.naming.InitialContext;
import javax.naming.NamingException;



	public class RLJpaClient  {
		public static void main(String[] args) throws NamingException {
			InitialContext con=new InitialContext();
			RLRemoteInfo lr1=(RLRemoteInfo)con.lookup("RLSessionBean/remote");
		
			
			try {
				
			//	RLRemoteInfo lr1=(RLRemoteInfo)con.lookup("RLSessionBean/remote");
				//String s = lr.register(name, pass, pass1);
				String s1 = lr1.register("lffff", "1992", "1992");
				System.out.println(s1);
				if(s1.equals("yes")){
					System.out.println("zhucechenggong");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	        	System.out.println("第二个异常");
			}
			
			
			try {
				String s = lr1.records("linding");
				System.out.println(s);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	 
	}
}
