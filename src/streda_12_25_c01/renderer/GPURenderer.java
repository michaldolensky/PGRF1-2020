package streda_12_25_c01.renderer;

import streda_12_25_c01.model3d.Scene;
import transforms.Mat4;

public interface GPURenderer {

    void draw(Scene scene);

    void setModel(Mat4 model);

    void setView(Mat4 view);

    void setProjection(Mat4 projection);

}
