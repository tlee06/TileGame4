import javax.swing.*;
import java.awt.*;

public class Main {
    private static JFrame window;
    private static GameCanvas canvas;

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
    }

    private static void mainLoop(){
        update();
        render();

        EventQueue.invokeLater(Main::mainLoop);
    }

    private static void update(){
        for(GameObject g : GameObject.getAllObjects()){
            g.tick();
        }

        GameObject.updateObjectList();
    }

    private static void render(){
        canvas.render();
    }

    public static double getWidth() {
        return canvas.getWidth();
    }

    public static double getHeight() {
        return canvas.getHeight();
    }
}