package org.romanbielyi.geometry;

import org.romanbielyi.geometry.abstracts.Shape;
import org.romanbielyi.geometry.exceptions.abstracts.VertexCountException;
import org.romanbielyi.geometry.shapes.*;

import java.util.ArrayList;
import java.util.List;

public class Geometry {
    public static void main(String[] args) throws VertexCountException {

        List<Shape> shapes = new ArrayList<>();
        // Plane shapes
        Shape triangle = new Triangle();
        triangle.addVertex(2.3, 5.5, 8.8, 5.5, 1.5, 6.6);
        Shape circle = new Circle(22.5);
        circle.addVertex(4.8, 2.2);
        Shape rectangle = new Rectangle(5.3, 10.4);
        rectangle.addVertex(10, 6);
        // Space shapes
        Shape sphere = new Sphere(4);
        sphere.addVertex(12, 9, 5);
        Shape squarePyramid = new SquarePyramid(8, 14);
        squarePyramid.addVertex(12.5, 3, 6.3);
        Shape cuboid = new Cuboid(12, 18, 3.7);
        cuboid.addVertex(8.3, 9.2, 7);

        shapes.add(triangle);
        shapes.add(circle);
        shapes.add(rectangle);
        shapes.add(sphere);
        shapes.add(squarePyramid);
        shapes.add(cuboid);

        for (Shape shape : shapes) {
            System.out.println(shape);
        }


    }
}
