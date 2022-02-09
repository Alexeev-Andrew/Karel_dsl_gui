package builders;
import model.*;

public class WorldGenerator {

    private Karel karel;
    private WorldObject[][] objects; // (x,y) - object in this cell
    private int world_length;
    private int world_height;

    private static final int default_width = 5;
    private static final int default_height = 5;

    public static Builder newBuilder(){
        return new WorldGenerator().new Builder();
    }

    public class Builder{
        public Builder initialize(int x, int y){
            WorldGenerator.this.world_length = x;
            WorldGenerator.this.world_height = y;
            if(WorldGenerator.this.objects == null)
                generateWorld(x, y);

            return this;
        }

        public Builder karel(Karel karel, int x, int y) {
            if(WorldGenerator.this.objects == null)
                generateWorld(default_width, default_height);

            WorldGenerator.this.karel = karel;
            WorldGenerator.this.objects[x][y] = karel;
            return this;
        }

        public Builder wall(Wall wall, int x, int y) {
            if(WorldGenerator.this.objects == null)
                generateWorld(default_width, default_height);

            WorldGenerator.this.objects[x][y] = wall;
            return this;
        }

        public Builder bipper(Bipper bipper, int x, int y){
            if(WorldGenerator.this.objects == null)
                generateWorld(default_width, default_height);

            WorldGenerator.this.objects[x][y] = bipper;
            return this;
        }

        public World build() {
            return new World(world_length, world_height, objects);
        }


        private void generateWorld(int x, int y){
            WorldGenerator.this.objects = new WorldObject[x][y];
        }
    }


}
