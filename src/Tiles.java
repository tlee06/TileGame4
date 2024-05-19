import java.awt.*;

public class Tiles {
    public static final TileType DIRT = new TileType(
            new ConstantImageTileRenderer<>("./images/newRedDirt.png"),
            new ConstantImageTileRenderer<>("./images/reddirtbackground.png")
    );
    public static final TileType STONE = new TileType(
            new ConstantImageTileRenderer<>("./images/stone_single.png"),
            new ConstantImageTileRenderer<>("./images/stone_single_bg.png")
    );
    public static final TileType TREASURE = new TileType(
            new ConstantImageTileRenderer<>("./images/treasure.png")
    );
    public static final TileType GRASS = new TileType(
            new ConstantImageTileRenderer<>("./images/newgrass.png"),
            new ConstantImageTileRenderer<>("./images/stone_single_bg.png")
    );
    public static final TileType GRASSWEEDS = new TileType(
            new ConstantImageTileRenderer<>("./images/grassWeed.png"),false
    );
    public static ConstantImageTileRenderer getHotbarConstantImageTileRenderer(){
        return new ConstantImageTileRenderer<>("./images/hotbar.png");
    }
    public static ConstantImageTileRenderer getDirtConstantImageTileRenderer(){
        return new ConstantImageTileRenderer<>("./images/newRedDirt.png");
    }
    public static ConstantImageTileRenderer getStoneConstantImageTileRenderer(){
        return new ConstantImageTileRenderer<>("./images/stone_single.png");
    }
    public static ConstantImageTileRenderer getHotbarSelectorConstantImageTileRenderer(){
        return new ConstantImageTileRenderer<>("./images/hotbar_selection.png");
    }



}
