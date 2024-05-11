public class ValueNoise extends Noise {
    public enum InterpolationType{
        LINEAR,
        CUBIC,
        PIECEWISE_QUADRATIC,
        SINE
    }
    private final int seed;
    private final InterpolationType interpolation;


    public ValueNoise(double frequency, double amplitude, int seed, InterpolationType interpolation) {
        super(frequency, amplitude);
        this.seed = seed;
        this.interpolation = interpolation;
    }

    public ValueNoise(double frequency, double amplitude, int seed) {
        this(frequency, amplitude, seed, InterpolationType.CUBIC);
    }

    @Override
    public double sampleBase(double x, double y) {
        int x0 = (int)Math.floor(x);
        int y0 = (int)Math.floor(y);

        int x1 = x0 + 1;
        int y1 = y0 + 1;

        double tx = x - x0;
        double ty = y - y0;

        double v00 = getRandom(x0, y0);
        double v01 = getRandom(x0, y1);
        double v10 = getRandom(x1, y0);
        double v11 = getRandom(x1, y1);

        double a0 = interpolate(v00, v10, tx);
        double a1 = interpolate(v01, v11, tx);

        return interpolate(a0, a1, ty);
    }

    private double getRandom(int x, int y){
        return StaticRandom.getRandomDouble(x, y, seed);
    }

    private double interpolate(double a, double b, double t){
        return switch (interpolation) {
            case LINEAR -> lerp(a, b, t);
            case CUBIC -> lerp(a, b, cubicInterpolation(t));
            case PIECEWISE_QUADRATIC -> lerp(a, b, piecewiseQuadraticInterpolation(t));
            case SINE -> lerp(a, b, sineInterpolation(t));
        };
    }

    private static double cubicInterpolation(double t){
        return (-2*t*t*t)+(3*t*t);
    }

    private static double piecewiseQuadraticInterpolation(double t){
        if(t < 0.5){
            return (2*t*t);
        }
        else{
            double x = 1-t;
            return 1-(2*x*x);
        }
    }

    private static double sineInterpolation(double t){
        double x = Math.sin(Math.PI * t * 0.5);
        return x*x;
    }

    private static double lerp(double a, double b, double t){
        return a + (t*(b-a));
    }
}
