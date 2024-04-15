import java.awt.*;

public class Player extends GameObject{
    public static Player instance;

    public double zoom = 0.025;
    public Vector2 size = new Vector2(0.8, 1.8);
    public Vector2 pos = new Vector2(0,0);

    public Player(){
        instance = this;
    }

    @Override
    public void render(Renderer r) {
        r.setColor(Color.BLACK);
        r.drawRectWorldSpace(pos.sub(size.scale(0.5)), size);
    }

    @Override
    public void tick() {

    }
}
