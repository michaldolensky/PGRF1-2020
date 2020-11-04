package streda_17_25_c02.fill;

import streda_17_25_c02.model.Edge;
import streda_17_25_c02.model.Point;
import streda_17_25_c02.rasterize.LineRasterizer;

import java.util.ArrayList;
import java.util.List;

public class ScanLineFiller implements Filler {

    private final LineRasterizer lineRasterizer;
    private final List<Point> points;

    private final int fillColor;
    private final int borderColor;

//    private final Polygon polygon;

    public ScanLineFiller(LineRasterizer lineRasterizer, List<Point> points, int fillColor, int borderColor) {
        this.lineRasterizer = lineRasterizer;
        this.points = points;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public void fill() {
        List<Edge> edges = new ArrayList<>();
        // projet všechny vrcholy (list points) a vytvořit z nich hrany (podobně jako polygon)
        // 0. a 1. vrchol vytvoří první hranu; 1. a 2. vrchol vytoří druhou hranu; ...; poslední a 0. vytvoří hranu
        // ignorovat vodorovné hrany
        // vyvtořené nevodorovné hrany zorientovat a přidat so seznamu

        // výslekek bude seznam edges, ve které budou nevodorovné a orientované hrany


//        List<Integer> .. průsečík
    }

}
