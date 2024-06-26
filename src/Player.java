import java.awt.*;

public class Player extends GameObject{
    public static Player instance;
    private static final double ZOOM_SPEED = 0.03;

    public double zoom = 0.03;
    public int goldCounter=0;
    public double speed = 10;
    public double terminalVelocity = 30;
    public double jumpPower = 10;
    public Vector2 gravity = new Vector2(0, 30);
    public Vector2 size = new Vector2(0.8, 1.8);
    public Vector2 pos = new Vector2(0,-50);
    public Vector2 velocity = new Vector2(0, 0);
    public TileType myTile = Tiles.DIRT;
    private boolean noClipEnabled=false;



    private boolean isGrounded = false;
    private static Image hotbar;
    private static Image hotbarSelector;

    private static Image dirt;
    private static Image stone;






    private final Collider collider = new Collider() {
        @Override
        public Vector2 getCenter() {
            return pos;
        }

        @Override
        public void setCenter(Vector2 value) {
            pos = value;
        }

        @Override
        public Vector2 getSize() {
            return size;
        }

        @Override
        public void onBottomCollide() {
            isGrounded = true;
            if(velocity.y > 0) velocity = velocity.withY(0);
        }

        @Override
        public void onTopCollide() {
            if(velocity.y < 0) velocity = velocity.withY(0);
        }
    };

    public Player(){
        instance = this;
    }

    @Override
    public void render(Renderer r) {

        Font myFont=new Font("Arial",Font.BOLD,25);
        r.graphics().setFont(myFont);
        //r.setColor(new Color(((float) Math.sin(Main.getTime()) + 1f)/2f,0f,0f));
        r.drawRectWorldSpace(pos.sub(size.scale(0.5)), size);

        r.graphics().drawString("FPS: " + (1/Main.getUncappedDeltaTime()), 10, 20);

        r.graphics().drawString("Gold " + goldCounter, 10, 200);
        hotbar=Tiles.getHotbarConstantImageTileRenderer().getImage();
        dirt=Tiles.getDirtConstantImageTileRenderer().getImage();
        stone=Tiles.getStoneConstantImageTileRenderer().getImage();
        hotbarSelector=Tiles.getHotbarSelectorConstantImageTileRenderer().getImage();


        r.drawImage(hotbar,600,900,728,88);
        r.drawImage(dirt,612,910,64,64);
        r.drawImage(stone,692,910,64,64);

        if(myTile.equals(Tiles.DIRT)){
            r.drawImage(hotbarSelector,595,895,96,96);
        }
        else{
            r.drawImage(hotbarSelector,675,895,96,96);
        }



    }

    @Override
    public void tick() {
        Vector2Int mouseTile = Renderer.screenToWorldPos(Input.getMousePosition().toVector()).floorToInt();
        if(Input.reset.isPressedForOneFrame()){
            pos = new Vector2(0,-50);
        }
        if(Input.teleport.isPressedForOneFrame()){
            pos = mouseTile.toVector();
        }
        if(Input.moveLeft.isDown()) {
            pos = pos.add(new Vector2(-speed, 0.0).scale(Main.getDeltaTime()));
        }

        if(Input.moveRight.isDown()) {
            pos = pos.add(new Vector2(speed, 0.0).scale(Main.getDeltaTime()));
        }
        if (Input.noClip.isPressedForOneFrame()) {
            noClipEnabled=!noClipEnabled;
        }
        if (noClipEnabled) {
            speed=50;
            gravity = new Vector2(0, 0);
            if(Input.moveUp.isDown()) {
                pos = pos.add(new Vector2(0, -speed).scale(Main.getDeltaTime()));
            }
            if(Input.moveDown.isDown()) {
                pos = pos.add(new Vector2(0, speed).scale(Main.getDeltaTime()));
            }
        }
        else{
            speed=10;
            velocity = velocity.add(gravity.scale(Main.getDeltaTime()));
            velocity = velocity.withY(Math.min(velocity.y, terminalVelocity));
            pos = pos.add(velocity.scale(Main.getDeltaTime()));

            isGrounded = false;
            collider.processCollisionWithTerrain();
            gravity = new Vector2(0, 30);

        }

        if(Input.jump.isPressedForOneFrame() && isGrounded){
            velocity = velocity.withY(-jumpPower);
        }


        if(Input.use.isPressedForOneFrame()){
            if((Util.mouseClickWithinRange((int)(mouseTile.toVector().x-pos.x),(int)(mouseTile.toVector().y-pos.y),10))||noClipEnabled) {

                if (World.getMainTile(mouseTile) != null && World.getMainTile(mouseTile).equals(Tiles.TREASURE)) {
                    World.setMainTile(mouseTile, null);
                    goldCounter += 1;
                } else {
                    World.setMainTile(mouseTile, null);
                }
            }
        }
        if((Input.placeBlock.isPressedForOneFrame()&&(Util.mouseClickWithinRange((int)(mouseTile.toVector().x-pos.x),(int)(mouseTile.toVector().y-pos.y),10)))||Input.placeBlock.isPressedForOneFrame()&&noClipEnabled){
            World.setMainTile(mouseTile,myTile);
            System.out.println("yes");
        }
        if(Input.chooseDirtBlockType.isPressedForOneFrame()){
            myTile=Tiles.DIRT;
        }
        if(Input.chooseStoneBlockType.isPressedForOneFrame()){
            myTile=Tiles.STONE;
        }


        if(Input.zoomIn.isDown()){
            zoom += ZOOM_SPEED * Main.getDeltaTime();
        }

        if(Input.zoomOut.isDown()){
            zoom -= ZOOM_SPEED * Main.getDeltaTime();
        }


        zoom = Math.max(zoom, 0.001);
    }
}
