package model.commands;

import gui.GUI;
import model.Exceptions.KarelCrashedIntoTheWallException;

public interface Command {

    void execute() throws KarelCrashedIntoTheWallException;
    void setWorld(GUI world); // for gui interpretator
    GUI getWorld();
}
