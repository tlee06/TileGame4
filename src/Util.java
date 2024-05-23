public class Util {
    //private constructor makes class (practically) uninstantiable (like the Math class)
    private Util(){}

    public static boolean isPointBelowLine(Vector2 p, Vector2 a, Vector2 b){
        Vector2 purp = b.sub(a);
        //noinspection SuspiciousNameCombination
        purp = new Vector2(-purp.y, purp.x);

        return p.sub(a).dot(purp) > 0;
    }

    public static boolean linesIntersect(Vector2 a1, Vector2 a2, Vector2 a3, Vector2 a4){
        return (isPointBelowLine(a3, a1, a2) ^ isPointBelowLine(a4, a1, a2)) &&
                (isPointBelowLine(a1, a3, a4) ^ isPointBelowLine(a2, a3, a4));
    }

    public static boolean isPointInTriangle(Vector2 p, Vector2 v1, Vector2 v2, Vector2 v3){
        return isPointBelowLine(p, v2, v1) &&
                isPointBelowLine(p, v3, v2) &&
                isPointBelowLine(p, v1, v3);
    }

    public static boolean trianglesIntersect(Vector2 a1, Vector2 a2, Vector2 a3, Vector2 b1, Vector2 b2, Vector2 b3){
        return isPointInTriangle(a1, b1, b2, b3) ||
                isPointInTriangle(a2, b1, b2, b3) ||
                isPointInTriangle(a3, b1, b2, b3) ||
                isPointInTriangle(b1, a1, a2, a3) ||
                isPointInTriangle(b2, a1, a2, a3) ||
                isPointInTriangle(b3, a1, a2, a3) ||
                linesIntersect(a1, a2, b1, b2) ||
                linesIntersect(a2, a3, b1, b2) ||
                linesIntersect(a3, a1, b1, b2) ||
                linesIntersect(a1, a2, b2, b3) ||
                linesIntersect(a2, a3, b2, b3) ||
                linesIntersect(a3, a1, b2, b3) ||
                linesIntersect(a1, a2, b3, b1) ||
                linesIntersect(a2, a3, b3, b1) ||
                linesIntersect(a3, a1, b3, b1);
    }

    public static double invLerp(double a, double b, double t){
        return clamp((t-a)/(b-a), 0, 1); //changed for Math.clamp() fixing
    }
    public static double clamp(double val, double min, double max) { //changed for Math.clamp() fixing
        return Math.max(min, Math.min(max, val)); //rationale: looked up what Math.clamp does 
        // realized it returns the value if it is in the range, and returns the min or max if it isn't
        // we implemented this using Math.max and Math.min 
    }
    public static boolean mouseClickWithinRange(int x, int y, int range){
        if(Math.pow(x,2)+Math.pow(y,2)<=(int)(Math.pow(range,2))){
            return true;
        }
        return false;
    }
}
