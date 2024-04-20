public abstract class TileRenderer<TileT extends AbstractTileType<?>> {
    public abstract void render(Renderer r, Chunk.Tilemap<TileT> tilemap, int localPosX, int localPosY);
}
