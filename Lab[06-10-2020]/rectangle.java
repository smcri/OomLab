import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class ShapeAndSliderTest {

    public ShapeAndSliderTest() {
        createAndShowGui();
    }

    private void createAndShowGui() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        final MyRectangle myRectangle = new MyRectangle(10, 10, 50,50, Color.RED);

        JSlider jslider = new JSlider();
        jslider.setValue(50);
        jslider.setMaximum(250);
        jslider.setMinorTickSpacing(5);
        jslider.setMajorTickSpacing(10);
        jslider.setPaintTicks(true);
        jslider.setPaintLabels(true);
        
         JSlider jslider2 = new JSlider();
        jslider2.setValue(50);
        jslider2.setMaximum(250);
        jslider2.setMinorTickSpacing(5);
        jslider2.setMajorTickSpacing(10);
        jslider2.setPaintTicks(true);
        jslider2.setPaintLabels(true);
        
         JSlider jslider3 = new JSlider();
        jslider3.setValue(50);
        jslider3.setMaximum(250);
        jslider3.setMinorTickSpacing(5);
        jslider3.setMajorTickSpacing(10);
        jslider3.setPaintTicks(true);
        jslider3.setPaintLabels(true);
        
         JSlider jslider4 = new JSlider();
        jslider4.setValue(50);
        jslider4.setMaximum(250);
        jslider4.setMinorTickSpacing(5);
        jslider4.setMajorTickSpacing(10);
        jslider4.setPaintTicks(true);
        jslider4.setPaintLabels(true);

        // We'll just use the standard numeric labels for now...
        jslider.setLabelTable(jslider.createStandardLabels(50));

        final JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics grphcs) {
                super.paintComponent(grphcs);

                Graphics2D g2d = (Graphics2D) grphcs;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

                myRectangle.draw(g2d);
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(300, 300);
            }
        };

        jslider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                JSlider slider = (JSlider) ce.getSource();

                if (!slider.getValueIsAdjusting()) {
                    int newW = slider.getValue();
                    int newH = slider.getValue();

                    myRectangle.setWidth(newW);
                    myRectangle.setHeight(newH);

                    System.out.println(newW + "," + newH);

                    panel.repaint();
                }
            }
        });
        jslider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                JSlider slider = (JSlider) ce.getSource();

                if (!slider.getValueIsAdjusting()) {
                    int newW = slider.getValue();
                    int newH = slider.getValue();

                    myRectangle.setWidth(newW);
                    myRectangle.setHeight(newH);

                    System.out.println(newW + "," + newH);

                    panel.repaint();
                }
            }
        });
        
        jslider2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                JSlider slider = (JSlider) ce.getSource();

                if (!slider.getValueIsAdjusting()) {
                    int newr = slider.getValue();

                    myRectangle.setR(newr);

                    System.out.println(newr + "," + newr);

                    panel.repaint();
                }
            }
        });
        
       jslider3.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                JSlider slider = (JSlider) ce.getSource();

                if (!slider.getValueIsAdjusting()) {
                    int newg = slider.getValue();

                    myRectangle.setG(newg);

                    System.out.println(newg + "," + newg);

                    panel.repaint();
                }
            }
        });
        
       jslider4.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                JSlider slider = (JSlider) ce.getSource();

                if (!slider.getValueIsAdjusting()) {
                    int newb = slider.getValue();

                    myRectangle.setB(newb);

                    System.out.println(newb + "," + newb);

                    panel.repaint();
                }
            }
        });

        frame.add(jslider, BorderLayout.SOUTH);
        frame.add(jslider2, BorderLayout.EAST);
        frame.add(jslider3, BorderLayout.WEST);
        frame.add(jslider4,BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ShapeAndSliderTest();
            }
        });
    }
}

class MyRectangle {

    private int x, y, width, height,r,g,b;
    private final Color color;

    public MyRectangle(int x, int y, int w, int h, Color color) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.color = color;
    }

    void draw(Graphics2D g2d) {
        Color prevState = g2d.getColor();

        g2d.setColor(new Color(r,g,b));

        g2d.drawOval(x, y, width, height);

        g2d.setColor(new Color(r,g,b));
        
        g2d.fillOval(x,y,width,height);

    }

    public void setX(int x) {
        this.x = x;
    }
    
    public void setR(int r) {
        this.r = r;
    }
    public void setG(int g) {
        this.g = g;
        System.out.println(this.g + "," + this.g);
    }
    public void setB(int b) {
        this.b = b;
        System.out.println(this.b + "," + this.b);
    }

    public void setY(int b) {
        this.y = y;
    }

    public void setWidth(int w) {
        this.width = w;
    }

    public void setHeight(int h) {
        this.height = h;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
