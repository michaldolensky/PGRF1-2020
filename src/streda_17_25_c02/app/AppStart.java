package streda_17_25_c02.app;

import streda_17_25_c02.rasterize.Raster;
import streda_17_25_c02.view.Window;

import javax.swing.*;
import java.awt.*;

public class AppStart {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Window window = new Window();

            Raster raster = window.getPanel().getRaster();
            raster.setPixel(10, 20, Color.YELLOW.getRGB());
            raster.setPixel(20, 10, Color.GREEN.getRGB());
            raster.clear();
            raster.setPixel(100, 100, 0x00ff90);

            for (int x = 30; x <= 180; x++) {
                raster.setPixel(x, 50, (int) (Math.random() * 100_000_000));
            }

            int x1 = 0, y1 = 1;
            int x2 = 8, y2 = 4;


            float k = (y2 - y1) / (float) (x2 - x1);
            float q = y1 - k * x1;
            System.out.println(k);
            System.out.println(q);

            for (int x = x1; x <= x2; x++) {
                float y = k * x + q;
                raster.setPixel(x, Math.round(y), 0xffffff);
            }

            window.setVisible(true); // zobrazit okno
        });
        // https://www.google.com/search?q=SwingUtilities.invokeLater
        // https://www.javamex.com/tutorials/threads/invokelater.shtml
    }

}
