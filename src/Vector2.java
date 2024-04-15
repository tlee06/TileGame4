public class Vector2{
    public final double x;
    public final double y;

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public final Vector2 add(Vector2 b){
        return new Vector2(x + b.x, y + b.y);
    }
    public final Vector2 sub(Vector2 b){
        return new Vector2(x - b.x, y - b.y);
    }
    public final Vector2 scale(double b){
        return new Vector2(x * b, y * b);
    }
}