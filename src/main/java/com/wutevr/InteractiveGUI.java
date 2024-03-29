package com.wutevr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * InteractiveGUI class for creating a GUI with buttons and sliders positioned at specific coordinates.
 */
public class InteractiveGUI {

    private JFrame frame;
    private JButton button;
    private JSlider slider;

    /**
     * Constructor to initialize the frame.
     */
    public InteractiveGUI() {
        frame = new JFrame("Interactive GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(null); // Use null layout for absolute positioning of components
    }

    public InteractiveGUI(JFrame frame){
        this.frame = frame;
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
        button.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Button Clicked!"));

        frame.add(button); // Add button to the frame
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

        frame.add(slider); // Add slider to the frame
    }


    public void display() {
        frame.setVisible(true);
    }

    // Main method removed for integration purposes
}
