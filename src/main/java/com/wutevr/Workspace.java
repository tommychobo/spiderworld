package com.wutevr;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Produces a workspace as a JPanel that can be displayed inside
 * JFrames.
 */
public class Workspace extends JPanel {

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


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.shapes.forEach(s -> s.draw(g, this.coordTransform));
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

}
