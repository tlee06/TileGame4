import java.util.Objects;

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
    public final Vector2Int floorToInt() {
        return new Vector2Int((int)Math.floor(x), (int)Math.floor(y));
    }
    public final Vector2 withX(double x){
        return new Vector2(x, this.y);
    }
    public final Vector2 withY(double y){
        return new Vector2(this.x, y);
    }
    public double dot(Vector2 b) {
        return (x*b.x)+(y*b.y);
    }

    //auto-generated by Intellij
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector2 vector2 = (Vector2) o;
        return Double.compare(vector2.x, x) == 0 && Double.compare(vector2.y, y) == 0;
    }

    //auto-generated by Intellij
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}