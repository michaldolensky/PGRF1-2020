package streda_17_25_c02.model3d;

import transforms.Point3D;

import java.awt.*;

// třída Cube byla na cvičení, v projektu 2 jiná tělesa
public class Cube extends Solid {

    public Cube() {
        color = Color.MAGENTA.getRGB();

        vertexBuffer.add(new Point3D(1, 1, 1)); // 0
        vertexBuffer.add(new Point3D(-1, 1, 1)); // 1
        vertexBuffer.add(new Point3D(-1, -1, 1)); // 2
        vertexBuffer.add(new Point3D(1, -1, 1)); // 3

        vertexBuffer.add(new Point3D(1, 1, -1)); // 4
        vertexBuffer.add(new Point3D(-1, 1, -1)); // 5
        vertexBuffer.add(new Point3D(-1, -1, -1)); // 6
        vertexBuffer.add(new Point3D(1, -1, -1)); // 7

        addIndices(0, 1, 1, 2, 2, 3, 3, 0);
        addIndices(4, 5, 5, 6, 6, 7, 7, 4);
        addIndices(0, 4, 1, 5, 2, 6, 3, 7);
    }

}
