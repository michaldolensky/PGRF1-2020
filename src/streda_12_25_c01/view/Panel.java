package streda_12_25_c01.view;

import streda_12_25_c01.rasterize.Raster;
import streda_12_25_c01.rasterize.RasterBufferedImage;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Panel extends JPanel {

    private RasterBufferedImage raster;

    private static final int FPS = 1000 / 20;
    private static final int WIDTH = 800, HEIGHT = 600;

    Panel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        raster = new RasterBufferedImage(WIDTH, HEIGHT);
        raster.setClearColor(Color.BLACK.getRGB());
        setLoop();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        raster.repaint(g);
    }

    public void resize() {
        if (super.getWidth() < 1 || super.getHeight() < 1)
            return;
        if (super.getWidth() <= raster.getWidth() && super.getHeight() <= raster.getHeight()) //no resize if new is smaller
            return;
        RasterBufferedImage newRaster = new RasterBufferedImage(super.getWidth(), super.getHeight());

        newRaster.draw(raster);
        raster = newRaster;
    }

    private void setLoop() {
        // časovač, který 20 krát za vteřinu obnoví obsah plátna aktuálním img
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                repaint();
            }
        }, 0, FPS);
    }

    public Raster getRaster() {
        return raster;
    }

}
