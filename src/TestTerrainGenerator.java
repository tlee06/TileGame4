public class TestTerrainGenerator extends TerrainGenerator{
    @Override
    public LayeredTileType getTile(int x, int y) {
        TileType main = null;
        if(x > 10 || y > 10) main = Tiles.DIRT;

        return new LayeredTileType(main, null);
    }
}
