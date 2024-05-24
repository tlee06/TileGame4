import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class KeyboardKeybind extends Keybind {
    private final int keyCode;



    public KeyboardKeybind(int keyCode){
        this.keyCode = keyCode;
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher((ke) -> {
            switch (ke.getID()){
                case KeyEvent.KEY_PRESSED -> keyPressed(ke);
                case KeyEvent.KEY_RELEASED -> keyReleased(ke);
            }
            return false;
        });
    }


    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == keyCode){
            pressed = true;
        }

    }

    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == keyCode){
            pressed = false;
            System.out.println(e.getKeyCode());

        }

    }



}
