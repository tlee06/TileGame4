public class Tiles {
    public static final TileType DIRT = new TileType(
            new ConstantImageTileRenderer<>("./images/pixilart-drawing.png"),
            new ConstantImageTileRenderer<>("./images/reddirtbackground.png")
    );
    public static final TileType STONE = new TileType(
            new ConstantImageTileRenderer<>("./images/stone_single.png"),
            new ConstantImageTileRenderer<>("./images/stone_single_bg.png")
    );
    public static final TileType GRASS = new TileType(
            new ConstantImageTileRenderer<>("./images/grass.png")
    );
}
