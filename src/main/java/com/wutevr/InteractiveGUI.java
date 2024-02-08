package com.wutevr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * InteractiveGUI class for creating a GUI with buttons and sliders positioned at specific coordinates.
 */
public class InteractiveGUI extends JPanel{

    //private JFrame frame;
    private JButton button;
    private JSlider slider;


    public InteractiveGUI(Rectangle guiRect){
        this.setBounds(guiRect);
    }

    /**
     * Creates a button at a specified position.
     *
     * @param position The position (x, y coordinates) where the button will be placed.
     * @param string   The string (text) that the button will display
     */
    public void createButton(int x, int y, int width, int height, String string) {
        button = new JButton(string);
        //button.setBounds(x, y, width, height);
        
        //button.setSize(width, height);
        // Add mouse listener for hover effect
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setBackground(Color.RED); // Change color on hover
            }

            public void mouseExited(MouseEvent e) {
                button.setBackground(UIManager.getColor("Button.background")); // Revert color on exit
            }
        });

        // Add action listener for click event
        button.addActionListener(e -> JOptionPane.showMessageDialog(this, "Button Clicked!"));

        this.add(button); // Add button to the frame
        button.setPreferredSize(new Dimension(width, height));
    }

    /**
     * Creates a slider at a specified position.
     *
     * @param position The position (x, y coordinates) where the slider will be placed.
     */
    public void createSlider(Point position) {
        slider = new JSlider();
        slider.setBounds(position.x, position.y, slider.getPreferredSize().width, slider.getPreferredSize().height);
        // Additional slider functionality can be added here

        this.add(slider); // Add slider to the frame
    }


    public void display() {
        this.setVisible(true);
    }

    // Main method removed for integration purposes
}
