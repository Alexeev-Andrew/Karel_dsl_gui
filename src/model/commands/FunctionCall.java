package model.commands;

import gui.GUI;
import model.Exceptions.KarelCrashedIntoTheWallException;

public class FunctionCall implements Command {

    private String name;
    private Function function;

    private GUI world;

    @Override
    public void execute() throws KarelCrashedIntoTheWallException {
        function.execute();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    public void setWorld(GUI world){
        this.world = world;
    }

    public GUI getWorld(){
        return this.world;
    }
}
