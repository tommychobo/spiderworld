package com.wutevr;

import org.jetbrains.annotations.NotNull;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Produces a workspace as a JPanel that can be displayed inside
 * JFrames.
 */
public class Workspace extends JPanel implements MouseListener, MouseMotionListener {

    private LinkedList<WorkspaceShape> shapes;

    private Point coordTransform() {
        return new Point(this.getWidth()/2, this.getHeight()/2);
    }

    private WorkspaceShape activeShape;

    /**
     * Creates a windowed workspace
     * @param height
     * @param width
     * @param shapes
     */
    public Workspace(int height, int width, @NotNull LinkedList<WorkspaceShape> shapes) {
        this.setSize(width, height);
        this.setShapes(shapes);
        this.activeShape = null;

        addMouseListener(this);
        addMouseMotionListener(this);
    }

    private LinkedList<WorkspaceShape> getShapes() {
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

    private void setShapes(LinkedList<WorkspaceShape> shapes) {
        this.shapes = shapes;
    }

    /**
     * Adds all of the given WorkspaceShapes to the workspace
     * (and repaints)
     * @param shapes
     */
    public void addShapes(LinkedList<WorkspaceShape> shapes) {
        LinkedList<WorkspaceShape> slist = this.getShapes();
        shapes.forEach(slist::addFirst);
        this.repaint();
    }

    /**
     * Given a shape, determines if the provided is inside of that shape.
     */
    public boolean isPointInside(WorkspaceShape s, Point p) {
        Point spos = s.getPosition();
        return p.x >= this.getWidth()/2 + spos.x - s.getWidth()/2
                && p.x <= this.getWidth()/2 + spos.x + s.getWidth()/2
                && p.y >= this.getHeight()/2 + spos.y - s.getHeight()/2
                && p.y <= this.getHeight()/2 + spos.y + s.getHeight()/2;
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
        return;
    }

    @Override
    public void mousePressed(MouseEvent e) {

        LinkedList<WorkspaceShape> pressedShapes = this.shapes.stream()
                .filter((s) -> isPointInside(s, e.getPoint()))
                .collect(Collectors.toCollection(LinkedList::new));

        if(!pressedShapes.isEmpty()) {
            activeShape = pressedShapes.getLast();
        }

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(activeShape != null) {
            setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));

            Point trans = this.coordTransform();
            int transX = (int) trans.getX();
            int transY = (int) trans.getY();
            int x = e.getX() - transX - activeShape.getWidth()/4;
            int y = e.getY() - transY - activeShape.getHeight()/4;
            activeShape.setPosition(x, y);
            this.repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        activeShape = null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        return;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        return;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Optional<WorkspaceShape> shapeMoved = this.shapes.stream()
                .filter((s) -> isPointInside(s, e.getPoint()))
                .findFirst();

        if(shapeMoved.isPresent())
            setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
        else
            setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
}
