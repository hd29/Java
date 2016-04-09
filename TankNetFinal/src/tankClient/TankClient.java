package tankClient;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class TankClient extends Frame{
	
	int width = 900;
	int height = 600;
	
	static int totle = 0;
	static InetAddress IP ;
	static int port ;
	static int gameNum = 0 ;
	static int life = 9 ;
	static int killedTank = 0 ;
	
	
	Image bufferImage;
	
	
	ConnectServer cs = new ConnectServer();
	
	public TankClient() throws UnknownHostException, IOException {
		
		this.setTitle("Tank War");
		this.setSize(width,height );
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setBackground(Color.BLACK);
		new RepaintThread().start();
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {

				System.exit(0);
			}	
		});

		this.addKeyListener(new KeyAdapter(){
				
				@Override
				public void keyTyped(KeyEvent e) {

					if(e.getKeyChar()=='a'){
						cs.sendToServer("a");
					
					}
					if(e.getKeyChar()=='d'){
						cs.sendToServer("d");
					}
					if(e.getKeyChar()=='w'){
						cs.sendToServer("w");
					}
					if(e.getKeyChar()=='s'){
						cs.sendToServer("s");
					}
					
					if(e.getKeyChar()=='k'){
						cs.sendToServer("k");
						
					}
					if(e.getKeyChar()=='l'){
						cs.sendToServer("l");
					}
					if(e.getKeyChar()=='p'){
						cs.sendToServer("p");
					}	
				}

				@Override
				public void keyPressed(KeyEvent e) {	
				}
				
				@Override
				public void keyReleased(KeyEvent e) {	
				}
			});
	}
    @Override
    public void update(Graphics g) {
    	
    	if(bufferImage==null){
    		bufferImage = this.createImage(width, height);
    	}
    	Graphics big = bufferImage.getGraphics();
    	big.clearRect(0, 0, width, height);
    	paint(big);
    	g.drawImage(bufferImage, 0, 0,null);
    
    }
    java.awt.Image imageL = new ImageIcon("images/lake.png").getImage();
    java.awt.Image imageS = new ImageIcon("images/steel.png").getImage();
    java.awt.Image imageB = new ImageIcon("images/lbrick.png").getImage();
    java.awt.Image imageTD = new ImageIcon("images/tankD.gif").getImage();
    java.awt.Image imageTU = new ImageIcon("images/tankU.gif").getImage();
    java.awt.Image imageTL = new ImageIcon("images/tankL.gif").getImage();
    java.awt.Image imageTR = new ImageIcon("images/tankR.gif").getImage();

    public void paintInforn(Graphics g) {
    	
    	g.setColor(Color.blue);
    	g.fillRect(600, 0, 300, 600);
    	g.setColor(Color.black);
    	g.drawString("在线人数：" +totle , 650, 50);
    	g.drawString("你的IP：" +IP , 650, 80);
    	g.drawString("你的端口：" +port , 650, 110);
    	g.drawString("你的游戏编号：" +gameNum , 650, 140);
    	g.drawString("你的生命值：" +life , 650, 170);
    	g.drawString("杀敌数：" +killedTank , 650, 200);
	
    }
    
    @Override
	public void paint(Graphics g) {
		
    	MyTank.paintMyTank(g);
    	
    	Map.paintMap(g);
    	
    	BadTank.paintEnemyTank(g);
		
    	BulletC.paintBullet(g);
    	
    	paintInforn(g);
    	
    	cs.sendBadTanKState();
    	
}

   
   
    
public static void main(String[] args) throws UnknownHostException, IOException {
	
	new TankClient();
	
}
public class RepaintThread extends Thread{
	@Override
	public void run() {
		while (true){
			repaint();
			try {
				sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
}
