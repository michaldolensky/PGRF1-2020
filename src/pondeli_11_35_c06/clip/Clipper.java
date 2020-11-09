package pondeli_11_35_c06.clip;

import pondeli_11_35_c06.model.Point;
import pondeli_11_35_c06.model.Polygon;

import java.util.ArrayList;
import java.util.List;

public class Clipper {

//    public Clipper() {
//      // konstruktor může přijmout parametry
//    }

//    public Polygon clip(Polygon polygon, Polygon clipPolygon) {
//        return new Polygon(clip(polygon.getPoints(), clipPolygon.getPoints()), polygon.getColor());
//    }

    /**
     * Funkce pro ořezání
     *
     * @param polygon     polygon, který tvoří ořezávaný obrazec, nemusí být konvexní
     * @param clipPolygon polygon, který tvoří ořezávací obrazec, MUSÍ být kovexní
     * @return seznam vrcholů polygonu který je výsledkem ořezání
     */
    public List<Point> clip(List<Point> polygon, List<Point> clipPolygon) {

        List<Point> in = new ArrayList<>(polygon);

        Point p1 = null; // TODO přiřadit poslední clip point
        for (Point p2 : clipPolygon) {
            List<Point> out = new ArrayList<>();
            // vytvořit hranu z vrcholů p1 a p2

//            Point v1 = in.last // TODO
            for (Point v2 : in) {
                // TODO algoritmus
            }
            p1 = p2;
            in = out;
        }
        return in;
    }

}
