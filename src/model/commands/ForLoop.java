package model.commands;

import gui.GUI;
import model.Exceptions.KarelCrashedIntoTheWallException;
import model.World;

import java.util.ArrayList;
import java.util.List;

public class ForLoop implements Command, CommandWithBody {

    private int i;
    private ActionSequence body_actions;

    private GUI world;

    public ForLoop(int i, ActionSequence body_actions){
        this.i = i;
        this.body_actions = body_actions;
        this.world = null;
    }

    public ForLoop(int i){
        this.i = i;
        this.body_actions = new ActionSequence();
        this.world = null;
    }

    public ActionSequence getBody_actions() {
        return body_actions;
    }

    public void setBody_actions(ActionSequence body_actions) {
        this.body_actions = body_actions;
    }

    public void add(Command c){
        body_actions.add(c);
    }

    public void add(List<Command> c){
        body_actions.add(c);
    }

    public void execute() throws KarelCrashedIntoTheWallException {
        for(int i = 0; i < this.i; i++){
            for(Command action : body_actions.getBody())
                action.execute();
        }
    }

    public void setWorld(GUI world){
        this.world = world;
        body_actions.setWorld(world);
    }

    public GUI getWorld(){
        return this.world;
    }

}
