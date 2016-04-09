package tankAlong;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;

public class MyFrame extends Frame {
	int height = 600;
	int width = 600;
	int x=230,y=200,d,d1,k;
	int i=x,j=y,n=20,m=20;
	int w,r,count=0,count1=0,totle=0;
	int d2,d3,d4,r1,r2,r3,r4,n1,n2,n3,n4,m1,m2,m3,m4;
	int dis = 0,dis2 = 0,dis3 = 0,dis4 = 0;
	int life=9,p=0;
	int b1,b2,b3,b4;
	int level;
	int f;
	boolean nextLevel;
	boolean flag ;
	int wea ;
	Image bufferImage;
	CreatTank tank = new CreatTank();
	Thread  thread = new Thread();
	Weapon weapon = new Weapon();
	CreateBullet bullet = new CreateBullet();
	int [][] map1 = {
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,1,1,1,1,0,3,3,3,3,3,0,0,0},
			{0,0,1,1,1,1,0,2,2,2,2,2,0,0,0},
			{0,0,1,1,1,1,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,3,3,0},
			{0,0,0,0,0,0,0,1,1,1,1,1,3,3,0},
			{0,0,3,3,3,3,3,3,3,3,3,3,3,3,0},
			{0,0,0,0,0,0,0,0,0,0,1,1,1,1,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,1,1,1,1,1,1,1,1,1,1,1,1,0},
			{0,0,2,1,1,1,1,2,2,2,2,3,1,1,0},
			{0,0,2,3,3,3,3,3,3,3,3,3,3,3,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
	public MyFrame() {
		this.setTitle("Tank War");
		this.setLocation(220, 80);
		this.setVisible(true);
		this.setResizable(false);
		this.setSize(height, width);
		this.setBackground(Color.BLUE);
		this.addWindowListener(new WindowAdapter() {
	    @Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		    }	
	    });
		
		 this.addKeyListener(new KeyAdapter(){
				
				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					if(e.getKeyChar()=='a'){
						if(x>5&&ismoveable(x, y, 0,level))
						x=x-10;
						d=0;
					}
					if(e.getKeyChar()=='d'){
						if(x<width-50&&ismoveable(x, y, 2,level))
						x=x+10;
						d=2;
					}
					if(e.getKeyChar()=='w'){
						if(y>29&&ismoveable(x, y, 3,level))
						y=y-10;
						d=3;
					}
					if(e.getKeyChar()=='s'){
						if(y<height-50&&ismoveable(x, y, 1,level))
						y=y+10;
						d=1;
					}
					
					if(e.getKeyChar()=='k'){
						k=1;
						
					}
					if(e.getKeyChar()=='l'){
						life=9;	
					}
					if(e.getKeyChar()=='p'){
						if(life>0){
						p=1;
						if(dis==0&&dis!=1)
						dis=1;
						if(dis2==0&&dis2!=1)
						dis2=1;
						if(dis3==0&&dis3!=1)
						dis3=1;
						if(dis4==0&&dis4!=1)
						dis4=1;}
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
    	count++;
		count1++;
		
		
		
		
    	if(bufferImage==null){
    		bufferImage = this.createImage(width, height);
    	}
    	Graphics big = bufferImage.getGraphics();
    	big.clearRect(0, 0, width, height);
    	paint(big);
    	if(totle==20){
			g.setColor(Color.red);
			g.drawString("恭喜通过第"+level+"关", 263, 233);
			try {
				new Thread().sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			totle=0;
			level++;
		}
    	g.drawImage(bufferImage, 0, 0,null);
    
    }
    java.awt.Image imageL = new ImageIcon("images/lake.png").getImage();
    java.awt.Image imageS = new ImageIcon("images/steel.png").getImage();
    java.awt.Image imageB = new ImageIcon("images/lbrick.png").getImage();

    @Override
	public void paint(Graphics g) {
		
		for (int i = 0; i < map1.length; i++) {
			for (int j = 0; j < map1.length; j++) {
				if(map1[i][j]==1){
					g.drawImage(imageL, j*40, i*40, 40, 40, null);
				}
				if(map1[i][j]==2){
					g.drawImage(imageS, j*40, i*40, 40, 40, null);
				}
				if(map1[i][j]==3){
					System.out.println(33333);
					g.drawImage(imageB, j*40, i*40, 40, 40, null);
				}
			}
			
		}
		
		
		
//		map(g,level);
		
		killAll(g);	
		
		xtank(g);
	   
		life(g, tank.i, tank.j,d);
	   
		
//		getRect() ;
//		isHit();
		stopFire();
		clear_xtank(g);	
	}
	
	/**
	 * 敌方tank出现的位置,即tank的移动
	 * @param r
	 * @param l
	 * @param t
	 */
	public void tankLocation(int r,int l ,int t){
		if(t==1){
		if(r==0&&l==0){
			if(n>15){
			n=n-25;
			b1--;
			}else{
				r1=2;
				b1=5;
			}
		}
		if(r==1&&l==1){
			if(m<height-60){
			m=m+25;
			b1--;
			}else{
				r1=3;
				b1=5;
			}
		}
		if(r==2&&l==2){
			if(n<width-60){
			n=n+25;
			b1--;
			}else{
				r1=0;
				b1=5;
			}
		}
		if(r==3&&l==3){
			if(m>29){
			m=m-25;
			b1--;
			}else{
				r1=1;
				b1=5;
			}
		}
		}
		if(t==2){
			if(r==0&&l==0){
				if(n2>-285){
				n2=n2-25;
				b2--;
				}else{
					r2=2;
					b2=5;
				}
			}
			if(r==1&&l==1){
				if(m2<height-80){
				m2=m2+25;
				b2--;
				}else{
					r2=3;
					b2=5;
				}

			}
			if(r==2&&l==2){
				if(n2<width-360){
				n2=n2+25;
				b2--;
				}else{
					r2=0;
					b2=5;
				}

			}
			if(r==3&&l==3){
				if(m2>19){
				m2=m2-25;
				b2--;
				}else{
					r2=1;
					b2=5;
				}

			}
			}
		if(t==3){
				if(r==0&&l==0){
					if(n3>15){
					n3=n3-25;
					b3--;
					}else{
						r3=2;
						b3=5;
					}

				}
				if(r==1&&l==1){
					if(m3<height-360){
					m3=m3+25;
					b3--;
					}else{
						r3=3;
						b3=5;
					}

				}
				if(r==2&&l==2){
					if(n3<width-60){
					n3=n3+25;
					b3--;
					}else{
						r3=0;
						b3=5;
					}

				}
				if(r==3&&l==3){
					if(m3>-285){
					m3=m3-25;
					b3--;
					}else{
						r3=1;
						b3=5;
					}

				}
		        }
		if(t==4){
			if(r==0&&l==0){
				if(n4>-285){
				n4=n4-25;
				b4--;
				}else{
					r4=2;
					b4=5;
				}
			}
			if(r==1&&l==1){
				if(m4<height-360){
				m4=m4+25;
				b4--;
				}else{
					r4=3;
					b4=5;
				}
			}
			if(r==2&&l==2){
				if(n4<width-360){
				n4=n4+25;
				b4--;
				}else{
					r4=0;
					b4=5;
				}
			}
			if(r==3&&l==3){
				if(m4>-285){
				m4=m4-25;
				b4--;
				}else{
					r4=1;
					b4=5;
				}
			}
			}
	}
	/**
	 * tank的生命值
	 * @param g
	 * @param tanki
	 * @param tankj
	 * @param d
	 */
	public void life(Graphics g,int tanki,int tankj,int d) {
	
		g.setColor(Color.red);
		g.drawString("生命值：", 10, 40);
		g.fillRect(60, 25, life*10, 20);
		g.drawRect(60, 25, 90, 20);
		g.drawString("杀敌数："+totle, 510, 40);
		g.drawString("第"+level+"关", 290, 40);
		if((x-26<tanki&&tanki<x+26)&&(y-26<tankj&&tankj<y+26)&&life!=0){
			life--;
			if(life==0){
				java.awt.Image image = new ImageIcon("images/6.gif").getImage();
				g.drawImage(image, x,y,null);
			}
		}
        if(life>0){
		tank.paint(g,x,y,d,1);	
		g.drawRect(x+5, y+5, 39, 39);
		}
        if(life==0){
		g.drawString("游戏结束，请按L开始", 220, 300)	;
		}
	}
	/**
	 * 一键秒杀
	 * @param g
	 */
	public void killAll(Graphics g) {
		if(p==1){
		java.awt.Image image = new ImageIcon("images/6.gif").getImage();
		g.drawImage(image, 55, 55,null);
		g.drawImage(image, 65, 155,null);
		g.drawImage(image, 95, 255,null);
		g.drawImage(image, 155, 455,null);
		g.drawImage(image, 255, 55,null);
		g.drawImage(image, 285, 255,null);
		g.drawImage(image, 225, 355,null);
		g.drawImage(image, 455, 55,null);
		g.drawImage(image, 555, 455,null);
		g.drawImage(image, 455, 255,null);
		p=0;
		}
	}
	/**
	 * 画出地图
	 * @param g
	 */
	public void map(Graphics g,int level) {
		if(wea!=2&&wea!=9)
		wea = (int)(Math.random()*100);
		if(wea==2){
//			int xOfBlood = (int)(Math.random()*500+20);
//			int yOfBlood = (int)(Math.random()*500+20);
			weapon.drawBlood(g,33,333);
			
		}
		if(wea==9){
//			int xOfBomb = (int)(Math.random()*500+20);
//			int yOfBomb = (int)(Math.random()*500+20);
			weapon.drawBomb(g,33,33);
		}
		g.setColor(Color.gray);
		if(level==1){
		g.fillRect(152, 452, 50, 20);
		g.fillRect(152, 102, 50, 20);
		g.fillRect(152, 152, 50, 20);
		g.fillRect(152, 202, 50, 20);
		g.fillRect(152, 252, 50, 20);
		g.fillRect(152, 302, 50, 20);
		g.fillRect(152, 352, 50, 20);
		g.fillRect(152, 402, 50, 20);
		g.fillRect(382, 452, 50, 20);
		g.fillRect(382, 102, 50, 20);
		g.fillRect(382, 152, 50, 20);
		g.fillRect(382, 202, 50, 20);
		g.fillRect(382, 252, 50, 20);
		g.fillRect(382, 302, 50, 20);
		g.fillRect(382, 352, 50, 20);
		g.fillRect(382, 402, 50, 20);
		g.fillRect(272, 252, 20, 50);
		g.fillRect(302, 252, 20, 50);
		g.fillRect(332, 252, 20, 50);
		g.fillRect(212, 252, 20, 50);
		g.fillRect(242, 252, 20, 50);
		}
		if(level==0){
			g.fillRect(102, 62, 50, 450);
			g.fillRect(152, 462, 300, 50);
			}
	}
	/**
	 * 画出敌方tank
	 * @param g
	 */
	private void xtank(Graphics g) {
		f=(int)(Math.random()*4);
		if(count>=29){
			if(b1==0){
				b1=(int)(Math.random()*6);
				r1=(int)(Math.random()*4);
			}
			if(b2==0){
				b2=(int)(Math.random()*6);
				r2=(int)(Math.random()*4);
			}
			if(b3==0){	
				b3=(int)(Math.random()*6);
			    r3=(int)(Math.random()*4);
			}
			if(b4==0){	
				b4=(int)(Math.random()*6);
			    r4=(int)(Math.random()*4);
			}
			tankLocation(r1, d1,1);
			d1=r1;
			tankLocation(r2, d2,2);
			d2=r2;
			tankLocation(r3, d3,3);
			d3=r3;
			tankLocation(r4, d4,4);
			d4=r4;
			count=0;
			}
		if(dis==0){
			if(f==0){
			    tank.paint(g,n,m,d1,0);
			}else{
				tank.paint(g,n,m,d1,1);	
			}	
		}
			if(dis==2&&count1>=100){
				dis=0;
				count1=0;
			}
			if(dis==1){
				java.awt.Image image = new ImageIcon("images/6.gif").getImage();
				g.drawImage(image, n, m,null);
				n = (int)(Math.random()*555);
				m = (int)(Math.random()*555);
				dis=2;
				totle++;
			}
			
			if(dis2==0){
				if(f==1){
					tank.paint(g,n2+300,m2+20,d2,0);
				}else{
					tank.paint(g,n2+300,m2+20,d2,1);
				}
				
			}
			if(dis2==2&&count1>=50){
				dis2=0;
				count1=0;
			}
			if(dis2==1){
				java.awt.Image image = new ImageIcon("images/6.gif").getImage();
				g.drawImage(image, n2+300, m2+20,null);
				n2 = (int)(Math.random()*555)-300;
				m2 = (int)(Math.random()*555)-20;
				dis2=2;
				totle++;
				}
			if(dis3==0){
				if(f==2){
					tank.paint(g,n3,m3+300,r3,0);
				}else{
					tank.paint(g,n3,m3+300,r3,1);
				}
				
			}
			if(dis3==2&&count1>=50){
				dis3=0;
				count1=0;
			}
			if(dis3==1){
				java.awt.Image image = new ImageIcon("images/6.gif").getImage();
				g.drawImage(image, n3,m3+300,null);
				n3 = (int)(Math.random()*555);
				m3 = (int)(Math.random()*555)-300;
				dis3=2;
				totle++;
					}
			if(dis4==0){
				if(f==3){
					tank.paint(g,n4+300,m4+300,r4,0);
				}else{
					tank.paint(g,n4+300,m4+300,r4,1);
				}
				
			}
			if(dis4==2&&count1>=50){
				dis4=0;
				count1=0;
			}
			if(dis4==1){
				java.awt.Image image = new ImageIcon("images/6.gif").getImage();
				g.drawImage(image, n4+300,m4+300,null);
				n4 = (int)(Math.random()*555)-300;
				m4 = (int)(Math.random()*555)-300;
				dis4=2;
				totle++;
			}

	}
	/**
	 * 清楚被击中的敌方tank
	 * @param g
	 */
	private void clear_xtank(Graphics g) {
		if(k==0){
			w=d;
			i=x;
			j=y;
		}
		if(k==1&&life>0){
			if(i>width-20||i<0||j>height-20||j<0||isHit()){
				k=0;
				i=x;
				j=y;
//				System.out.println(name());
				
			}
			if(i==x&&j==y){
				w=d;
			}
			if((n-20<i&&i<n+20)&&(m-20<j&&j<m+20)){
				if(dis!=2){
				dis=1;
				k=0;}
			}
			if((n2+280<i&&i<n2+320)&&(m2<j&&j<m2+40)){
				if(dis2!=2){
				dis2=1;
				k=0;}
			}
			if((n3-20<i&&i<n3+20)&&(m3+280<j&&j<m3+320)){
				if(dis3!=2){
				dis3=1;
				k=0;}
			}
			if((n4+280<i&&i<n4+320)&&(m4+280<j&&j<m4+320)){
				if(dis4!=2){
				dis4=1;
				k=0;}
			}
			bullet.paint(g, i, j, w);
			switch (w) {
			case 0:
				i=i-15;
				break;
			case 1:
				j=j+15;
				break;
			case 2:
				i=i+15;
				break;
			case 3:
				j=j-15;
				break;
			default:
				break;
			}
		}

	}
	public Rectangle getRect() {
		return new Rectangle(i, j, 12, 12);
		}
	public boolean isHit() {
		return this.getRect().intersects(tank.getRect());
	}
	public void stopFire() {
		//System.out.println(isHit());
		if(isHit()){
			tank.noFire();
		}
	}
	public boolean ismoveable(int XOfTank, int YOfTank,int d5,int level) {
	
        if(level==0){
        	flag = true;
		}
		
		if(level==1){
			if(d5==0){
				   if((152<=XOfTank&&XOfTank<=152+50)||(382<=XOfTank&&XOfTank<=382+50)){
					 if(102-45<YOfTank&&YOfTank<452){
						flag = false;
					 }else{
						flag = true;
					 }
				   }else{
					    flag = true;
				   }
				}
				
				if(d5==3){
					   if((152-40<=XOfTank&&XOfTank<=152+45)||(382-50<=XOfTank&&XOfTank<=382+45)){
						 if((102-45<YOfTank)&&(YOfTank<480)){
							flag = false;
						 }else{
							flag = true;
						 }
					   }else{
						   if((152+44<=XOfTank&&XOfTank<=382-45)){
								 if((229<YOfTank)&&(YOfTank<275+30)){
									flag = false;
								 }else{
									flag = true;
								 }
							   }else{
								    flag = true;
							   }
					   }
					}
				if(d5==1){
					   if((152-40<=XOfTank&&XOfTank<=152+45)||(382-50<=XOfTank&&XOfTank<=382+45)){
						 if((102-45<YOfTank)&&(YOfTank<480)){
							flag = false;
						 }else{
							flag = true;
						 }
					   }else{
						   if((152+44<=XOfTank&&XOfTank<=382-45)){
								 if((209<YOfTank)&&(YOfTank<275+24)){
									flag = false;
									}else{
									flag = true;
									}
							   }else{
								    flag = true;
								   }
					   }
					   
					}
				
				if(d5==2){
					   if((152-45<=XOfTank&&XOfTank<=152)||(382-45<=XOfTank&&XOfTank<=382)){
						 if(102-45<YOfTank&&YOfTank<452){
							flag = false;
						 }else{
							flag = true;
						 }
					   }else{
						    flag = true;
					   }
					}
		}
		
		return flag ;
		
	}
public static void main(String[] args) {
	MyThread myThread = new MyThread();
	myThread.start();
}
}
