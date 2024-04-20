import com.sun.source.tree.BreakTree;

public class Chunk extends GameObject {
    public class Tilemap<TileTypeT extends AbstractTileType<?>>{
        private final TileTypeT[][] tiles;

        private Tilemap(TileTypeT[][] tiles){
            this.tiles = tiles;
        }

        public Chunk getChunk(){
            return Chunk.this;
        }

        public TileTypeT getTile(int x, int y){
            return tiles[x][y];
        }

        public TileTypeT getTile(Vector2Int pos){
            return getTile(pos.x, pos.y);
        }
        public void setTile(int x, int y, TileTypeT value){
            tiles[x][y] = value;
        }
        public void getTile(Vector2Int pos, TileTypeT value){
            setTile(pos.x, pos.y, value);
        }
    }
    public static final int CHUNK_SIZE = 64;

    public final Vector2Int chunkPos;
    public final Vector2Int globalChunkPos;

    public final Tilemap<TileType> mainTilemap;
    public final Tilemap<BackgroundTileType> backgroundTilemap;

    public Chunk(Vector2Int chunkPos){
        this.chunkPos = chunkPos;
        globalChunkPos = chunkPos.scale(CHUNK_SIZE);

        mainTilemap = new Tilemap<>(new TileType[CHUNK_SIZE][CHUNK_SIZE]);
        backgroundTilemap = new Tilemap<>(new BackgroundTileType[CHUNK_SIZE][CHUNK_SIZE]);
    }

    public int toGlobalPosX(int x){
        return globalChunkPos.x + x;
    }

    public int toGlobalPosY(int y){
        return globalChunkPos.y + y;
    }

    public Vector2Int toGlobalPos(Vector2Int local){
        return new Vector2Int(toGlobalPosX(local.x), toGlobalPosY(local.y));
    }

    @Override
    public void render(Renderer r) {
        for (int x = 0; x < CHUNK_SIZE; x++) {
            for (int y = 0; y < CHUNK_SIZE; y++) {
                BackgroundTileType bgTile = backgroundTilemap.getTile(x, y);
                if(bgTile != null) bgTile.render(r, backgroundTilemap, x, y);

                TileType tile = mainTilemap.getTile(x, y);
                if(tile != null) tile.render(r, mainTilemap, x, y);
            }
        }
    }

    @Override
    public void tick() {

    }
}
