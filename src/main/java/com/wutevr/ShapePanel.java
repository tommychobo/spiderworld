package com.wutevr;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
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
    private Workspace wSpace;

    public ShapePanel(Rectangle spRect, Workspace wSpace) {
        this.x = spRect.x;
        this.y = spRect.y;
        this.width = spRect.width;
        this.height = spRect.height;
        this.wSpace = wSpace;
        this.setBounds(spRect);
        polygons = getDefaultPolys();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                for (Polygon polygon : polygons) {
                    if (polygon.contains(me.getPoint())) {
                        addShapeToWorkspace();
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

    public ArrayList<Polygon> getDefaultPolys(){
        ArrayList<Polygon> pol = new ArrayList<>();
        pol.add(
            offsetPolygonToPoint(
            new Polygon(new int[]{0, 50, 50, 0}, new int[]{0, 0, 50, 50}, 4),
            x+width/2-25, y+height/2-25)
        );
        return pol;
    }


    /**
     * configures a default shape to add to the workspace. Assigns the shape a random color. Right now, 
     * All shapes are rectangles. These shapes will eventually turn into code blocks.
     */
    public void addShapeToWorkspace(){
        LinkedList<WorkspaceShape> wssToAdd = new LinkedList<>();
        Color color = new Color((int)(128*Math.random()+127), (int)(128*Math.random()+127), (int)(128*Math.random()+127));
        WorkspaceShape wss = new WorkspaceShape(50, 50, color, new BasicStroke(), new Point(0, 0));
        wssToAdd.add(wss);
        wSpace.addShapes(wssToAdd);
    }
}
