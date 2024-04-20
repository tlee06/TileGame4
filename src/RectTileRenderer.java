public class RectTileRenderer<TileTypeT extends AbstractTileType<?>> extends TileRenderer<TileTypeT>{
    @Override
    public void render(Renderer r, Chunk.Tilemap<TileTypeT> tilemap, int localPosX, int localPosY) {
        r.drawRectWorldSpace(
                tilemap.getChunk().toGlobalPosX(localPosX),
                tilemap.getChunk().toGlobalPosY(localPosY),
                1,1
        );
    }
}
