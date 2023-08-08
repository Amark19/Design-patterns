package net.media.training.designpattern.command;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Create implements Command {
    private String fileName;
    private String content;

    public Create(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
    }

    public void execute() {
        File file = new File(fileName);
        if (file.exists())
            throw new RuntimeException("File already exist");
        try {
            file.createNewFile();
            PrintWriter writer = new PrintWriter(file);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void undo() {
        File file = new File(fileName);
        file.delete();
    }
}
