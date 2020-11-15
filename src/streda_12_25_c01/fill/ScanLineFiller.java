package streda_12_25_c01.fill;

import streda_12_25_c01.model.Edge;
import streda_12_25_c01.model.Point;
import streda_12_25_c01.rasterize.LineRasterizer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ScanLineFiller implements Filler {

    private final LineRasterizer lineRasterizer;
//    private final PolygonRasterizer polygonRasterizer;

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
//        polygonRasterizer = new PolygonRasterizer(lineRasterizer);
    }

    @Override
    public void fill() {
        List<Edge> edges = new ArrayList<>();
        // projet všechny vrcholy (list points) a vytvořit z nich hrany (nepravidelný-úhelník)
        // 0. a 1. vrchol budou první hrana; 1. a 2. budou druhá hrana; ...; poslední a 0. vrchol
        // rovnou ignorovat vodorovné úsečky
        // vytvořené nevodorovné hrany se zorientují a přidají se do seznamu

        // výsledkem je seznam zorientovaných hran bez vodorovných úseků

        // najít minimum a maximum pro Y
        int minY = points.get(0).y;
        int maxY = minY;
        // for cyklus

        // pro všechna Y od min do max včetně
        for (int y = minY; y <= maxY; y++) {
            List<Integer> intersection = new ArrayList<>();
            // vnořený cyklus
            // projít všechny hrany (list edges)
            // pokud hrana má průsečík na daném Y ..
            // .. tak vypočítat X hodnotu průsečíku a uložit ji do seznamu

            // nyní je naplněný seznam průsečíků

            // setřídit průsečíky
            Collections.sort(intersection);
//            intersection = intersection.stream().sorted().collect(Collectors.toList());
//            intersection.sort(new Comparator<Integer>() {
//                @Override
//                public int compare(Integer o1, Integer o2) {
//                    return Integer.compare(o1, o2);
//                }
//            });
//            intersection.sort((o1, o2) -> Integer.compare(o1, o2));
//            intersection.sort(Comparator.comparingInt(o -> o));
//            intersection.sort(Integer::compare);
            // nebo volitelně implementovat vlastní algoritmus na seřazení (pouze v rámci PGRF)
            // v praxi používat hotová řešení!

            // průsečíků je vždy sudý počet
            // vybarvení mezi průsečíky
            // spojení průsečíku vždy se sudým a lichým indexem
            // 0. a 1.; 2. a 3.; ...
        }

        // obtáhnutí hranice (polygonu)
        // polygon.rasterize nebo polygonRasterizer.rasterize
    }
}
