package org.romanbielyi.geometry;

public class Vertex3D extends Vertex2D {
    protected double z;

    public Vertex3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    @Override
    public double[] getPoints() {
        return new double[]{x, y, z};
    }

    @Override
    public String toString() {
        return super.toString() + ", z = " + z;
    }
}
