package streda_12_25_c01.fill;

import streda_12_25_c01.model.Point;
import streda_12_25_c01.rasterize.Raster;

public class SeedFiller implements Filler {

    private final Raster raster;

    private int backgroundColor;
    private int fillColor;
    private int x, y;

    public SeedFiller(Raster raster) {
        this.raster = raster;
        fillColor = 0xffffff;
    }

    public void setSeed(Point seed) {
        backgroundColor = raster.getPixel(seed.x, seed.y);
        x = seed.x;
        y = seed.y;
    }

    public void setFillColor(int fillColor) {
        this.fillColor = fillColor;
    }

    @Override
    public void fill() {
        seedFill(x, y);
    }

    // VM options -Xss50m
    private void seedFill(int x, int y) {
        // ošetřit velikost plátna
        if (raster.getPixel(x, y) == backgroundColor) {
            raster.setPixel(x, y, fillColor);
            seedFill(x + 1, y); // doprava
            seedFill(x - 1, y); // doleva
            seedFill(x, y + 1); // dolů
            seedFill(x, y - 1); // nahoru
        }
    }

}
