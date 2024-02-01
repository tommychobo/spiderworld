package com.wutevr;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
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

        LinkedList<WorkspaceShape> shapes = new LinkedList<WorkspaceShape>();
        shapes.add(new WorkspaceShape());
        shapes.add(w1);
        Workspace ws = new Workspace(height/2, width/2, shapes);

        JFrame jf = new JFrame();
        jf.setSize(width, height);
        jf.add(ws);

//        LinkedList<WorkspaceShape> l2 = new LinkedList<WorkspaceShape>();
//        l2.add(new WorkspaceShape());
//        ws.addShapes(l2);

        jf.setVisible(true);



    }
}
