public class BackgroundTileType extends AbstractTileType<BackgroundTileType>{
    public final TileType foregroundTileType;
    public BackgroundTileType(TileRenderer<BackgroundTileType> renderer, TileType foregroundTileType) {
        super(renderer);
        this.foregroundTileType = foregroundTileType;
    }
}
