package com.wutevr;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

/**
 * Produces a workspace as a JPanel that can be displayed inside of
 * JFrames.
 */
public class DummyWorkspace extends JPanel implements MouseListener {

    private List<WorkspaceShape> shapes;

    /**
     * Creates a windowed workspace
     * @param height
     * @param width
     * @param shapes
     */
    public DummyWorkspace(int height, int width, @NotNull List<WorkspaceShape> shapes) {
        this.setSize(width, height);
        this.setShapes(shapes);

        addMouseListener(this);
    }

    private List<WorkspaceShape> getShapes() {
        return shapes;
    }

    /**
     * Draws a single shape according to the specifications set forth in
     * the WorkspaceShape object
     * @param graphics
     * @param wshape
     */
    private void drawAShape(Graphics graphics, WorkspaceShape wshape) {
        Rectangle s = wshape.getRectangle();
        Graphics2D g2d = (Graphics2D) graphics;
        g2d.setPaint(wshape.getFillColor());
        g2d.setStroke(wshape.getStroke());
        Point p = wshape.getPosition();
        wshape.getRectangle().setLocation(
                p.x + this.getWidth()/2 - (int) s.getWidth()/2,
                p.y + this.getHeight()/2 - (int) s.getHeight()/2
        );
        g2d.fill(wshape.getRectangle());
        g2d.draw(wshape.getRectangle());
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.shapes.forEach(s -> this.drawAShape(g, s));
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
