package org.romanbielyi.geometry.shapes;

import org.romanbielyi.geometry.Vertex2D;
import org.romanbielyi.geometry.abstracts.PlaneShape;
import org.romanbielyi.geometry.exceptions.TriangleVertexCountException;
import org.romanbielyi.geometry.exceptions.abstracts.VertexCountException;

public class Triangle extends PlaneShape {

    @Override
    public void addVertex(double... point) throws VertexCountException {
        if (point.length == 6) {
            this.vertices.add(new Vertex2D(point[0], point[1]));
            this.vertices.add(new Vertex2D(point[2], point[3]));
            this.vertices.add(new Vertex2D(point[4], point[5]));
        } else {
            throw new TriangleVertexCountException("Invalid vertex data, Triangle shape must have 3 vertices");
        }
    }

    @Override
    public double getArea() {
        Vertex2D v1 = vertices.get(0);
        Vertex2D v2 = vertices.get(1);
        Vertex2D v3 = vertices.get(2);

        double v1v2 = getDistance(v1, v2);
        double v1v3 = getDistance(v1, v3);
        double v2v3 = getDistance(v2, v3);
        double p = (v1v2 + v1v3 + v2v3) / 2.0;
        return Math.sqrt((p * v1v2) * (p - v1v3) * (p - v2v3));
    }

    @Override
    public double getPerimeter() {
        Vertex2D v1 = vertices.get(0);
        Vertex2D v2 = vertices.get(1);
        Vertex2D v3 = vertices.get(2);
        double v1v2 = getDistance(v1, v2);
        double v1v3 = getDistance(v1, v3);
        double v2v3 = getDistance(v2, v3);
        return v1v2 + v1v3 + v2v3;
    }

    @Override
    public String toString() {
        return String.format("Triangle {V1 %s; V2 %s; V3 %s}, perimeter = %s ",
                vertices.get(0),
                vertices.get(1),
                vertices.get(2),
                Math.ceil(getPerimeter()) + ", area = " + Math.ceil(getArea()));
    }

    private double getDistance(Vertex2D v1, Vertex2D v2) {
        return Math.sqrt(Math.pow((v2.getX() - v1.getX()), 2) + Math.pow((v2.getY() - v1.getY()), 2));
    }
}
