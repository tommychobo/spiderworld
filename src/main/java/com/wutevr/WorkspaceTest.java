package com.wutevr;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class WorkspaceTest {

    /**
     * Produces a workspace window to test dragging and dropping
     */
    @Test
    public void dragTest() {

        int height = 800;
        int width = 600;

        JFrame frame = new JFrame("Drag and Drop Test");
        frame.setSize(new Dimension(width, height));

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

        Workspace ws = new Workspace(new Rectangle(0, 0, height/2, width/2), shapes);
        frame.add(ws);
        frame.setVisible(true);

        // Avoid stopping test until frame is closed
        while (frame.isVisible())
        {
            try {
                Thread.sleep(50);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
