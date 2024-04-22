import java.util.Objects;

public class Vector2Int {
    public final int x;
    public final int y;

    public Vector2Int(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public final Vector2Int add(Vector2Int b){
        return new Vector2Int(x + b.x, y + b.y);
    }
    public final Vector2Int sub(Vector2Int b){
        return new Vector2Int(x - b.x, y - b.y);
    }
    public final Vector2Int scale(int b){
        return new Vector2Int(x * b, y * b);
    }
    public final Vector2 scale(double b){
        return new Vector2(x * b, y * b);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector2Int that = (Vector2Int) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}