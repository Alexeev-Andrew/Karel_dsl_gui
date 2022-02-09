package model.commands;

import gui.GUI;

public interface LogicalExpression {
    boolean execute();

    void setWorld(GUI world); // for gui interpretator
    GUI getWorld();
}
