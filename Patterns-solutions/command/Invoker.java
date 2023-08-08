package net.media.training.designpattern.command;

import java.util.ArrayList;
import java.util.List;

public class Invoker {
    private final List<Command> commands = new ArrayList<>();
    private Command command;

    public void SetCommand(Command command) {
        this.command = command;
    }

    public void invokeExecution() {
        command.execute();
        commands.add(command);
    }

    public void undoExecution() {
        for (int i = commands.size() - 1; i >= 0; i--) {
            commands.get(i).undo();
        }
    }

}
