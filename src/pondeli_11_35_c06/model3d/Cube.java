package pondeli_11_35_c06.model3d;

import transforms.Point3D;

import java.awt.*;

public class Cube extends Solid {

    public Cube() {
        color = Color.CYAN.getRGB();

        vertexBuffer.add(new Point3D(1, -1, 1));
        vertexBuffer.add(new Point3D(1, 1, 1));
        vertexBuffer.add(new Point3D(-1, 1, 1));
        vertexBuffer.add(new Point3D(-1, -1, 1));

        vertexBuffer.add(new Point3D(1, -1, -1));
        vertexBuffer.add(new Point3D(1, 1, -1));
        vertexBuffer.add(new Point3D(-1, 1, -1));
        vertexBuffer.add(new Point3D(-1, -1, -1));

        addIndices(0, 1, 1, 2, 2, 3, 3, 0);
        addIndices(4, 5, 5, 6, 6, 7, 7, 4);
        addIndices(0, 4, 1, 5, 2, 6, 3, 7);
    }

}
