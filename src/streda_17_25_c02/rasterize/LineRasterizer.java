package streda_17_25_c02.rasterize;

import streda_17_25_c02.model.Line;

import java.awt.*;

public abstract class LineRasterizer {

    Raster raster;
    Color color;

    public LineRasterizer(Raster raster) {
        this.raster = raster;
    }

    public final void setColor(Color color) {
        this.color = color;
    }

    public final void setColor(int color) {
        this.color = new Color(color);
    }

    public void rasterize(Line line) {
        int x1 = line.getX1();
        int y1 = line.getY1();
        int x2 = line.getX2();
        int y2 = line.getY2();
        Color color = new Color(line.getColor());
        rasterize(x1, y1, x2, y2, color);
    }

    public abstract void rasterize(int x1, int y1, int x2, int y2, Color color);

}
