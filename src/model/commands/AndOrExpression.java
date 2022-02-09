package model.commands;

import gui.GUI;

import java.util.ArrayList;
import java.util.List;

public class AndOrExpression implements LogicalExpression {
    public enum Type{
        OR,
        AND;
    };

    private final Type type;

    private GUI world;

    private List<LogicalExpression> exps = new ArrayList<>();

    public AndOrExpression(final Type type, Expression exp1, Expression exp2){
        this.type = type;
    }

    public AndOrExpression(final Type type){
        this.type = type;
    }

    public List<LogicalExpression> getExpressions() {
        return exps;
    }


    public boolean execute(){
        boolean res = false;

        switch (this.type){
            case AND:
                res = true;
                for(LogicalExpression ex : exps){
                    res = res && ex.execute();
                }
                break;
            case OR:
                res = false;
                for(LogicalExpression ex : exps){
                    res = res || ex.execute();
                }
                break;
            default:
                break;
        }

        return res;
    }

    public Type getType() {
        return this.type;
    }

    public void setWorld(GUI world){
        this.world = world;
        for(LogicalExpression c : exps){
            c.setWorld(world);
        }
    }

    public GUI getWorld(){
        return this.world;
    }
}
