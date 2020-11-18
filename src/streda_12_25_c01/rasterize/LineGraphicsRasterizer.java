package streda_12_25_c01.rasterize;

import java.awt.*;

public class LineGraphicsRasterizer extends LineRasterizer {

    public LineGraphicsRasterizer(Raster raster) {
        super(raster);
    }

    @Override
    public void rasterize(int x1, int y1, int x2, int y2, Color color) {
        RasterBufferedImage rasterBufferedImage = (RasterBufferedImage) raster;
        Graphics g = rasterBufferedImage.getGraphics();
        g.setColor(color);
        g.drawLine(x1, y1, x2, y2);
    }

}
