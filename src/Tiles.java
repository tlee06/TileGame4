public class Tiles {
    public static final TileType DIRT = new TileType(
            new ConstantImageTileRenderer<>("./images/dirt_single.png"),
            new ConstantImageTileRenderer<>("./images/dirt_single_bg.png")
    );
    public static final TileType STONE = new TileType(
            new ConstantImageTileRenderer<>("./images/stone_single.png"),
            new ConstantImageTileRenderer<>("./images/stone_single_bg.png")
    );
}
