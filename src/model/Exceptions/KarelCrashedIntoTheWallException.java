package model.Exceptions;


import gui.GUI;

public class KarelCrashedIntoTheWallException extends Exception{

    private GUI world;
    private static final String message = "Karel crashed into the wall";

    public KarelCrashedIntoTheWallException(GUI world) {
        super(message + "; Karel coordinates: x:"+world.getKarel().getX_cell() + ", y: "+ world.getKarel().getY_cell());
        this.world = world;
    }

}
