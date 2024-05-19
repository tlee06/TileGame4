import javax.swing.*;
import java.awt.*;

public class Main {
    public static final double MAX_DELTA_TIME = (1/15d);
    public static final RunnableEvent onUpdate = new RunnableEvent();
    public static final RunnableEvent onPreUpdate = new RunnableEvent();
    private static JFrame window;
    private static GameCanvas canvas;

    private static long timePrev;
    private static double deltaTime;
    private static long currentTime;


    public static void main(String[] args) {
        //System.setProperty("sun.java2d.opengl", "true");

        window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(500, 500);
        window.setTitle("2D Tile Game");
        window.setVisible(true);

        canvas = new GameCanvas(window);

        //initialize player
        new Player();

        //update object list to include initial objects
        GameObject.updateObjectList();


        mainLoop();
    }

    private static void mainLoop(){
        update();
        render();


        EventQueue.invokeLater(Main::mainLoop);
    }

    private static void update(){
        currentTime = System.nanoTime();

        //load chunks
        Vector2Int topLeftChunk = Chunk.toChunkPos(Renderer.viewportTopLeftCorner());
        Vector2Int bottomRightChunk = Chunk.toChunkPos(Renderer.viewportBottomRightCorner());
        for (int x = topLeftChunk.x; x <= bottomRightChunk.x; x++) {
            for (int y = topLeftChunk.y; y <= bottomRightChunk.y; y++) {
                Chunk.getChunk(new Vector2Int(x, y));
            }
        }

        onPreUpdate.invoke();

        for(GameObject g : GameObject.getAllObjects()){
            g.tick();
        }

        onUpdate.invoke();

        GameObject.updateObjectList();

        long newTime = System.nanoTime();
        long delta = newTime - timePrev;
        deltaTime = delta / 1_000_000_000D;
        timePrev = newTime;
    }

    private static void render(){
        canvas.draw();
    }

    public static double getWidth() {
        return canvas.getWidth();
    }

    public static double getHeight() {
        return canvas.getHeight();
    }

    public static double getDeltaTime(){
        return Math.min(deltaTime, MAX_DELTA_TIME);
    }

    public static double getUncappedDeltaTime(){
        return deltaTime;
    }

    public static double getTime(){
        return currentTime / 1_000_000_000D;
    }

    public static JFrame getWindow(){
        return window;
    }

    public static GameCanvas getCanvas(){
        return canvas;
    }
}