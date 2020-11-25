package pondeli_11_35_c06.controller;

import pondeli_11_35_c06.model3d.Scene;
import pondeli_11_35_c06.rasterize.Raster;
import pondeli_11_35_c06.renderer.GPURenderer;
import pondeli_11_35_c06.renderer.Renderer3D;
import pondeli_11_35_c06.view.Panel;
import transforms.*;

public class Controller3D {

    private final GPURenderer renderer;
    private final Raster raster;

    private final Scene mainScene;

    private Mat4 model, view, projection;
    private Camera camera;

    public Controller3D(Panel panel) {
        this.raster = panel.getRaster();
        initListeners(panel);

        renderer = new Renderer3D(raster);

        mainScene = new Scene();
//        mainScene.addSolid(new Cube());

        model = new Mat4Identity();

        Vec3D e = new Vec3D(0, -5, 2);
        Vec3D v = new Vec3D(0, 5, -2);
        Vec3D up = new Vec3D(0, 0, 1);
        view = new Mat4ViewRH(e, v, up);

        camera = new Camera()
                .withPosition(e)
                .withAzimuth(Math.toRadians(90))
                .withZenith(Math.toRadians(-20));
//                .withFirstPerson(false)

        camera = camera.backward(0.5);
//        camera.getViewMatrix()

        projection = new Mat4PerspRH(
                Math.PI / 3,
                raster.getHeight() / (float) raster.getWidth(),
                 0.1,
                50
        );

        // 40 a 30 jsou velikosti okénka; mělo by být poměrově k velikosti okna
//        projection = new Mat4OrthoRH(40, 20, 1, 20);
    }

    private void initListeners(Panel panel) {
        // TODO
//        panel.addMouseListener();
    }
}
