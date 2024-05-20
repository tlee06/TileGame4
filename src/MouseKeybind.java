import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class MouseKeybind extends Keybind{
    private final int button;
    public MouseKeybind(int button){
        this.button = button;
        Toolkit.getDefaultToolkit().addAWTEventListener(e -> {
            MouseEvent me = (MouseEvent)e;

            switch (me.getID()){
                case MouseEvent.MOUSE_PRESSED -> keyPressed(me);
                case MouseEvent.MOUSE_RELEASED -> keyReleased(me);
            }
        }, KeyEvent.MOUSE_EVENT_MASK);
    }

    public void keyPressed(MouseEvent e) {
        if(e.getButton() == button){
            isDown = true;
        }
    }

    public void keyReleased(MouseEvent e) {
        if(e.getButton() == button){
            isDown = false;
        }
    }
}
