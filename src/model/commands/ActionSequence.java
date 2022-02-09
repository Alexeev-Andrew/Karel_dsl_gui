package model.commands;

import gui.GUI;
import model.Exceptions.KarelCrashedIntoTheWallException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ActionSequence implements Command, CommandWithBody{

    private ArrayList<Command> body;

    private GUI world;

    public ActionSequence(ArrayList<Command> body){
        this.body = body;
    }

    public ActionSequence(){
        this.body = new ArrayList<>();
    }

    @Override
    public void add(Command c){
        this.body.add(c);
    }

    @Override
    public void add(List<Command> c){
        for(Command command : c)
            this.body.add(command);
    }

    public void add(ArrayList<Command> cs){
        for(final Command c : cs)
            this.body.add(c);
    }

    public ArrayList<Command> getBody() {
        return body;
    }

    @Override
    public void execute() throws KarelCrashedIntoTheWallException {
        for(Command c : body){
            c.execute();
        }
    }

    public void setWorld(GUI world){
        this.world = world;
        for(Command c : body){
            c.setWorld(world);
        }
    }

    public GUI getWorld(){
        return this.world;
    }

}
