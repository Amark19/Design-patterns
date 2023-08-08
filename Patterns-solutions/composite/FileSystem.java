package net.media.training.designpattern.composite;

import java.util.List;

public interface FileSystem {
    int getSize();
    boolean exists(String name);
    public String getName();
    void setParent(Directory parent);
    Directory getParent();


}