import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keybind {
    private int keyCode;

    private boolean isDown;
    private boolean isDownPrev;

    public Keybind(int keyCode){
        this.keyCode = keyCode;
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher((ke) -> {
            switch (ke.getID()){
                case KeyEvent.KEY_PRESSED -> keyPressed(ke);
                case KeyEvent.KEY_RELEASED -> keyReleased(ke);
            }
            return false;
        });
        Main.onUpdate.subscribe(this::update);
    }


    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == keyCode){
            isDown = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == keyCode){
            isDown = false;
        }
    }

    public boolean isDown(){
        return isDown;
    }

    public boolean isPressed(){
        return isDown && !isDownPrev;
    }

    public boolean isReleased(){
        return !isDown && isDownPrev;
    }

    private void update(){
        isDownPrev = isDown;
    }
}
