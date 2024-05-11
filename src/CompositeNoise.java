public class CompositeNoise extends Noise{
    private final Noise[] noises;
    public CompositeNoise(double frequency, double amplitude, Noise... noises) {
        super(frequency, amplitude);
        this.noises = noises;
    }

    @Override
    public double sampleBase(double x, double y) {
        double total = 0;
        for(Noise noise : noises){
            total += noise.sample(x, y);
        }

        return total;
    }
}
