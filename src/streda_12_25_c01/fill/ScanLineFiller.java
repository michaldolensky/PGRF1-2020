package streda_12_25_c01.fill;

import streda_12_25_c01.model.Edge;
import streda_12_25_c01.model.Point;
import streda_12_25_c01.rasterize.LineRasterizer;

import java.util.ArrayList;
import java.util.List;

public class ScanLineFiller implements Filler {

    private final LineRasterizer lineRasterizer;

    private final int fillColor;
    private final int borderColor;

//    private final List<Line> lines;
//    private final Polygon polygon;
    private final List<Point> points;

    public ScanLineFiller(LineRasterizer lineRasterizer, int fillColor, int borderColor, List<Point> points) {
        this.lineRasterizer = lineRasterizer;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
        this.points = points;
    }

    @Override
    public void fill() {
        List<Edge> edges = new ArrayList<>();
        // projet všechny vrcholy (list points) a vytvořit z nich hrany (nepravidelný-úhelník)
        // 0. a 1. vrchol budou první hrana; 1. a 2. budou druhá hrana; ...; poslední a 0. vrchol
        // rovnou ignorovat vodorovné úsečky
        // vytvořené nevodorovné hrany se zorientují a přidají se do seznamu

        // výsledkem je seznam zorientovaných hran bez vodorovných úseků
    }
}
