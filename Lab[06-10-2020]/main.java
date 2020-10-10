import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

class app extends JFrame implements ChangeListener
{
	JPanel panel = new JPanel();
	JSlider slider[] = new JSlider[4];

	JLabel label = new JLabel();

	app()
	{
		

		for(int i = 0;i<4;i++)
		{
			if(i == 0)
				slider[i] = new JSlider(0,300);
			else
				slider[i] = new JSlider(0, 250);
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

		panel.add(label);
		label.setText("Diameter : " + slider[0].getValue());

		
		add(panel);
		setSize(300,300);
		show();
	}

	public void stateChanged(ChangeEvent e)
	{
		label.setText("Diameter : " + slider[0].getValue());
	}
}

class main
{
	public static void main(String args[])
	{
		app a1 = new app();
	}
}
