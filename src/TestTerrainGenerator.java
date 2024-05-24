public class TestTerrainGenerator extends TerrainGenerator{
    @Override
    public void setTile(Chunk chunk, int localX, int localY) {
        int x = chunk.toGlobalPosX(localX);
        int y = chunk.toGlobalPosY(localY);

        TileType main = null;
        BackgroundTileType bg = null;

        if(x > 10 || y > 10) main = Tiles.DIRT;

        chunk.mainTilemap.setTile(localX, localY, main);
        chunk.backgroundTilemap.setTile(localX, localY, bg);
    }

    @Override
    public void setTreasureTile(Chunk chunk, int localX, int localY) { //added for gold and treasure chest

    }

    //    @Override
//    public LayeredTileType getTile(int x, int y) {
//        TileType main = null;
//        if(x > 10 || y > 10) main = Tiles.DIRT;
//
//        return new LayeredTileType(main, null);
//    }
}
