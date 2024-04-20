public class TileType extends AbstractTileType<TileType>{
    public TileType(TileRenderer<TileType> renderer) {
        super(renderer);
    }

    public void processCollision(Collider collider, Chunk.Tilemap<TileType> tilemap, Vector2Int localPos){
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

        //top face of block
        if(Util.trianglesIntersect(bCenter, bTopLeft, bTopRight, cCenter, cBottomRight, cBottomLeft)){
            newCenter = newCenter.withY(gPos.y - semiSize.y);
            collider.onBottomCollide();
        }

        //right face of block
        if(Util.trianglesIntersect(bCenter, bTopRight, bBottomRight, cCenter, cBottomLeft, cTopLeft)){
            newCenter = newCenter.withX(gPos.x + semiSize.y + 1);
            collider.onLeftCollide();
        }

        //bottom face of block
        if(Util.trianglesIntersect(bCenter, bBottomRight, bBottomLeft, cCenter, cTopLeft, cTopRight)){
            newCenter = newCenter.withY(gPos.y + semiSize.y + 1);
            collider.onTopCollide();
        }

        //left face of block
        if(Util.trianglesIntersect(bCenter, bBottomLeft, bTopLeft, cCenter, cTopRight, cBottomRight)){
            newCenter = newCenter.withX(gPos.x - semiSize.x);
            collider.onRightCollide();
        }

        collider.setCenter(newCenter);
    }
}
