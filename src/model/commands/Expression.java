package model.commands;

import gui.GUI;
import model.World;

public enum Expression implements LogicalExpression{
    FRONT_IS_CLEAR("frontIsClear()"),
    FRONT_IS_BLOCKED("frontIsBlocked()"),
    LEFT_IS_CLEAR("leftIsClear()"),
    LEFT_IS_BLOCKED("leftIsBlocked()"),
    RIGHT_IS_CLEAR("rightIsClear()"),
    RIGHT_IS_BLOCKED("rightIsBlocked()"),
    BEEPER_PRESENT("beepersPresent()"),
    FACING_NORTH("facingNorth()"),
    FACING_EAST("facingEast()"),
    FACING_SOUTH("facingSouth()"),
    FACING_WEST("facingWest()"),
    TRUE("true"),
    FALSE("false");

    private final String key;

    private GUI world;

    Expression(final String key){
        this.key = key;
        this.world = null;
    }

    public String getKey() {
        return this.key;
    }

    public static Expression getByKey(final String key) {
        for (final Expression action : Expression.values()) {
            if (action.getKey().equals(key)) {
                return action;
            }
        }

        return null;
    }

    @Override
    public boolean execute(){
        boolean res = false;
        switch(this){
            case FRONT_IS_BLOCKED:
                res =  world.getWorld().frontIsBlocked(world.getKarel());
                break;
            case FRONT_IS_CLEAR:
                res =  world.getWorld().frontIsClear(world.getKarel());
                break;
            case LEFT_IS_BLOCKED:
                res =  world.getWorld().leftIsBlocked(world.getKarel());
                break;
            case LEFT_IS_CLEAR:
                res =  world.getWorld().leftIsClear(world.getKarel());
                break;
            case RIGHT_IS_BLOCKED:
                res =  world.getWorld().rightIsBlocked(world.getKarel());
                break;
            case RIGHT_IS_CLEAR:
                res =  world.getWorld().rightIsClear(world.getKarel());
                break;
            case FACING_EAST:
                res =  world.getWorld().facingEast(world.getKarel());
                break;
            case FACING_NORTH:
                res =  world.getWorld().facingNorth(world.getKarel());
                break;
            case FACING_SOUTH:
                res =  world.getWorld().facingSouth(world.getKarel());
                break;
            case FACING_WEST:
                res =  world.getWorld().facingWest(world.getKarel());
                break;
        }
        return res;
    }

    public void setWorld(GUI world){
        this.world = world;
    }

    public GUI getWorld() {
        return this.world;
    }

}
