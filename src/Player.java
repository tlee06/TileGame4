import java.awt.*;

public class Player extends GameObject{
    public static Player instance;

    public double zoom = 0.025;
    public double speed = 10;
    public Vector2 size = new Vector2(0.8, 1.8);
    public Vector2 pos = new Vector2(0,0);

    public Player(){
        instance = this;
    }

    @Override
    public void render(Renderer r) {
        r.setColor(new Color(((float) Math.sin(Main.getTime()) + 1f)/2f,0f,0f));
        r.drawRectWorldSpace(pos.sub(size.scale(0.5)), size);
    }

    @Override
    public void tick() {
        if(Keys.moveLeft.isDown()) {
            pos = pos.add(new Vector2(-speed * Main.getDeltaTime(), 0.0));
        }

        if(Keys.moveRight.isDown()) {
            pos = pos.add(new Vector2(speed * Main.getDeltaTime(), 0.0));
        }
    }
}
