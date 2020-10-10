import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

class app extends JFrame
{
	app()
	{
		JPanel panel = new JPanel();
		JSlider slider1 = new JSlider();
		panel.add(slider1);
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
