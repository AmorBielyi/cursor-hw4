package org.romanbielyi.geometry.shapes;

import org.romanbielyi.geometry.Vertex3D;
import org.romanbielyi.geometry.abstracts.SpaceShape;
import org.romanbielyi.geometry.exceptions.SquarePyramidVertexCountException;
import org.romanbielyi.geometry.exceptions.abstracts.VertexCountException;

public class SquarePyramid extends SpaceShape {
    private double width;
    private double height;


    public SquarePyramid(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public SquarePyramid() {
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
        if (point.length == 3) {
            Vertex3D baseCenterVertex = new Vertex3D(point[0], point[1], point[2]);
            vertices.add(baseCenterVertex);
        } else {
            throw new SquarePyramidVertexCountException("Invalid vertex data. SquarePyramid must have 3 vertices");
        }
    }

    @Override
    public double getArea() {
        return width / 2 * Math.sqrt(height * height - width * width / 4);
    }

    @Override
    public double getVolume() {
        return (width * width * height) / 3;
    }

    @Override
    public String toString() {
        return String.format("SquarePyramid {%s}, width = %s, height = %s, volume = %s, area = %s ",
                vertices.get(0),
                width,
                height,
                Math.ceil(getVolume()),
                Math.ceil(getArea()));
    }
}
