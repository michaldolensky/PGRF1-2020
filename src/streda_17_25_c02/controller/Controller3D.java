package streda_17_25_c02.controller;

import streda_17_25_c02.model3d.Scene;
import streda_17_25_c02.rasterize.Raster;
import streda_17_25_c02.renderer.GPURenderer;
import streda_17_25_c02.renderer.Renderer3D;
import streda_17_25_c02.view.Panel;
import transforms.*;

public class Controller3D {

    private final GPURenderer renderer;
    private final Raster raster;

    private Scene mainScene;

    private Mat4 model, view, projection;
    private Camera camera;

    public Controller3D(Panel panel) {
        this.raster = panel.getRaster();
        this.renderer = new Renderer3D();

        mainScene = new Scene();
//        mainScene.addSolid(new Cube());

        model = new Mat4Identity();

        var e = new Vec3D(0, -5, 2);
        var v = new Vec3D(0, 5, -2);
        var up = new Vec3D(0, 0, 1);
        view = new Mat4ViewRH(e, v, up);

        camera = new Camera()
                .withPosition(e)
                .withAzimuth(Math.toRadians(90))
                .withZenith(Math.toRadians(-20));

//        camera = camera.forward(0.5);
//        camera.getViewMatrix();

        projection = new Mat4PerspRH(
                Math.PI / 3,
                raster.getHeight() / (float) raster.getWidth(),
                0.5,
                50
        );

//        projection = new Mat4OrthoRH(40, 30, 0.5, 50);

        initListeners(panel);
    }

    private void initListeners(Panel panel) {
        // TODO
    }

    private void repaint() {
        raster.clear();

        renderer.setModel(model);
//        renderer.setView();
//        renderer.setProjection();
//        renderer.draw(scene);

        // scéna s osami; draw bez modelovací transformace
        // TODO
    }

}
