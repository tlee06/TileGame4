public class BackgroundTileType extends AbstractTileType<BackgroundTileType>{
    public TileType foregroundTileType;
    public BackgroundTileType(TileRenderer<BackgroundTileType> renderer) {
        super(renderer);
    }
}
