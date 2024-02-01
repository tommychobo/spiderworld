package com.wutevr;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import javax.swing.JComponent;
/* Spawn shape when clicking onpanel shape
 *  By Eric Berber 
 * 
 *  Will render panel at specfied args and provided 
 *  polygons
 * 
 *  Spawns clicked polygon at default spawn
 *  
 *  Currently does not render polgons with respect to panel
 *  Will need to pre-create polygons in specified location
 * 
 *  Usage: 
 *  frame.add(new ShapePanel(x, y,width, hieght, polygons))
 * 
 */
public class ShapePanel extends JComponent {

    public int x;
    public int y;
    public int width;
    public int height;
    public int DEFAULT_SPAWN_X = 500;
    public int DEFAULT_SPAWN_Y = 500;
    public final ArrayList<Polygon> polygons;
    public ShapePanel(int x, int y, int width, int height, final ArrayList<Polygon> polygons) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.polygons = polygons;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                for (Polygon polygon : polygons) {
                    if (polygon.contains(me.getPoint())) {
                        onShapeClick(polygon);
                    }
                }
            }
        });
    }

    private static Polygon offsetPolygonToPoint(Polygon polygon, int targetX, int targetY) {
        int offsetX = targetX - polygon.getBounds().x - polygon.getBounds().width / 2;
        int offsetY = targetY - polygon.getBounds().y - polygon.getBounds().height / 2;

        // Create a copy of the original polygon
        Polygon offsetPolygon = new Polygon(Arrays.copyOf(polygon.xpoints, polygon.npoints),
                Arrays.copyOf(polygon.ypoints, polygon.npoints), polygon.npoints);

        // Offset the points of the copy
        for (int i = 0; i < offsetPolygon.npoints; i++) {
            offsetPolygon.xpoints[i] += offsetX;
            offsetPolygon.ypoints[i] += offsetY;
        }

        return offsetPolygon;
    }

    public void onShapeClick(Polygon polygon) {
        Graphics g = getGraphics();
        Polygon newPolygon = offsetPolygonToPoint(polygon, DEFAULT_SPAWN_X, DEFAULT_SPAWN_Y);

        g.setColor(Color.gray);
        g.fillPolygon(newPolygon);
        g.drawPolygon(offsetPolygonToPoint(polygon, DEFAULT_SPAWN_X, DEFAULT_SPAWN_Y));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Draw Container
        g.drawRect(x, y, width, height);

        // Render each polygon  
        for (Polygon polygon : polygons) {
            g.setColor(Color.gray);
            g.fillPolygon(polygon);
            g.drawPolygon(polygon);
        }
    }
}
