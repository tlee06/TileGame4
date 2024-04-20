import java.awt.*;

public record Renderer(Graphics2D graphics) {

    public Vector2 worldToScreenVector(Vector2 world) {
        return new Vector2(worldToScreenVectorComponent(world.x), worldToScreenVectorComponent(world.y));
        //return world.scale(Player.instance.zoom * Main.getHeight());
    }
    public double worldToScreenVectorComponent(double val){
        return val * Player.instance.zoom * Main.getHeight();
    }

    public Vector2 worldToScreenPos(Vector2 world) {
        return new Vector2(worldToScreenPosX(world.x), worldToScreenPosY((world.y)));
        //return worldToScreenVector(world.sub(Player.instance.pos)).add(screenCenter());
    }

    public double worldToScreenPosX(double x){
        return  worldToScreenVectorComponent(x - Player.instance.pos.x) + (Main.getWidth()/2);
    }

    public double worldToScreenPosY(double y){
        return  worldToScreenVectorComponent(y - Player.instance.pos.y) + (Main.getHeight()/2);
    }

    public Vector2 screenCenter() {
        return new Vector2(Main.getWidth(), Main.getHeight()).scale(0.5f);
    }

    public void setColor(Color c) {
        graphics.setColor(c);
    }

    public void drawRect(double posX, double posY, double sizeX, double sizeY) {
        graphics.fillRect((int) posX, (int) posY, (int) sizeX, (int) sizeY);
    }

    public void drawRectWorldSpace(double posX, double posY, double sizeX, double sizeY) {
        drawRect(
                worldToScreenPosX(posX),
                worldToScreenPosY(posY),
                worldToScreenVectorComponent(sizeX),
                worldToScreenVectorComponent(sizeY)
        );
    }

    public void drawRect(Vector2 pos, Vector2 size) {
        graphics.fillRect((int) pos.x, (int) pos.y, (int) size.x, (int) size.y);
    }

    public void drawRectWorldSpace(Vector2 pos, Vector2 size) {
        drawRect(worldToScreenPos(pos), worldToScreenVector(size));
    }
}
