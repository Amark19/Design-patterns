package net.media.training.designpattern.command;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 20, 2011
 * Time: 4:55:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorldManipulator {

    public void fixManipulate(final String fileName, final String newPath) {
        Invoker invoker = new Invoker();
        try {
            invoker.SetCommand(new Create(fileName, "hello world"));
            invoker.invokeExecution();
            invoker.SetCommand(new Update(fileName, "new hello world"));
            invoker.invokeExecution();
            invoker.SetCommand(new Move(fileName, newPath));
            invoker.invokeExecution();
        } catch (Exception e) {
            invoker.undoExecution();
        }
    }
    
    public void brokenManipulate(String fileName, String newPath) {
        Invoker invoker = new Invoker();
        try {
            invoker.SetCommand(new Create(fileName, "hello world"));
            invoker.invokeExecution();
            invoker.SetCommand(new Update(fileName, "new hello world"));
            invoker.invokeExecution();
            invoker.SetCommand(new Move(fileName, newPath));
            invoker.invokeExecution();
            invoker.SetCommand(new Create(fileName, "hello world"));
            invoker.invokeExecution();
            invoker.SetCommand(new Create(fileName, "hello world"));
            invoker.invokeExecution();
        } catch (Exception e) {
            invoker.undoExecution();
        }

    }

}
