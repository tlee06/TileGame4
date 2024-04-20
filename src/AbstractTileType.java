public abstract class AbstractTileType<TSelf extends AbstractTileType<TSelf>> {
    public final TileRenderer<TSelf> renderer;
    public void render(Renderer r, Chunk.Tilemap<TSelf> tilemap, int localPosX, int localPosY){
        renderer.render(r, tilemap, localPosX, localPosY);
    }

    public AbstractTileType(TileRenderer<TSelf> renderer){
        this.renderer = renderer;
    }
}
