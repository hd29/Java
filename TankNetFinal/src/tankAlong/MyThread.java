package tankAlong;




public class MyThread extends Thread {
	MyFrame myFrame = new MyFrame();

	@Override
	public void run() {
		while (true) {
		myFrame.repaint();
			
			try {
				sleep(29);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
