package net.media.training.designpattern.command;

import java.io.File;

public class Delete implements Command{
    private String fileName;

    public Delete(String fileName) {
        this.fileName = fileName;
    }

    public void execute() {
        File file = new File(fileName);
        file.delete();
    }

    public void undo() {
        throw new RuntimeException("Undo not supported");
    }
}
