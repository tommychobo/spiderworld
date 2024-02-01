package com.wutevr;

import java.awt.*;

public class WorkspaceShape {

    private Rectangle shape;

    private Color fillColor;
    private Stroke stroke;

    private Point position;

    private int height;

    private int width;

    public WorkspaceShape(int width, int height, Color fillColor, Stroke stroke, Point position) {
        this.setHeight(height);
        this.setWidth(width);
        this.setRectangle(new Rectangle(width, height));
        this.setFillColor(fillColor);
        this.setStroke(stroke);
        this.setPosition(position);
    }

    /**
     * Produces a default rectangle for ease of testing
     */
    public WorkspaceShape() {
        this(200, 300,
            new Color(242, 151, 39, 100),
            new BasicStroke(10f,
                    BasicStroke.CAP_ROUND,
                    BasicStroke.JOIN_ROUND),
            new Point(0, 0)
        );
    }

    private Rectangle getRectangle() {
        return shape;
    }

    private void setRectangle(Rectangle shape) {
        this.shape = shape;
    }

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    public Stroke getStroke() {
        return stroke;
    }

    private void setStroke(Stroke stroke) {
        this.stroke = stroke;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        Rectangle r  = this.getRectangle();
        r.setLocation(position);
        this.position = position;
    }

    public void setPosition(int x, int y) {
        this.setPosition(new Point(x, y));
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Draws the shape in the provided graphics environment
     * according to specifications
     * @param g
     * @param transform
     */
    public void draw(Graphics g, Point transform) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(this.getFillColor());
        g2d.setStroke(this.getStroke());
        Point p = this.getPosition();
        this.setPosition(
                p.x + (int) transform.getX() - this.getWidth()/2,
                p.y + (int) transform.getY() - this.getHeight()/2
        );
        g2d.fill(this.getRectangle());
        g2d.draw(this.getRectangle());
    }
}
