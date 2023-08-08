package net.media.training.designpattern.command;

import java.util.ArrayList;
import java.util.List;

public class Invoker {
    private final List<Command> commands = new ArrayList<>();

    public void SetCommand(Command command) {
        commands.add(command);
    }

    public void invokeExecution() {

        for (Command command : commands) {
            command.execute();
        }
    }

    //function which can undo execution of that command which failed
    public void undoExecution() {
        for (int i = commands.size() - 1; i >= 0; i--) {
            commands.get(i).undo();
        }
    }
    

}
