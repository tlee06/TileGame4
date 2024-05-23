import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Input {
    public static Keybind moveLeft = new KeyboardKeybind(KeyEvent.VK_A);
    public static Keybind moveRight = new KeyboardKeybind(KeyEvent.VK_D);
    public static Keybind jump = new KeyboardKeybind(KeyEvent.VK_SPACE);
    public static Keybind zoomIn = new KeyboardKeybind(KeyEvent.VK_EQUALS);
    public static Keybind zoomOut = new KeyboardKeybind(KeyEvent.VK_MINUS);
    public static Keybind chooseDirtBlockType = new KeyboardKeybind(KeyEvent.VK_1); //added for hotbar
    public static Keybind chooseStoneBlockType = new KeyboardKeybind(KeyEvent.VK_2);//added for hotbar
    public static Keybind noClip = new KeyboardKeybind(KeyEvent.VK_N); //added for noclip
    public static Keybind moveUp = new KeyboardKeybind(KeyEvent.VK_W); //added for noclip
    public static Keybind moveDown = new KeyboardKeybind(KeyEvent.VK_S);//added for noclip
    public static Keybind reset = new KeyboardKeybind(KeyEvent.VK_R);//added for reset and teleport
    public static Keybind teleport = new KeyboardKeybind(KeyEvent.VK_T);//added for reset and teleport




    public static Keybind placeBlock = new MouseKeybind(MouseEvent.BUTTON3);//added for placing blocks
    public static Keybind use = new MouseKeybind(MouseEvent.BUTTON1);










    public static Vector2Int getMousePosition(){
        Point point = MouseInfo.getPointerInfo().getLocation();
        SwingUtilities.convertPointFromScreen(point, Main.getCanvas());
        return new Vector2Int(point.x, point.y);
    }

}
