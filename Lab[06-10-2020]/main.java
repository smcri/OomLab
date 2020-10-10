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

	app()
	{
		

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

		String hex = String.format("#%02X%02X%02X", r, g, b);  


		panel.add(label1);
		panel.add(label2);
		label1.setText("Diameter : " + slider[0].getValue());
		label2.setText("RGB : " + hex);

		
		add(panel);
		setSize(300,300);
		show();
	}

	public void stateChanged(ChangeEvent e)
	{
		r = slider[1].getValue();
		g = slider[2].getValue();
		b = slider[3].getValue();
		String hex = String.format("#%02X%02X%02X", r, g, b);

		label1.setText("Diameter : " + slider[0].getValue());
		label2.setText("RGB : " + hex);
	}
}

class main
{
	public static void main(String args[])
	{
		app a1 = new app();
	}
}
