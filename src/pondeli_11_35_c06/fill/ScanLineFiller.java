package pondeli_11_35_c06.fill;

import pondeli_11_35_c06.model.Edge;
import pondeli_11_35_c06.model.Point;
import pondeli_11_35_c06.rasterize.LineRasterizer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ScanLineFiller implements Filler {

    private final LineRasterizer lineRasterizer;

    private final List<Point> points;
    private final int fillColor;
    private final int borderColor;

    // https://duckduckgo.com/?q=immutable+java+class

    public ScanLineFiller(LineRasterizer lineRasterizer, List<Point> points, int fillColor, int borderColor) {
        this.lineRasterizer = lineRasterizer;
        this.points = points;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public ScanLineFiller(LineRasterizer lineRasterizer, List<Point> points) {
        this(lineRasterizer, points, 0x00ffff, 0x0000ff);
    }

    @Override
    public void fill() {
        List<Edge> edges = new ArrayList<>();
        // projet všechny body (list points) a vytvořit z nich hrany (podobně jako Polygon)
        // 0. a 1. vrchol budou první hrana, 1. a 2. vrchol budou druhá hrana, ...; poslední a 0. vrchol
        // nepřidávat do listu edges vodorovné hrany
        // vytvořené nevodorovné hrany se zorientují a přidají se do seznamu edges

        // výsledkem bude seznam nevodorovných zorientovaných hran

        int minY = points.get(0).y;
        int maxY = minY;
        // projít všechny body (list points) a najít minimální a maximální Y

        for (int y = minY; y <= maxY; y++) {

            List<Integer> intersections = new ArrayList<>();
            // vnořený cyklus
            // projít všechny hrany (list edges)
            // pokud hrana má průsečík na daném Y...
            // .. tak vypočítat X hodnotu průsečíku a uložit ji do seznamu

            // setřídit průsečíky
            Collections.sort(intersections);
//            intersections.sort(new Comparator<Integer>() {
//                @Override
//                public int compare(Integer o1, Integer o2) {
//                    return Integer.compare(o1, o2);
//                }
//            });
//            intersections.sort((o1, o2) -> Integer.compare(o1, o2));
//            intersections.sort(Comparator.comparingInt(o -> o));
            intersections.sort(Integer::compare);
            // nebo volitelně implementovat vlastní algoritmus pro seřazení seznamu (pouze v rámci PGRF)
            // v praxi používat hotová řešení, tj. existující funkce sort

            // vybarvení mezi průsečíky
            // spojení průsečíků na sudém a lichém indexu
            // 0. a 1.; 2. a 3.; ...
        }

        // obtáhnutí hranice
    }

}
