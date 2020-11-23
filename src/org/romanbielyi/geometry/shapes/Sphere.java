package org.romanbielyi.geometry.shapes;

import org.romanbielyi.geometry.Vertex3D;
import org.romanbielyi.geometry.abstracts.SpaceShape;
import org.romanbielyi.geometry.exceptions.SphereVertexCountException;
import org.romanbielyi.geometry.exceptions.abstracts.VertexCountException;

public class Sphere extends SpaceShape {
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    public Sphere() {
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public void addVertex(double... point) throws VertexCountException {
        if (point.length == 3) {
            vertices.add(new Vertex3D(point[0], point[1], point[2]));
        } else {
            throw new SphereVertexCountException("Invalid vertex data. Sphere must have 3 vertices");
        }
    }

    @Override
    public double getArea() {
        return 4 * Math.PI * radius * radius;
    }

    @Override
    public double getVolume() {
        return 4 * Math.PI * Math.pow(radius, 3) / 3;
    }

    @Override
    public String toString() {
        return String.format("Sphere {%s}, volume = %s ",
                vertices.get(0),
                Math.ceil(getVolume()) + ", area = " + Math.ceil(getArea()));
    }
}
