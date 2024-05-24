public class Keybind {
    protected boolean pressed; // if key is currently down right now
    protected boolean isDown; //if it was down in the beginning of the current frame
    protected boolean isDownPrev; //if it was down in the beginning of the previous frame


    public Keybind(){
        //makes the update and preUpdate methods called every frame and at the beginning of
        //every frame respectively
        Main.onUpdate.subscribe(this::update);
        Main.onPreUpdate.subscribe(this::preUpdate);
    }

    public boolean isDown() {
        return isDown;
    }


    public boolean isPressedForOneFrame() {
        return isDown && !isDownPrev;
    }

    public boolean isReleased() {
        return !isDown && isDownPrev;
    }

    private void update(){
        isDownPrev = isDown;
    }
    private void preUpdate(){
        isDown = pressed;
    }


}
