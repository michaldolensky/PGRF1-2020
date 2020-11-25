package streda_12_25_c01.controller;

import streda_12_25_c01.model3d.Scene;
import streda_12_25_c01.rasterize.Raster;
import streda_12_25_c01.renderer.GPURenderer;
import streda_12_25_c01.renderer.Renderer3D;
import streda_12_25_c01.view.Panel;
import transforms.*;

public class Controller3D {

    private final GPURenderer renderer;
    private final Raster raster;

    private Scene mainScene;

    private Mat4 model, view, projection;
    private Camera camera;

    public Controller3D(Panel panel) {
        this.raster = panel.getRaster();
        renderer = new Renderer3D();

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
//        camera.getViewMatrix();

//        camera = camera.backward(0.5);

        projection = new Mat4PerspRH(
                Math.PI / 3,
                raster.getHeight() / (float) raster.getWidth(),
                0.5,
                50
        );

//        new Mat4OrthoRH(40, 30, 1, 50);
        // 40 a 30 jsou velikost rámečku pohledu - nutné zachovat poměr stran obrazovky
    }
}
