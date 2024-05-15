public abstract class Collider {
    public abstract Vector2 getCenter();
    public abstract void setCenter(Vector2 value);

    public abstract Vector2 getSize();

    public void onBottomCollide(){}
    public void onRightCollide(){}
    public void onTopCollide(){}
    public void onLeftCollide(){}

    public Vector2 getSemiSize(){
        return getSize().scale(0.5f);
    }

    public void processCollisionWithTerrain(){
        Vector2 center = getCenter();
        Vector2 semiSize = getSemiSize();

        Vector2Int bottomLeft = center.sub(semiSize).floorToInt();
        Vector2Int topRight = center.add(semiSize).floorToInt();

        for (int x = bottomLeft.x; x <= topRight.x; x++) {
            //reverse for loop here makes the collider prefer going up when stuck in walls instead of down
            for (int y = topRight.y; y > bottomLeft.y - 1; y--) {
                Vector2Int tilePos = new Vector2Int(x, y);
                Chunk chunk = World.getChunkGlobal(tilePos);
                Vector2Int localPos = chunk.toLocalPos(tilePos);
                TileType mainTile = chunk.mainTilemap.getTile(localPos);

                if(mainTile != null) mainTile.processCollision(this, chunk.mainTilemap, localPos);
            }
        }
    }

}

