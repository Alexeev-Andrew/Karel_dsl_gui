package model.commands;

import model.Exceptions.KarelCrashedIntoTheWallException;
import model.World;

import java.util.ArrayList;
import java.util.List;

public class Function implements CommandWithBody {

    private ArrayList<FunctionParameter> arguments;
    private ActionSequence body_actions;

    private World world;

    public Function(ArrayList<FunctionParameter> arguments, ActionSequence body_actions){
        this.arguments = arguments;
        this.body_actions = body_actions;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public void execute() throws KarelCrashedIntoTheWallException {
        for(Command action : body_actions.getBody())
            action.execute();
    }

    public ArrayList<FunctionParameter> getArguments() {
        return arguments;
    }

    public void setArguments(ArrayList<FunctionParameter> arguments) {
        this.arguments = arguments;
    }

    public ActionSequence getBody_actions() {
        return body_actions;
    }

    public void setBody_actions(ActionSequence body_actions) {
        this.body_actions = body_actions;
    }

    public World getWorld() {
        return world;
    }

    @Override
    public void add(Command c) {
        body_actions.add(c);
    }

    @Override
    public void add(List<Command> c) {
        body_actions.add(c);
    }
}
