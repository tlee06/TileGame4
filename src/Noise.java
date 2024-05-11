public abstract class Noise {
    public double frequency;
    public double amplitude;

    public Noise(double frequency, double amplitude) {
        this.frequency = frequency;
        this.amplitude = amplitude;
    }

    public double sample(double x, double y){
        return sampleBase(x * frequency, y * frequency) * amplitude;
    }
    public abstract double sampleBase(double x, double y);
}
