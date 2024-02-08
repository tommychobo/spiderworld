package com.wutevr;
import javax.swing.*;
import javax.swing.border.Border;


import java.awt.*;
import java.util.LinkedList;

public class Display extends JFrame {
    private final int width;
    private final int height;
    private SpiderGrid grid;
    private ShapePanel sp;
    private InteractiveGUI gui;
    private Workspace ws;

    public Display(int width, int height) {
        this.width = width;
        this.height = height;
        
        // Set up JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);
        setTitle("Spider World!!");
        setUpDisplay();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }


    /**
     * This function is called by the constructor; it formats all of the JPanel objects
     * and resizes them to look pretty on the screen
     */
    public void setUpDisplay(){
        Rectangle shapePanelRect = new Rectangle(5*width/6, height/10, width/6, 9*height/10);
        Rectangle spiderGridRect = new Rectangle(width/20, height/10, width/3, width/3);
        Rectangle workspaceRect = new Rectangle(2*width/5, height/10, 13*width/30, 8*height/10);
        Rectangle guiRect = new Rectangle(0, 2*height/3, 2*width/5, height/3);
        grid = new SpiderGrid(spiderGridRect);
        ws = new Workspace(workspaceRect, new LinkedList<WorkspaceShape>());
        sp = new ShapePanel(shapePanelRect, ws);
        gui = new InteractiveGUI(guiRect);
        
        JLabel txt = new JLabel("In a world with tons of spiders and stuff, you can drag some shapes I guess and it's sort of fun maybe");
        this.add(txt);
        txt.setBounds(new Rectangle(20, -3*height/7, width, height));
        gui.createButton(width/2, height/2, 100, 20, "WOAH");
        gui.createButton(width/2, height/2, 200, 20, "LOOK AT THESE BUTTONS");
        gui.createSlider(new Point(width/3, 2*height/3));
        Border bord = BorderFactory.createLineBorder(Color.BLUE, 3);
        this.add(ws);
        ws.setBorder(bord);
        this.add(gui);
        gui.setBorder(bord);
        this.add(grid);
        this.add(sp);
        //sp.setBorder(bord);
    }



    private LinkedList<WorkspaceShape> defaultShapes(){
        LinkedList<WorkspaceShape> shapes = new LinkedList<WorkspaceShape>();

        shapes.add(new WorkspaceShape(
                50, 50,
                new Color(76, 70, 64, 60),
                new BasicStroke(),
                new Point(0, 0)
        ));

        shapes.add(new WorkspaceShape(
                50, 50,
                new Color(228, 138, 28, 60),
                new BasicStroke(),
                new Point(0, 0)
        ));

        shapes.add(new WorkspaceShape(
                50, 50,
                new Color(84, 113, 21, 60),
                new BasicStroke(),
                new Point(0, 0)
        ));

        shapes.add(new WorkspaceShape(
                50, 50,
                new Color(28, 172, 134, 60),
                new BasicStroke(),
                new Point(0, 0)
        ));
        return shapes;
    }
}
