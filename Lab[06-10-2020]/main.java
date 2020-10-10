import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

class app extends JFrame
{
	app()
	{
		JPanel panel = new JPanel();
		JSlider slider[] = new JSlider[4];
		for(int i = 0;i<4;i++)
		{
			slider[i] = new JSlider();
			slider[i].setPaintTrack(true);
			slider[i].setPaintTicks(true);
			slider[i].setPaintLabels(true);

			slider[i].setMajorTickSpacing(50); 
        	slider[i].setMinorTickSpacing(5); 
			panel.add(slider[i]);
		}
		
		add(panel);
		setSize(300,300);
		show();
	}
}

class main
{
	public static void main(String args[])
	{
		app a1 = new app();
	}
}
