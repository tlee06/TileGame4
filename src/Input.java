import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Input {
    public static Keybind moveLeft = new KeyboardKeybind(KeyEvent.VK_A);
    public static Keybind moveRight = new KeyboardKeybind(KeyEvent.VK_D);
    public static Keybind jump = new KeyboardKeybind(KeyEvent.VK_SPACE);
    public static Keybind use = new MouseKeybind(MouseEvent.BUTTON1);

    public static Keybind zoomIn = new KeyboardKeybind(KeyEvent.VK_EQUALS);
    public static Keybind zoomOut = new KeyboardKeybind(KeyEvent.VK_MINUS);

    public static Keybind debugReset = new KeyboardKeybind(KeyEvent.VK_R);
    public static Keybind debugTeleport = new KeyboardKeybind(KeyEvent.VK_T);

    public static Vector2Int getMousePosition(){
        Point point = MouseInfo.getPointerInfo().getLocation();
        SwingUtilities.convertPointFromScreen(point, Main.getCanvas());
        return new Vector2Int(point.x, point.y);
    }
}
