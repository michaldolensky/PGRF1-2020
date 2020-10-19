package pondeli_11_35_c06.model;

import pondeli_11_35_c06.rasterize.LineRasterizer;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Polygon {

    private final List<Point> points;
    private int color;

    public Polygon() {
//        this.points = new ArrayList<>();
//        this.color = Color.GREEN.getRGB();
        this(new ArrayList<>());
    }

    public Polygon(List<Point> points) {
        this(points, Color.GREEN.getRGB());
    }

    // konstruktor jen s barvou

    public Polygon(List<Point> points, int color) {
        this.points = points;
        this.color = color;
    }

    // metody, které umí body do seznamu přidat nebo odebrat

    public void addPoint(Point point) {
        addPoints(point);
    }

    public void addPoints(Point... pointsToAdd) { // java varargs
        points.addAll(Arrays.asList(pointsToAdd.clone()));
    }

//    rasterize(LineRasterizer rasterizer)
    public void rasterize() {
        for (int i = 0; i < points.size(); i++) {
            // spojení bodů
//            rasterizer.rasterize(x1, y1, x2, y2, color);
        }
    }

    // getter
    // setter
}
