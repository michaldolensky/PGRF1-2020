package pondeli_11_35_c06.fill;

import pondeli_11_35_c06.model.Point;
import pondeli_11_35_c06.rasterize.Raster;

public class SeedFiller implements Filler {

    private final Raster raster;

    private int backgroundColor;
    private Point seed;
    private int fillColor;

    public SeedFiller(Raster raster) {
        this.raster = raster;
        fillColor = 0xffffff;
    }

    public void setSeed(Point seed) {
        this.seed = seed;
        backgroundColor = raster.getPixel(seed.x, seed.y);
//        return this;
    }

    public void setFillColor(int fillColor) {
        this.fillColor = fillColor;
//        return this;
    }

    @Override
    public void fill() {
        seedFill(seed.x, seed.y);
    }

    private void seedFill(int x, int y) {
        // ošetřit velikost plátna
        if (raster.getPixel(x, y) == backgroundColor) {
            raster.setPixel(x, y, fillColor);
            seedFill(x + 1, y); // doprava
            seedFill(x - 1, y); // doleva
            seedFill(x, y + 1); // dolu
            seedFill(x, y - 1); // nahoru
        }
    }

}
