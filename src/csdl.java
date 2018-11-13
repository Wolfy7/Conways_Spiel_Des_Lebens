import java.awt.Toolkit;

import javax.swing.JFrame;


public class csdl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Long lGeneration = 0l;
		
		Toolkit t =  Toolkit.getDefaultToolkit();
 
		JFrame f = new JFrame();
		f.setTitle("Conways Spiel des Lebens");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setUndecorated(true);
		
		Panel p = new Panel( t.getScreenSize().width, t.getScreenSize().height );
		
		f.add(p);
		
		f.setVisible(true);
		
		while(true){
			//System.out.println(lGeneration);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			p.updateCells();
			p.repaint();
			lGeneration++;
		}
		
		
	}

}
