package com.wutevr;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class Main
{
    public static void main( String[] args )
    {
        int height = 800;
        int width = 600;

        WorkspaceShape w1 = new WorkspaceShape(
                150, 200,
                Color.blue,
                new BasicStroke(),
                new Point(30, 40)
        );

        List<WorkspaceShape> shapes = new ArrayList<WorkspaceShape>();
        shapes.add(new WorkspaceShape());
        shapes.add(w1);
        DummyWorkspace ws = new DummyWorkspace(height/2, width/2, shapes);

        JFrame jf = new JFrame();
        jf.setSize(width, height);
        jf.add(ws);

        List<WorkspaceShape> l2 = new ArrayList<WorkspaceShape>();
        l2.add(new WorkspaceShape());
        ws.addShapes(l2);

        jf.setVisible(true);

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        ws.clearShapes();

    }
}
