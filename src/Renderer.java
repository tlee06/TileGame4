import java.awt.*;

public record Renderer(Graphics2D graphics) {

    public Vector2 worldToScreenVector(Vector2 world) {
        return world.scale(Player.instance.zoom * Main.getHeight());
    }

    public Vector2 worldToScreenPos(Vector2 world) {
        return worldToScreenVector(world.sub(Player.instance.pos)).add(screenCenter());
    }

    public Vector2 screenCenter() {
        return new Vector2(Main.getWidth(), Main.getHeight()).scale(0.5f);
    }

    public void setColor(Color c) {
        graphics.setColor(c);
    }

    public void drawRect(Vector2 pos, Vector2 size) {
        graphics.fillRect((int) pos.x, (int) pos.y, (int) size.x, (int) size.y);
    }

    public void drawRectWorldSpace(Vector2 pos, Vector2 size) {
        drawRect(worldToScreenPos(pos), worldToScreenVector(size));
    }
}
