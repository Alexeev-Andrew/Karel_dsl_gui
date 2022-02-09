package model;

public class Karel extends WorldObject{

    private int direction; // 0,1,2,3

    public Karel(){
        direction = 1; // east
    }

    public Karel(int direction){
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}
