package net.media.training.designpattern.command;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Update implements Command{

    private String fileName;
    private String content;

    public Update(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
    }

    public void execute() {
        File file = new File(fileName);
        if (!file.exists())
            throw new RuntimeException("File: " + fileName + " does not exist");
        try {

            PrintWriter writer = new PrintWriter(file);
            writer.write(content);
            writer.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void undo() {
        throw new RuntimeException("Undo not supported");
    }
}
