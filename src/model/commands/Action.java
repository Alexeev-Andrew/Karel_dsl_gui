package model.commands;

import gui.GUI;
import model.Exceptions.KarelCrashedIntoTheWallException;
import model.World;

public enum Action implements Command {
    MOVE("move()"),
    TURN_LEFT("turnLeft()"),
    PICK_BEEPER("pickBeeper()"),
    PUT_BEEPER("putBeeper()");

    private final String key;
    private GUI world;

    Action(final String key){
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }

    public static Action getByKey(final String key) {
        for (final Action action : Action.values()) {
            if (action.getKey().equals(key)) {
                return action;
            }
        }

        return null;
    }

    public void execute() throws KarelCrashedIntoTheWallException {
        switch(this){
            case MOVE:
                world.getKarel().moveForvard();
                break;
            case TURN_LEFT:
                world.getKarel().rotateLeft();
                break;
            case PUT_BEEPER:
                world.getKarel().putBeeper();
                break;
        }

    }

    public void setWorld(GUI world){
        this.world = world;
    }

    public GUI getWorld(){
        return this.world;
    }

}
