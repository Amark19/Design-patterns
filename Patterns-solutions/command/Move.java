package net.media.training.designpattern.command;

import java.io.File;

public class Move implements Command {
    private String source;
    private String destination;

    public Move(String source, String destination) {
        this.source = source;
        this.destination = destination;
    }

    public void execute() {
        File file = new File(source);
        if (!file.exists())
            throw new RuntimeException("File does not exist");
        if (!file.renameTo(new File(destination)))
            throw new RuntimeException("Rename failed");
    }

    public void undo() {
        File file = new File(destination);
        if (!file.exists())
            throw new RuntimeException("File does not exist");
        if (!file.renameTo(new File(source)))
            throw new RuntimeException("Rename failed");
    }
}
