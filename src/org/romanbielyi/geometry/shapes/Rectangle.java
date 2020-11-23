package org.romanbielyi.geometry.shapes;

import org.romanbielyi.geometry.Vertex2D;
import org.romanbielyi.geometry.abstracts.PlaneShape;
import org.romanbielyi.geometry.exceptions.RectangleVertexCountException;
import org.romanbielyi.geometry.exceptions.abstracts.VertexCountException;

public class Rectangle extends PlaneShape {

    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle() {
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public void addVertex(double... point) throws VertexCountException {
        if (point.length == 2) {
            vertices.add(new Vertex2D(point[0], point[1]));
        } else {
            throw new RectangleVertexCountException("Invalid vertex data. Rectangle shape must have 1 vertices");
        }
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return (width + height) * 2;
    }

    @Override
    public String toString() {
        return String.format("Rectangle {%s}, perimeter = %s ",
                vertices.get(0),
                Math.ceil(getPerimeter()) + ", area = " + Math.ceil(getArea()));
    }
}
