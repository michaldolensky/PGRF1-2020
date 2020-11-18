package streda_17_25_c02.model3d;

import transforms.Point3D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Solid {

    final List<Point3D> vertexBuffer = new ArrayList<>();
    final List<Integer> indexBuffer = new ArrayList<>();
    int color = 0xffffff;

    final void addIndices(Integer... indices) {
        indexBuffer.addAll(Arrays.asList(indices));
    }

}
