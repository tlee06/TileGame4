import java.awt.*;
import java.awt.image.BufferStrategy;
public class GameCanvas extends Canvas {
    private final BufferStrategy bs;

    public GameCanvas(Window frame){
        frame.add(this);
        createBufferStrategy(2);
        bs = getBufferStrategy();

        setIgnoreRepaint(true);
    }

    public void draw(){
        Graphics2D graphics = (Graphics2D) bs.getDrawGraphics();
        graphics.clearRect(0, 0, (int)Main.getWidth(), (int)Main.getHeight());

        Renderer r = new Renderer(graphics);

        for(GameObject g : GameObject.getAllObjects()){
            g.render(r);
        }

        graphics.dispose();

        bs.show();
    }
}