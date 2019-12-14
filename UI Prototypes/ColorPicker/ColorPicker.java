/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ColorPicker;

import javax.swing.*;

/**
 *
 * @author Anton
 */
public class ColorPicker extends JFrame {
    final int width = 600;
    final int height = 300;
    public ColorPicker() {
        setTitle("ColorPicker");
        setSize(width, height);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        setLocationByPlatform(true);
        
    }
    
}
