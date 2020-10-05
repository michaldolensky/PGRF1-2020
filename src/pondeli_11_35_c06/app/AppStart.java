package pondeli_11_35_c06.app;

import pondeli_11_35_c06.rasterize.Raster;
import pondeli_11_35_c06.view.Window;

import javax.swing.*;
import java.awt.*;

public class AppStart {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Window window = new Window();

            Raster raster = window.getPanel().getRaster();

            raster.setPixel(15, 30, Color.YELLOW.getRGB());
//            window.getPanel().getRaster().clear();
            raster.setPixel(10, 10, 0xffff00);

            for (int x = 10; x <= 130; x++) {
                raster.setPixel(x, 50, 0x00ff00);
            }

            int x1 = 0, y1 = 1;
            int x2 = 8, y2 = 4;

            float k = (y2 - y1) / (float) (x2 - x1);
            float q = y1 - k * x1;
            System.out.println(k);
            System.out.println(q);

            window.setVisible(true); // zobrazit okno
        });
        // https://www.google.com/search?q=SwingUtilities.invokeLater
        // https://www.javamex.com/tutorials/threads/invokelater.shtml
    }

}
