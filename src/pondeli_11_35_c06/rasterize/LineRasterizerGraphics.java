package pondeli_11_35_c06.rasterize;

import java.awt.*;

public class LineRasterizerGraphics extends LineRasterizer {

    public LineRasterizerGraphics(Raster raster) {
        super(raster);
    }

    @Override
    public void rasterize(int x1, int y1, int x2, int y2, Color color) {
        RasterBufferedImage rasterBufferedImage = (RasterBufferedImage) raster;
        Graphics g = rasterBufferedImage.getGraphics();
        g.setColor(color); // new Color(int color)
        g.drawLine(x1, y1, x2, y2);
    }

}
