package streda_17_25_c02.controller;

import streda_17_25_c02.fill.SeedFiller;
import streda_17_25_c02.model.Line;
import streda_17_25_c02.model.Point;
import streda_17_25_c02.rasterize.LineRasterizer;
import streda_17_25_c02.rasterize.Raster;
import streda_17_25_c02.rasterize.TrivialLineRasterizer;
import streda_17_25_c02.view.Panel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Controller2D {

    private final Panel panel;
    private final Raster raster;

    private final LineRasterizer trivialLineRasterizer;
    private final SeedFiller seedFiller;

    private int mx, my;

    public Controller2D(Panel panel) {
        this.panel = panel;
        this.raster = panel.getRaster();

        trivialLineRasterizer = new TrivialLineRasterizer(raster);
        seedFiller = new SeedFiller(raster);

        initListeners();
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
