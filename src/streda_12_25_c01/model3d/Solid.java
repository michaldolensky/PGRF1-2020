package streda_12_25_c01.model3d;

import transforms.Point3D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Solid {

    List<Point3D> vertexBuffer = new ArrayList<>(); // vb
    List<Integer> indexBuffer = new ArrayList<>(); // ib
    int color;

    final void addIndices(Integer... indices) {
        indexBuffer.addAll(Arrays.asList(indices));
    }

    // getter

}
