package streda_17_25_c02.model;

import streda_17_25_c02.rasterize.LineRasterizer;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Polygon {

    private List<Point> points;
    private int color;

    public Polygon() {
//        points = new ArrayList<>();
//        color = Color.CYAN.getRGB();
        this(new ArrayList<>(), Color.CYAN.getRGB());
    }

    // další konstruktory - aspoň jeden

    public Polygon(List<Point> points, int color) {
        this.points = points;
        this.color = color;
    }

//    public Polygon(Point... points) { // java varargs
//        this(Arrays.asList(points.clone()), Color.CYAN.getRGB());
//    }

    public void rasterize(LineRasterizer lineRasterizer) {
        // kontrola zda je bodů dost
        for (int i = 0; i < points.size(); i++) {
//            lineRasterizer.rasterize();
        }
    }

    // metoda pro přidání vrcholu do seznamu vrcholů
//    points.add()

}
