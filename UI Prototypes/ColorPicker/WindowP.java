package ColorPicker;

import java.awt.GridLayout;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class WindowP extends JFrame implements ChangeListener{
    public static WindowP okno = null;
    public static JLabel label = null;
    private static ColorBox colorBox = null;
    private static RightPanel rightPanel = null;

    private static int colorRed = 125;
    private static int colorGreen = 125;
    private static int colorBlue = 125;
    private String hexCode = "#7d7d7d";
    
    private static Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard(); // буфер обмена

    private WindowP(){
        okno = this;
        this.setTitle("Color Picker");
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

          setLayout(new GridLayout(1, 2));//одна строчка, два столбца
          colorBox = new ColorBox();
          rightPanel = new RightPanel();

          colorBox.setToolTipText(hexCode);

          add(colorBox);
          add(rightPanel);
          getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));//размер отступа от края окна

        setVisible(true);
    }
    public static WindowP getInstance(){
        return new WindowP();
    }

    @Override
    public void stateChanged(ChangeEvent ce) {
        JSlider slider = (JSlider) ce.getSource();
        String sliderName = slider.getName();
        switch (sliderName) {
            case "Red":
                colorRed = slider.getValue();
                break;
            case "Green":
                colorGreen = slider.getValue();
                break;
            case "Blue":
                colorBlue = slider.getValue();
                break;
        }
        Color color = new Color(colorRed, colorGreen, colorBlue);
        colorBox.setBackground(color); // задаем полученный цвет как фон colorBox
        hexCode = getHexColor(colorBox.getBackground()); // получаем шестнадцатеричный код цвета
        colorBox.setToolTipText(hexCode); // обновляем всплывающую подсказку
        copyToClipboard(hexCode); // копируем шестнадцатеричный код цвета в буфер обмена
    }
        
    public static String getHexColor(Color color) {
        String hexColor = "#" + Integer.toHexString(colorRed)
                + Integer.toHexString(colorGreen) + Integer.toHexString(colorBlue);
        return hexColor.toUpperCase();
    }

    private void copyToClipboard(String text) {
        StringSelection selection = new StringSelection(text);
        clipboard.setContents(selection, selection);
    }
}
