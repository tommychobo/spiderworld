package com.wutevr;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class Main
{
    public static void main( String[] args )
    {
        int height = 800;
        int width = 600;

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

        Workspace ws = new Workspace(height/2, width/2, shapes);

        JFrame jf = new JFrame();
        jf.setSize(width, height);
        jf.add(ws);

        jf.setVisible(true);
    }
}
