public class Player extends GameObject{
    public static Player instance;

    public double zoom = 0.05;
    public double speed = 15;
    public double terminalVelocity = 30;
    public double jumpPower = 10;
    public Vector2 gravity = new Vector2(0, 16);
    public Vector2 size = new Vector2(0.8, 1.8);
    public Vector2 pos = new Vector2(0,0);
    public Vector2 velocity = new Vector2(0, 0);

    private boolean isGrounded = false;

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
            velocity = velocity.withY(0);
        }

        @Override
        public void onTopCollide() {
            velocity = velocity.withY(0);
        }
    };

    public Player(){
        instance = this;
    }

    @Override
    public void render(Renderer r) {
        //r.setColor(new Color(((float) Math.sin(Main.getTime()) + 1f)/2f,0f,0f));
        r.drawRectWorldSpace(pos.sub(size.scale(0.5)), size);
    }

    @Override
    public void tick() {
        if(Input.moveLeft.isDown()) {
            pos = pos.add(new Vector2(-speed, 0.0).scale(Main.getDeltaTime()));
        }

        if(Input.moveRight.isDown()) {
            pos = pos.add(new Vector2(speed, 0.0).scale(Main.getDeltaTime()));
        }

        velocity = velocity.add(gravity.scale(Main.getDeltaTime()));
        velocity = velocity.withY(Math.min(velocity.y, terminalVelocity));
        pos = pos.add(velocity.scale(Main.getDeltaTime()));

        isGrounded = false;
        collider.processCollisionWithTerrain();

        if(Input.jump.isPressed() && isGrounded){
            velocity = velocity.withY(-jumpPower);
        }
    }
}
