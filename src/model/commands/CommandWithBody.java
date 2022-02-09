package model.commands;

import java.util.List;

// interface for ForLoop/if/while, that can have multiple commands in their bodies
public interface CommandWithBody {
    void add(Command c);
    void add(List<Command> c);
}
