package pondeli_11_35_c06.controller;

import pondeli_11_35_c06.fill.PatternFill;
import pondeli_11_35_c06.fill.SeedFiller;
import pondeli_11_35_c06.model.Point;
import pondeli_11_35_c06.rasterize.LineRasterizer;
import pondeli_11_35_c06.rasterize.Raster;
import pondeli_11_35_c06.rasterize.TrivialLineRasterizer;
import pondeli_11_35_c06.view.Panel;
import transforms.*;

import java.awt.*;
import java.awt.event.*;

public class Controller2D {

    private final Panel panel;
    private final Raster raster;
    private final LineRasterizer trivialLineRasterizer;
    private final SeedFiller seedFiller;
    private final PatternFill patternFill;

    private int mx, my;

    public Controller2D(Panel panel) {
        this.panel = panel;
        this.raster = panel.getRaster();

        trivialLineRasterizer = new TrivialLineRasterizer(raster);
        seedFiller = new SeedFiller(raster);
//        patternFill = new PatternFill() {
//            @Override
//            public int paint(int x, int y) {
//                if (x % 2 == 0) return 0x00ff00;
//                else return 0xffff00;
//            }
//        };
        patternFill = (x, y) -> {
            if (x % 2 == 0) return 0x00ff00;
            else return 0xffff00;
        };

//        patternFill = (x, y) -> x % 2 == 0 ? 0x00ff00 : 0xffff00;

        initListeners();

//        for (int x = 20; x <= 500; x++) {
//            raster.setPixel(x, 20, 0xffff00);
//            raster.setPixel(x, 500, 0xffff00);
//        }
//        for (int y = 20; y <= 500; y++) {
//            raster.setPixel(20, y, 0xffff00);
//            raster.setPixel(500, y, 0xffff00);
//        }

//        Point2D p1 = new Point2D(0, 100);
//        Point2D p2 = new Point2D(100, 110);
//        trivialLineRasterizer.rasterize((int) p1.getX(), (int) p1.getY(), (int) p2.getX(), (int) p2.getY(), Color.MAGENTA);
//
////        Mat3 transl = new Mat3Transl2D(10, 100).mul(new Mat3Scale2D(2));
//        Mat3 transl = new Mat3Scale2D(2).mul(new Mat3Transl2D(10, 100));
//        // měřítko (scale), rotace, posunutí (translace)
//        p1 = p1.mul(transl);
//        p2 = p2.mul(transl);
//
//        trivialLineRasterizer.rasterize((int) p1.getX(), (int) p1.getY(), (int) p2.getX(), (int) p2.getY(), Color.CYAN);
    }

    private void initListeners() {
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mx = e.getX();
                my = e.getY();
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.isShiftDown()) {
                    seedFiller.setSeed(new Point(e.getX(), e.getY()));
                    seedFiller.setFillColor(0xff00ff);
                    seedFiller.fill();
//                    seedFiller.setSeed(new Point(e.getX(), e.getY()))
//                            .setFillColor(0xff00ff)
//                            .fill();
                }
            }
        });

        panel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                raster.clear();
                trivialLineRasterizer.rasterize(mx, my, e.getX(), e.getY(), Color.RED);
            }
        });

        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    System.out.println("mezerník");
                }
//                System.out.println(e.getKeyCode());
//                System.out.println(e.getKeyChar());
//                System.out.println("----");
            }
        });
    }

}
