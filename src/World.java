public class World {
    //private constructor makes class (practically) uninstantiable (like the Math class)
    private World(){}

    private static TerrainGenerator generator = new TestTerrainGenerator();

    public static Chunk loadChunk(Vector2Int chunkPos){
        Chunk chunk = new Chunk(chunkPos);

        for (int x = 0; x < Chunk.CHUNK_SIZE; x++){
            for (int y = 0; y < Chunk.CHUNK_SIZE; y++) {
                LayeredTileType tile = generator.getTile(chunk.toGlobalPosX(x), y + chunk.toGlobalPosY(y));
                chunk.mainTilemap.setTile(x, y, tile.main());
                chunk.backgroundTilemap.setTile(x, y, tile.background());
            }
        }

        //TODO: actual world generation
        return chunk;
    }

    public static TileType getMainTile(Vector2Int globalPos){
        Chunk chunk = getChunkGlobal(globalPos);
        return chunk.mainTilemap.getTile(chunk.toLocalPos(globalPos));
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
