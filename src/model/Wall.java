package model;

public class Wall extends WorldObject{

    private int walls; // 0000 -> no walls; 1101 -> cell contains top, right and left walls, but not down

    public Wall(){
        walls = 0;
    }

    public Wall(int walls){
        this.walls = walls;
    }

    public int getWalls() {
        return walls;
    }

    public void setWalls(int walls) {
        this.walls = walls;
    }
}
