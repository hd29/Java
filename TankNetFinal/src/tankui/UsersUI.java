package tankui;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.UnknownHostException;

import tankAlong.MyFrame;
import tankAlong.MyThread;
import tankClient.TankClient;

@SuppressWarnings("serial")
public class UsersUI extends Frame{
	
	int width = 600;
	int height = 500;
	Button btnAlong = new Button("单人单机版");
	Button btnTwo = new Button("双人单机版");
	Button btnNetTwo = new Button("双人网络版");
	Button btnNetMome = new Button("多人对战版");
	public UsersUI() {
		
		this.setTitle("Tank War");
		this.setSize(width,height );
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setBackground(Color.pink);
		this.setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {

				System.exit(0);
			}	
		});
		
		btnAlong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
                dispose(); 
				//new MyFrame(); 
                new MyThread().start();
			}
		});
		
		btnTwo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		btnNetTwo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				try {
					new TankClient();
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					System.out.println("srever is not started!");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		btnNetMome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		btnAlong.setBounds(250, 200, 100, 20);
		btnTwo.setBounds(250, 250, 100, 20);
		btnNetTwo.setBounds(250, 300, 100, 20);
		btnNetMome.setBounds(250, 350, 100, 20);
		
		this.add(btnAlong);
		this.add(btnTwo);
		this.add(btnNetTwo);
		this.add(btnNetMome);
	}
	
	@Override
	public void paint(Graphics g) {
		g.setFont(new Font("宋体", 1, 39));
		g.drawString("坦 克 大 战", 185, 150);
	}
	public static void main(String[] args) {
		new UsersUI();
		
	}
}
