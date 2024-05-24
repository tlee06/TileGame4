import java.awt.*;

public class Tiles {
    public static final TileType DIRT = new TileType(
            new ConstantImageTileRenderer<>("./images/newRedDirt.png"), //changed for red dirt
            new ConstantImageTileRenderer<>("./images/reddirtbackground.png") //changed for red dirt
    );
    public static final TileType STONE = new TileType(
            new ConstantImageTileRenderer<>("./images/stone_single.png"),
            new ConstantImageTileRenderer<>("./images/stone_single_bg.png")
    );
    public static final TileType TREASURE = new TileType(
            new ConstantImageTileRenderer<>("./images/treasure.png") //added for gold and treasure chest
    );
    public static final TileType GRASS = new TileType( //added for grass
            new ConstantImageTileRenderer<>("./images/newgrass.png"),
            new ConstantImageTileRenderer<>("./images/stone_single_bg.png")
    );
    public static final TileType GRASSWEEDS = new TileType( //added for grass
            new ConstantImageTileRenderer<>("./images/grassWeed.png"),false
    );
    public static ConstantImageTileRenderer getHotbarConstantImageTileRenderer(){ //added for hotbar
        return new ConstantImageTileRenderer<>("./images/hotbar.png");
    }
    public static ConstantImageTileRenderer getDirtConstantImageTileRenderer(){ //added for hotbar
        return new ConstantImageTileRenderer<>("./images/newRedDirt.png");
    }
    public static ConstantImageTileRenderer getStoneConstantImageTileRenderer(){//added for hotbar
        return new ConstantImageTileRenderer<>("./images/stone_single.png");
    }
    public static ConstantImageTileRenderer getHotbarSelectorConstantImageTileRenderer(){//added for hotbar
        return new ConstantImageTileRenderer<>("./images/hotbar_selection.png");
    }



}
