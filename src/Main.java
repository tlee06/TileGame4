import javax.swing.*;
import java.awt.*;

public class Main {
    public static final RunnableEvent onUpdate = new RunnableEvent();
    private static JFrame window;
    private static GameCanvas canvas;

    private static long timePrev;
    private static double deltaTime;
    private static long currentTime;

    public static void main(String[] args) {
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

        Chunk test = new Chunk(new Vector2Int(0, 0));
        test.mainTilemap.setTile(0, 1, Tiles.DIRT);
    }

    private static void mainLoop(){
        update();
        render();

        EventQueue.invokeLater(Main::mainLoop);
    }

    private static void update(){
        currentTime = System.nanoTime();

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
        return deltaTime;
    }

    public static double getTime(){
        return currentTime / 1_000_000_000D;
    }
}