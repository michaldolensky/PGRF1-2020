package streda_12_25_c01.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Polygon {

    private List<Point> points;
    private int color;

    // konstruktor
    public Polygon() {
        points = new ArrayList<>();
        color = Color.YELLOW.getRGB();
    }

    // kontruktor, který přijme body, ale bude mít výchozí barvu

    public Polygon(List<Point> points, int color) {
        this.points = points;
        this.color = color;
    }

    // polygon by se měl umět vykreslit
    // rasterize(LineRasterizer)
    public void rasterize() {
        // kontrola velikosti seznamu bodů
        for (int i = 0; i < points.size(); i++) {
            // rasterizer.rasterize(x1, y1, x2, y2, color)
        }

    }

    // metoda pro přidání bodu do seznamu bodů
    // points.add(point)

}
