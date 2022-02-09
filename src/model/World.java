package model;

public class World {

    private final int sizeX;
    private int sizeY;
    private WorldObject[][] objects; // (x,y) - object in this cell

    public World(int sizeX, int sizeY, WorldObject[][] objects){
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.objects = objects;
    }


    public World(){
        sizeX = 5;
        sizeY = 5;
        objects = new WorldObject[5][5];
        // todo: fill with default values
    }



    public int getSizeY() {
        return sizeY;
    }

    public int getSizeX() {
        return sizeX;
    }

    public WorldObject[][] getObjects() {
        return objects;
    }

    public boolean runCommand(String command){
        // TODO: add logic
        return true;
    }

}
