package streda_12_25_c01.controller;

import streda_12_25_c01.model.Line;
import streda_12_25_c01.rasterize.LineRasterizer;
import streda_12_25_c01.rasterize.Raster;
import streda_12_25_c01.rasterize.TrivialLineRasterizer;
import streda_12_25_c01.view.Panel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Controller2D {

    private final Panel panel;
    private final Raster raster;
    private final LineRasterizer trivialLineRasterizer;

    private int mx, my;

    public Controller2D(Panel panel) {
        this.panel = panel;
        this.raster = panel.getRaster();

        trivialLineRasterizer = new TrivialLineRasterizer(raster);

        initListeners();
    }

    private void initListeners() {
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mx = e.getX();
                my = e.getY();
            }
        });

        panel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                raster.clear();
                trivialLineRasterizer.rasterize(
                        new Line(mx, e.getX(), my, e.getY(), 0xabcdef)
                );
            }
        });
    }
}
