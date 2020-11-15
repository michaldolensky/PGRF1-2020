package streda_12_25_c01.controller;

import streda_12_25_c01.fill.PatternFill;
import streda_12_25_c01.fill.SeedFiller;
import streda_12_25_c01.model.Line;
import streda_12_25_c01.model.Point;
import streda_12_25_c01.rasterize.LineRasterizer;
import streda_12_25_c01.rasterize.Raster;
import streda_12_25_c01.rasterize.TrivialLineRasterizer;
import streda_12_25_c01.view.Panel;

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
        patternFill = (x, y) -> {
            if (x % 2 == 0) return 0xffff00;
            else return 0xff00ff;
        };
//        patternFill = (x, y) -> (x % 2 == 0 ? 0xffff00 : 0xff00ff);

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
                if (e.isShiftDown()) {
                    seedFiller.setSeed(new Point(e.getX(), e.getY()));
                    seedFiller.setFillColor(0x00ff00); // Color.YELLOW.getRGB();
                    seedFiller.fill();
                }
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

        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_P) {
                    System.out.println("P was released");
                }
            }
        });
    }

}
