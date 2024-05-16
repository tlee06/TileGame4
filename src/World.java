import java.util.Random;

public class World {
    //private constructor makes class (practically) uninstantiable (like the Math class)
    private World(){}

    private static TerrainGenerator generator = new OverworldTerrainGenerator(new Random().nextInt());

    public static Chunk loadChunk(Vector2Int chunkPos){
        Chunk chunk = Chunk.tryGetChunk(chunkPos);
        if(chunk != null) return  chunk;

        chunk = new Chunk(chunkPos);

        for (int x = 0; x < Chunk.CHUNK_SIZE; x++){
            for (int y = 0; y < Chunk.CHUNK_SIZE; y++) {
                generator.setTile(chunk, x, y);
            }
        }
        generator.setTreasureTile(chunk,(int)(Math.random()*Chunk.CHUNK_SIZE),(int)(Math.random()*Chunk.CHUNK_SIZE));
        return chunk;
    }

    public static TileType getMainTile(Vector2Int globalPos){
        Chunk chunk = getChunkGlobal(globalPos);
        return chunk.mainTilemap.getTile(chunk.toLocalPos(globalPos));
    }

    public static void setMainTile(Vector2Int globalPos, TileType tile){
        Chunk chunk = getChunkGlobal(globalPos);
        chunk.mainTilemap.setTile(chunk.toLocalPos(globalPos), tile);
    }

    public static BackgroundTileType getBackgroundTile(Vector2Int globalPos){
        Chunk chunk = getChunkGlobal(globalPos);
        return chunk.backgroundTilemap.getTile(chunk.toLocalPos(globalPos));
    }

    public static Chunk getChunkGlobal(Vector2Int global){
        return Chunk.getChunk(Chunk.toChunkPos(global));
    }

    public static TerrainGenerator getGenerator() {
        return generator;
    }
}
