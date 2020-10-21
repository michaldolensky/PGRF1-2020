package streda_17_25_c02.fill;

import streda_17_25_c02.model.Point;
import streda_17_25_c02.rasterize.Raster;

public class SeedFiller implements Filler {

    private final Raster raster;

    private int fillColor;
    private int backgroundColor;
    private int x, y;

    public SeedFiller(Raster raster) {
        this.raster = raster;
        this.fillColor = 0xffff00;
    }

    public void setSeed(Point seed) {
        x = seed.x;
        y = seed.y;
        backgroundColor = raster.getPixel(x, y);
    }

    public void setFillColor(int fillColor) {
        this.fillColor = fillColor;
    }

    @Override
    public void fill() {
        fillSeed(x, y);
    }

    private void fillSeed(int xx, int yy) {
        if (raster.getPixel(xx, yy) == backgroundColor) {
            raster.setPixel(xx, yy, fillColor);
            fillSeed(xx, yy + 1); // dolů
            fillSeed(xx, yy - 1); // nahoru
            fillSeed(xx + 1, yy); // doprava
            fillSeed(xx - 1, yy); // doleva
        }
    }

}
