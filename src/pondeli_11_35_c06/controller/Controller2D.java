package pondeli_11_35_c06.controller;

import pondeli_11_35_c06.rasterize.LineRasterizer;
import pondeli_11_35_c06.rasterize.Raster;
import pondeli_11_35_c06.rasterize.TrivialLineRasterizer;
import pondeli_11_35_c06.view.Panel;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
                trivialLineRasterizer.rasterize(mx, my, e.getX(), e.getY(), Color.RED);
            }
        });
    }

}
