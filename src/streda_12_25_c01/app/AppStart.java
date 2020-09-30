package streda_12_25_c01.app;

import streda_12_25_c01.rasterize.Raster;
import streda_12_25_c01.view.Window;

import javax.swing.*;
import java.awt.*;

public class AppStart {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Window window = new Window();

            Raster raster = window.getPanel().getRaster();
            for (int x = 10; x <= 90; x++) {
                raster.setPixel(x, 10, 0xffffff);
            }

            int x1 = 0, y1 = 10;
            int x2 = 80, y2 = 40;

            float k = (y2 - y1) / (float) (x2 - x1);
            float q = y1 - k * x1;
            

            window.setVisible(true); // zobrazit okno
        });
        // https://www.google.com/search?q=SwingUtilities.invokeLater
        // https://www.javamex.com/tutorials/threads/invokelater.shtml
    }

}
