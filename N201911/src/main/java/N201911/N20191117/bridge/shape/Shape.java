package N201911.N20191117.bridge.shape;

import com.joah.everyday.N2019.N201911.N20191117.bridge.color.Color;

/**
 * 抽象一个形状类
 */
public abstract class Shape {
    Color color;

    public void setColor(Color color){
        this.color = color;
    }

    public abstract void draw();
}
