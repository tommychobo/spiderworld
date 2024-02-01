package com.wutevr;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

/**
 * Produces a workspace as a JPanel that can be displayed inside
 * JFrames.
 */
public class Workspace extends JPanel implements MouseListener {

    private List<WorkspaceShape> shapes;

    private Point coordTransform;

    /**
     * Creates a windowed workspace
     * @param height
     * @param width
     * @param shapes
     */
    public Workspace(int height, int width, @NotNull List<WorkspaceShape> shapes) {
        this.setSize(width, height);
        this.setShapes(shapes);

        this.coordTransform = new Point(width/2, height/2);
    }

    private List<WorkspaceShape> getShapes() {
        return shapes;
    }

    /**
     * Draws the shape in the provided graphics environment
     * according to specifications
     * @param ws The WorkspaceShape to display
     * @param g The graphics context to display it in
     */
    private void draw(WorkspaceShape ws, Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Rectangle r = ws.getRectangle();
        g2d.setPaint(ws.getFillColor());
        g2d.setStroke(ws.getStroke());
        Point p = ws.getPosition();
        r.setLocation(
                p.x + this.getWidth()/2 - ws.getWidth()/2,
                p.y + this.getHeight()/2 - ws.getHeight()/2
        );
        g2d.fill(r);
        g2d.draw(r);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.shapes.forEach(s -> this.draw(s, g));
    }

    private void setShapes(List<WorkspaceShape> shapes) {
        this.shapes = shapes;
    }

    /**
     * Adds all of the given WorkspaceShapes to the workspace
     * (and repaints)
     * @param shapes
     */
    public void addShapes(List<WorkspaceShape> shapes) {
        List<WorkspaceShape> slist = this.getShapes();
        slist.addAll(shapes);
        this.repaint();
    }



//    /**
//     * For a provided shape, determines if the point is
//     */
//    public void isPointInside(Point p) {
//        return p.x <=
//    }

    /**
     * Clears all shapes from the workspace (and repaints)
     */
    public void clearShapes() {
        this.getShapes().clear();
        this.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
