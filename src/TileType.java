import java.awt.*;

public class TileType extends AbstractTileType<TileType>{
    public final BackgroundTileType backgroundType;
    public boolean shouldCollide=true;

    private TileType(TileRenderer<TileType> renderer, BackgroundTileType backgroundType) {
        super(renderer);
        this.backgroundType = backgroundType;
        this.shouldCollide=true;

    }
    private TileType(TileRenderer<TileType> renderer, BackgroundTileType backgroundType,boolean shouldCollide) {
        super(renderer);
        this.backgroundType = backgroundType;
        this.shouldCollide=shouldCollide;

    }

    public TileType(TileRenderer<TileType> renderer) {
        this(renderer, (BackgroundTileType) null);
    }
    public TileType(TileRenderer<TileType> renderer,boolean shouldCollide) {
        this(renderer, (BackgroundTileType) null);
        this.shouldCollide=shouldCollide;

    }


    public TileType(TileRenderer<TileType> renderer, TileRenderer<BackgroundTileType> bgRenderer){
        super(renderer);
        this.backgroundType = new BackgroundTileType(bgRenderer, this);
    }


    public void processCollision(Collider collider, Chunk.Tilemap<TileType> tilemap, Vector2Int localPos){
        if(!shouldCollide){
            return;
        }
        Vector2Int gPos = tilemap.getChunk().toGlobalPos(localPos);
        Vector2 bCenter = new Vector2(gPos.x + 0.5f, gPos.y + 0.5f);
        Vector2 bBottomLeft = new Vector2(gPos.x, gPos.y + 1);
        Vector2 bBottomRight = new Vector2(gPos.x+1, gPos.y + 1);
        Vector2 bTopLeft = new Vector2(gPos.x, gPos.y);
        Vector2 bTopRight = new Vector2(gPos.x+1, gPos.y);

        Vector2 cCenter = collider.getCenter();
        Vector2 semiSize = collider.getSize().scale(0.5f);

        Vector2 cBottomLeft = new Vector2(cCenter.x - semiSize.x, cCenter.y + semiSize.y);
        Vector2 cBottomRight = new Vector2(cCenter.x + semiSize.x, cCenter.y + semiSize.y);
        Vector2 cTopLeft = new Vector2(cCenter.x - semiSize.x, cCenter.y - semiSize.y);
        Vector2 cTopRight = new Vector2(cCenter.x + semiSize.x, cCenter.y - semiSize.y);

        Vector2 newCenter = new Vector2(cCenter.x, cCenter.y);

        //right face of block
        if(Util.trianglesIntersect(bCenter, bTopRight, bBottomRight, cCenter, cBottomLeft, cTopLeft)){
            newCenter = newCenter.withX(gPos.x + semiSize.x + 1);
            collider.onLeftCollide();
        }

        //left face of block
        if(Util.trianglesIntersect(bCenter, bBottomLeft, bTopLeft, cCenter, cTopRight, cBottomRight)){
            newCenter = newCenter.withX(gPos.x - semiSize.x);
            collider.onRightCollide();
        }

        //bottom face of block
        if(Util.trianglesIntersect(bCenter, bBottomRight, bBottomLeft, cCenter, cTopLeft, cTopRight)){
            newCenter = newCenter.withY(gPos.y + semiSize.y + 1);
            collider.onTopCollide();
        }

        //top face of block
        if(Util.trianglesIntersect(bCenter, bTopLeft, bTopRight, cCenter, cBottomRight, cBottomLeft)){
            newCenter = newCenter.withY(gPos.y - semiSize.y);
            collider.onBottomCollide();
        }

        collider.setCenter(newCenter);
    }
}
