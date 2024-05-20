public class Keybind {
    protected boolean isDown; // if key is currently down right now
    protected boolean isDownAtCurrentFrame; //if it was down in the beginning of the current frame
    protected boolean isDownAtPrevFrame; //if it was down in the beginning of the previous frame
    Vector2Int mouseTile = Renderer.screenToWorldPos(Input.getMousePosition().toVector()).floorToInt();


    public Keybind(){
        //makes the update and preUpdate methods called every frame and at the beginning of
        //every frame respectively
        Main.onUpdate.subscribe(this::update);
        Main.onPreUpdate.subscribe(this::preUpdate);
    }

    public boolean isDownAtCurrentFrame() {
        return isDownAtCurrentFrame;
    }


    public boolean isPressedForOneFrame() {
        return isDownAtCurrentFrame && !isDownAtPrevFrame;
    }

    public boolean isNotPressedForOneFrame() {
        return !isDownAtCurrentFrame && isDownAtPrevFrame;
    }

    private void update(){
        isDownAtPrevFrame = isDownAtCurrentFrame;
    }
    private void preUpdate(){
        isDownAtCurrentFrame = isDown;}
}
