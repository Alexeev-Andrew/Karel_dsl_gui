package model.commands;

import gui.GUI;
import model.Exceptions.KarelCrashedIntoTheWallException;
import model.World;

import java.util.ArrayList;
import java.util.List;

public class WhileLoop implements Command, CommandWithBody {

    private LogicalExpression condition;
    private ActionSequence body_actions;

    private GUI world;

    public WhileLoop(LogicalExpression condition, ActionSequence body_actions){
        this.condition = condition;
        this.body_actions = body_actions;
        this.world = null;
    }

    public WhileLoop(){
        body_actions = new ActionSequence();
    }

    public LogicalExpression getCondition() {
        return condition;
    }

    public void setCondition(LogicalExpression condition) {
        this.condition = condition;
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
        while(condition.execute()){
            for(Command action : body_actions.getBody())
                action.execute();
        }
    }

    public void setWorld(GUI world){
        this.world = world;
        body_actions.setWorld(world);
        condition.setWorld(world);
    }

    public GUI getWorld(){
        return this.world;
    }

}
