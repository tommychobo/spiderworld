package com.wutevr;

import java.awt.*;

public class WorkspaceShape {

    private Rectangle shape;

    private Color fillColor;
    private Stroke stroke;

    private Point position;

    public WorkspaceShape(Rectangle rect, Color fillColor, Stroke stroke, Point position) {
        this.setRectangle(rect);
        this.setFillColor(fillColor);
        this.setStroke(stroke);
        this.setPosition(position);
    }

    /**
     * Produces a default rectangle for ease of testing
     */
    public WorkspaceShape() {
        this(new Rectangle(500, 500),
            new Color(242, 151, 39, 100),
            new BasicStroke(10f,
                    BasicStroke.CAP_ROUND,
                    BasicStroke.JOIN_ROUND),
            new Point(0, 0)
        );

    }

    public Rectangle getRectangle() {
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
        this.position = position;
    }
}
