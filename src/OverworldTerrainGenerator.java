public class OverworldTerrainGenerator extends TerrainGenerator {
    @Override
    public void setTile(Chunk chunk, int localX, int localY) {
        int x = chunk.toGlobalPosX(localX);
        int y = chunk.toGlobalPosY(localY);

        TileType main = null;
        BackgroundTileType bg = null;

        if(y > 10) main = Tiles.DIRT;
        if(y > 15) main = Tiles.STONE;

        chunk.mainTilemap.setTile(localX, localY, main);
        chunk.backgroundTilemap.setTile(localX, localY, bg);
    }
}
