import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidParameterException;

public class ConstantImageTileRenderer<TileTypeT extends AbstractTileType<?>> extends TileRenderer<TileTypeT> {
    private Image image;

    public ConstantImageTileRenderer(Image image){
        this.image = image;
    }


    public ConstantImageTileRenderer(String path){
        try {
            InputStream resource = getClass().getResourceAsStream(path);
            if(resource == null) throw new InvalidParameterException("Could not find image at \"" + path + "\"");
            image = ImageIO.read(resource);
        }
        catch (IOException e){
            throw new RuntimeException("Reading the file threw an IOException");
        }
    }

    @Override
    public void render(Renderer r, Chunk.Tilemap<TileTypeT> tilemap, int localPosX, int localPosY) {
        r.drawImageWorldSpace(
                image,
                tilemap.getChunk().toGlobalPosX(localPosX),
                tilemap.getChunk().toGlobalPosY(localPosY),
                1,1
        );
    }
    public Image getImage() { //added
        return image;
    }
}
