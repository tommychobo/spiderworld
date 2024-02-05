package com.wutevr;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Display extends JFrame {
    private final int width;
    private final int height;
    private final int refreshRate;
    private SpiderGrid grid;
    private ShapePanel sp;
    private InteractiveGUI gui;
    private ArrayList<Polygon> polys;

    public Display(int width, int height, int refreshRate) {
        this.width = width;
        this.height = height;
        this.refreshRate = refreshRate;

        // Set up JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);
        setTitle("Spider World!!");
        polys = new ArrayList<>();
        int[] xPts = {0, 10, 0, 10};
        int[] yPts = {0, 0, 10, 10};
        polys.add(new Polygon(xPts, yPts, 4));
        grid = new SpiderGrid();
        sp = new ShapePanel(5*width/6, height/10, width/6, 9*height/10, polys);
        gui = new InteractiveGUI(this);
        gui.createButton(width/2, height/2, 50, 20, "WOAH");
        // Set up Timer for simulation of refresh rate
        Timer timer = new Timer(1000 / refreshRate, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Your drawing and game logic goes here
                repaint();
            }
        });
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // Your drawing logic goes here
        sp.paintComponent(g);
    }
}
