package streda_17_25_c02.fill;

import streda_17_25_c02.model.Edge;
import streda_17_25_c02.model.Point;
import streda_17_25_c02.rasterize.LineRasterizer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        // vytvořené nevodorovné hrany zorientovat a přidat do seznamu

        // výslekek bude seznam (list edges), ve které budou nevodorovné a orientované hrany

        // najít minimum a maximum pro Y
        int minY = points.get(0).y;
        int maxY = minY;
        // for cyklus

        // pro všechny Y od min do max včetně
        for (int y = minY; y <= maxY; y++) {
            List<Integer> intersections = new ArrayList<>();

            // vnořený cyklus
            // projít všechny hrany (list edges)
            // pokud hrana má průsečík na daném Y ..
            // .. tak vypočítat X hodnotu průsečíku a vložit ji do seznamu

            // nyní naplněný seznam průsečíků

            // setřídit průsečíky
            Collections.sort(intersections);
//            intersections = intersections.stream().sorted().collect(Collectors.toList());
//            intersections.sort(new Comparator<Integer>() {
//                @Override
//                public int compare(Integer o1, Integer o2) {
//                    return Integer.compare(o1, o2);
//                }
//            });
//            intersections.sort((o1, o2) -> Integer.compare(o1, o2));
//            intersections.sort(Integer::compare);
            // nebo volitelně implementovat na seřazení (pouze rámci PGRF)
            // v praxi používat hotová řešení!

            // průsečíků je vždy sudý počet
            // vybarvení mezi průsečíky
            // spojení průsečíků vždy se sudým a lichým indexem
            // 0. a 1.; 2. a 3.;...
        }

        // obtáhnutí hranice
        // polygon.rasterize nebo polygonRasterizer.rasterize
    }

}
