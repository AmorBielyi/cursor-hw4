package org.romanbielyi.geometry;

public class Vertex2D {
    protected double x;
    protected double y;

    public Vertex2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public double[] getPoints() {
        return new double[]{x, y};
    }

    @Override
    public String toString() {
        return "x = " + x + ", y = " + y;
    }
}
