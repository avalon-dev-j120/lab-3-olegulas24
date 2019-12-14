
package Calculator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.*;
import static java.awt.BorderLayout.*;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class CalculatorWindow extends JFrame {
    final int width = 300;
    final int height = 400;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton buttonEq;
    private JButton button0;
    private JButton buttonCE;
    private JButton buttonPoint;
    private JButton buttonPlus;
    private JButton buttonMinus;
    private JButton buttonMult;
    private JButton buttonDev;
    
    private JLabel label;
    public CalculatorWindow (){        
        setTitle("Calculator");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        setVisible(true);
        setSize(width, height);
        
        /**
         * Метод setMaximumSize не работает из-за бага непосредственно
         * в платформе java.
         * В связи с этим, установлен полный запрет на изменение размеров окна.
         * @link https://bugs.java.com/bugdatabase/view_bug.do?bug_id=6464548
         **/
        
        this.setMaximumSize(new Dimension(400, 500));
        this.setMinimumSize(new Dimension(300, 400));
        setResizable(false);
        
        
        LayoutManager layout = new BorderLayout(10, 10);
        setLayout(layout);
        
        JPanel panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(WIDTH, 70));
        panel1.setVisible(true);
        panel1.setBackground(Color.lightGray);
                
        add(panel1, NORTH);
        JPanel panel2 = new JPanel();
        panel2.setSize(100, 100);
        panel2.setVisible(true);
        add(panel2, CENTER);
        JPanel panel3 = new JPanel();
        panel3.setVisible(true);
        add(panel3, SOUTH);
        
        
        panel2.setLayout(new GridLayout(4,4,10,10));
        panel3.setLayout(new GridLayout(1,1,10,10));
//      
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
        buttonEq = new JButton("=");
        button0 = new JButton("0");
        buttonCE = new JButton("CE");
        buttonPoint = new JButton(".");
        buttonPlus = new JButton("+");
        buttonMinus = new JButton("-");
        buttonMult = new JButton("*");
        buttonDev = new JButton("/");
        buttonEq.setPreferredSize(new Dimension(WIDTH, 50));
        
        label = new JLabel("");
        label.setFont(new Font ("TimesRoman", Font.BOLD, 30));
        //label.setBackground(Color.yellow);
        label.setPreferredSize(new Dimension(width-70, 50));
        label.setHorizontalAlignment(JLabel.RIGHT);
        panel1.add(label);
        
        panel2.add(button7);
        panel2.add(button8);
        panel2.add(button9);
        panel2.add(buttonPlus);
        panel2.add(button4);
        panel2.add(button5);
        panel2.add(button6);
        panel2.add(buttonMinus);
        panel2.add(button1);
        panel2.add(button2);
        panel2.add(button3);
        panel2.add(buttonMult);
        panel2.add(buttonCE);
        panel2.add(button0);
        panel2.add(buttonPoint);
        panel2.add(buttonDev);
        
        panel3.add(buttonEq);
        
        double[] buffer = new double[3];
        buffer[2] = 0;
        String[] sign = new String[1];
        sign[0] = "+";   
        
        MouseListener buttonMouseListener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) { 
                if (buffer[2] == 0) {
                    label.setText("");
                    buffer[2] = 1;
                }
                if (buffer[2] == 2) {
                    label.setText("");
                    buffer[0] = 0;
                    buffer[1] = 0;
                    sign[0] = "+";
                    buffer[2] = 1;
                }
                JButton button = (JButton) me.getComponent();
                label.setText(label.getText() + button.getText());
                buffer[1] = Double.parseDouble(label.getText());
                
            }
           
        };
         MouseListener buttonCEMouseListener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {                
                label.setText("");
                buffer[0] = 0;
                buffer[1] = 0;
                sign[0] = "+";
            }
           
        };
        
        MouseListener buttonSignMouseListener = new MouseAdapter() {
            @Override
            
            public void mouseClicked(MouseEvent me) {
                JButton button = (JButton) me.getComponent();
                switch (sign[0]) {                  
                    case ("+"):
                        buffer[0] = buffer[0] + buffer [1];
                        break;
                    case ("-"):
                        buffer[0] = buffer[0]-buffer [1];
                        break;    
                    case ("*"):
                        buffer[0] = buffer[0]*buffer [1];
                        break;
                    case ("/"):
                        buffer[0] = buffer[0]/buffer [1];
                        break;
                    
                } 
                
                buffer[2] = 0;
                buffer[1] = 0;
                
                sign[0] = button.getText();
                if (sign[0] == "=") {
                    buffer[2] = 2;
                }
                label.setText(Double.toString(buffer[0]));
                
            }
        };
        
        button1.addMouseListener(buttonMouseListener);
        button2.addMouseListener(buttonMouseListener);
        button3.addMouseListener(buttonMouseListener);
        button4.addMouseListener(buttonMouseListener);
        button5.addMouseListener(buttonMouseListener);
        button6.addMouseListener(buttonMouseListener);
        button7.addMouseListener(buttonMouseListener);
        button8.addMouseListener(buttonMouseListener);
        button9.addMouseListener(buttonMouseListener);
        button0.addMouseListener(buttonMouseListener);
        buttonPoint.addMouseListener(buttonMouseListener);
        buttonCE.addMouseListener(buttonCEMouseListener);
        buttonPlus.addMouseListener(buttonSignMouseListener);
        buttonMinus.addMouseListener(buttonSignMouseListener);
        buttonMult.addMouseListener(buttonSignMouseListener);
        buttonDev.addMouseListener(buttonSignMouseListener);
        buttonEq.addMouseListener(buttonSignMouseListener);
        
    }
     
}