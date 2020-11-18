package streda_17_25_c02.controller;

import streda_17_25_c02.fill.PatternFill;
import streda_17_25_c02.fill.SeedFiller;
import streda_17_25_c02.model.Line;
import streda_17_25_c02.model.Point;
import streda_17_25_c02.rasterize.LineRasterizer;
import streda_17_25_c02.rasterize.Raster;
import streda_17_25_c02.rasterize.TrivialLineRasterizer;
import streda_17_25_c02.view.Panel;
import transforms.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
        patternFill = (x, y) -> {
            if (x % 2 == 0) return 0xff0000;
            else return 0x00ffff;
        };
//        patternFill = (x, y) -> x % 2 == 0 ? 0xff0000 : 0x00ffff;

        initListeners();

//        Point2D p1 = new Point2D(20, 20);
//        Point2D p2 = new Point2D(150, 30);
//        trivialLineRasterizer.rasterize((int) p1.getX(), (int) p1.getY(), (int) p2.getX(), (int) p2.getY(), Color.GREEN);
//
////        Mat3 mat = new Mat3Transl2D(0, 20);
//        Mat3 mat = new Mat3Transl2D(-20, -20).mul(new Mat3Scale2D(2)).mul(new Mat3Transl2D(20, 20));
//        p1 = p1.mul(mat);
//        p2 = p2.mul(mat);
//        trivialLineRasterizer.rasterize((int) p1.getX(), (int) p1.getY(), (int) p2.getX(), (int) p2.getY(), Color.PINK);
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
                seedFiller.setSeed(new Point(e.getX(), e.getY()));
                seedFiller.setFillColor(0xffffff);
                seedFiller.fill();
            }
        });
        panel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                raster.clear();
                Line line = new Line(mx, my, e.getX(), e.getY(), 0x00ff00);
                trivialLineRasterizer.rasterize(line);
            }
        });
    }
}
