package pondeli_11_35_c06.rasterize;

import pondeli_11_35_c06.model.Line;

import java.awt.*;

public class TrivialLineRasterizer extends LineRasterizer {

    public TrivialLineRasterizer(Raster raster) {
        super(raster);
    }

    @Override
    public void rasterize(Line line) {
        rasterize(
                line.getX1(), line.getY1(),
                line.getX2(), line.getY2(),
                new Color(line.getColor())
        );
    }

    @Override
    public void rasterize(int x1, int y1, int x2, int y2, Color color) {
        float k = (y2 - y1) / (float) (x2 - x1);
        float q = y1 - k * x1;
        System.out.println(k);

        for (int x = x1; x <= x2; x++) {
            float y = k * x + q;
            raster.setPixel(x, Math.round(y), color.getRGB());
        }
    }

}
