package model;

import gui.GUI;
import model.Exceptions.KarelCrashedIntoTheWallException;
import model.commands.ActionSequence;
import model.commands.Command;
import model.commands.CommandWithBody;
import model.commands.Function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Program implements CommandWithBody {

    private ActionSequence action_sequence; // action sequence of main function
    private HashMap<String, Function> function_declarations; // Key - name, Value - Function

    private GUI world;

    public Program(){
        action_sequence = new ActionSequence();
        function_declarations = new HashMap();
    }

    public Program(ActionSequence action_sequence, HashMap<String, Function> function_declarations){
        this.action_sequence = action_sequence;
        this.function_declarations = function_declarations;
    }

    public void execute() throws KarelCrashedIntoTheWallException {
        for(Command action : action_sequence.getBody())
            action.execute();
    }

    @Override
    public void add(Command c) {
        action_sequence.add(c);
    }

    @Override
    public void add(List<Command> c) {
        action_sequence.add(c);
    }

    public ActionSequence getAction_sequence() {
        return action_sequence;
    }

    public GUI getWorld() {
        return world;
    }

    public void setWorld(GUI world) {
        this.world = world;
        action_sequence.setWorld(world);
    }
}
