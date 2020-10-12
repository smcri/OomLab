import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

class app extends JFrame implements ChangeListener
{
	JPanel panel = new JPanel();
	JSlider slider[] = new JSlider[4];

	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel();

	int r,g,b;
	int d,x;
	
	//Graphics g1;
	//Graphics2D g2d;

	app()
	{
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		//g2d = (Graphics2D) g1;
		
		for(int i = 0;i<4;i++)
		{
			if(i == 0)
				slider[i] = new JSlider(0,300);
			else
				slider[i] = new JSlider(0, 255);
			slider[i].setPaintTrack(true);
			slider[i].setPaintTicks(true);
			slider[i].setPaintLabels(true);

			if(i == 0)
				slider[i].setMajorTickSpacing(150);
			else
				slider[i].setMajorTickSpacing(50);  
        	slider[i].setMinorTickSpacing(5);
        	slider[i].addChangeListener(this);
			panel.add(slider[i]);
		}

		r = slider[1].getValue();
		g = slider[2].getValue();
		b = slider[3].getValue();
		
		d = slider[0].getValue();
		
		String hex = String.format("#%02X%02X%02X", r, g, b);  

		
		panel.add(label1);
		panel.add(label2);
		label1.setText("Diameter : " + d);
		label2.setText("RGB : " + hex);
		
		 //g2d.drawOval(0,600,d,d);
		 //g2d.setColor(new Color(r,g,b));
		 //g2d.fillOval(0,600,d,d);
		
		add(panel);
		setSize(300,300);
		show();
	}
	
	public void paintComponent(Graphics g1)  
	{    
  
	 //draw circle outline  
		 super.paint(g1);
		 
		 Graphics2D g2d = (Graphics2D) g1;
		 
		 g2d.drawOval(0,600,d,d);  
  
	 //set color to RED  
	 //So after this, if you draw anything, all of it's result will be RED  
		 g2d.setColor(new Color(r,g,b));  
  
	 //fill circle with RED  
		 g2d.fillOval(0,600,d,d);  
	}  

	public void stateChanged(ChangeEvent e)
	{
		r = slider[1].getValue();
		g = slider[2].getValue();
		b = slider[3].getValue();
		String hex = String.format("#%02X%02X%02X", r, g, b);
		d = slider[0].getValue();

		label1.setText("Diameter : " + d);
		label2.setText("RGB : " + hex);
		repaint();
		//paint(g2d);
	}
}

class main
{
	public static void main(String args[])
	{
		app a1 = new app();
	}
}
