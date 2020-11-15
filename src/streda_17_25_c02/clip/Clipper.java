package streda_17_25_c02.clip;

import streda_17_25_c02.model.Point;

import java.util.ArrayList;
import java.util.List;

public class Clipper {

//    public Polygon clip(Polygon polygon, Polygon clipPolygon) {
//        return new Polygon(
//                clip(polygon.getPoints(), clipPolygon.getPoints()),
//                polygon.getColor()
//        );
//    }

    /**
     * Funkce pro ořezání polygonu jiným polygonem
     *
     * @param polygon     seznam vrcholů ořezávaného polygonu, nemusí být konvexní
     *                    to je ten polygon, které je ořezávaný - ten editujeme
     * @param clipPolygon seznam vrcholů ořezávacího polygonu, MUSÍ být konvexní
     *                    to je ten polygon, který provádí ořezání
     * @return seznam vrcholů, které jsou výsledkem ořezání
     */
    public List<Point> clip(List<Point> polygon, List<Point> clipPolygon) {
        List<Point> in = new ArrayList<>(polygon);

        Point p1 = null; // TODO vložit poslední clip point
        for (Point p2 : clipPolygon) {
            List<Point> out = new ArrayList<>();
            // vytvořit hranu v vrcholů p1 a p2
            // Point v1 = in.last
            for (Point v2 : in) {
                // TODO algoritmus
            }
            p1 = p2;
            in = out;
        }

        return in;
    }

}
