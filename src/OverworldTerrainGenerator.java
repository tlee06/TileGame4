public class OverworldTerrainGenerator extends TerrainGenerator {
    private final Noise mainNoise;
    private final double yCoefficient = 1;

    public final int seed;

    public OverworldTerrainGenerator(int seed){
        this.seed = seed;

        mainNoise = new CompositeNoise(
                1, 1,
                new ValueNoise(0.1, 5, StaticRandom.getRandom(seed, 0)),
                new ValueNoise(0.005, 15, StaticRandom.getRandom(seed, 1)),
                new ValueNoise(0.01, 30, StaticRandom.getRandom(seed, 2))
        );
    }

    @Override
    public void setTile(Chunk chunk, int localX, int localY) {
        TileType main = null;
        BackgroundTileType bg = null;

        int x = chunk.toGlobalPosX(localX);
        int y = chunk.toGlobalPosY(localY);

        double geologicalDepth = (y*yCoefficient) + mainNoise.sample(x, y);

        if(geologicalDepth > 0) main = Tiles.DIRT;
        if(geologicalDepth > 5) main = Tiles.STONE;

        chunk.mainTilemap.setTile(localX, localY, main);
        chunk.backgroundTilemap.setTile(localX, localY, bg);
    }
}
